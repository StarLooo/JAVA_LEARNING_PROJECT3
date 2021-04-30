package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {

    private final NameListService listSvc = new NameListService();
    private final TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        char menu_slc = '0';
        boolean loop_flag = true;
        while (loop_flag) {
            if (menu_slc != '1')
                showAllEmployees();
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出  请选择(1~4):");
            menu_slc = My_TSUtility.readMenuSelection();
            switch (menu_slc) {
                case '1':
                    showTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否退出(Y/N):");
                    char isExit = My_TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loop_flag = false;
                        System.out.println("退出成功");
                    }
                    break;
                default:
                    System.out.println("错误的操作，请重新选择");
            }
        }
    }

    // 显示所有员工信息
    private void showAllEmployees() {
        System.out.println("----------------------------------------------开发团队调度软件----------------------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees != null && employees.length > 0) {
            System.out.println("ID\t\t 姓名\t\t年龄\t\t\t 工资\t\t  职位\t   状态\t\t 奖金\t\t   股票\t\t 设备");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("请选择执行功能:");
        } else {
            System.out.println("暂时还没有任何员工！");
        }
    }

    // 查看团队列表
    private void showTeam() {
        System.out.println("--------------------------------------团队成员列表------------------------------------------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team != null && team.length > 0) {
            System.out.println("TID/ID\t  姓名\t\t 年龄\t 工资\t\t 职位\t\t奖金\t\t\t股票");
            for (Programmer programmer : team) {
                System.out.println(programmer.getDetailsForTeam());
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("暂时还没有任何团队成员！");
        }
    }

    // 添加团队成员
    private void addMember() {
        System.out.println("请输入想要添加到团队的员工的id:");
        int id = My_TSUtility.readInt();
        try {
            teamSvc.addMember(listSvc.getEmployee(id));
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        My_TSUtility.readReturn();
    }

    // 删除团队成员
    private void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = My_TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char yn = My_TSUtility.readConfirmSelection();
        if (yn != 'N') {
            try {
                this.teamSvc.removeMember(id);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败，原因：" + e.getMessage());
            }
            My_TSUtility.readReturn();
        }
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}

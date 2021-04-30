package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {

    private final Programmer[] team = new Programmer[MAX_NUM_MEMBER]; //保存开发团队成员
    private static int counter = 1; //给开发团队中成员唯一的编号memberId
    private static final int MAX_NUM_MEMBER = 5; //开发团队人数上限
    private static final int MAX_NUM_PROGRAMMER = 3; //开发团队程序员人数上限
    private static final int MAX_NUM_DESIGNER = 2; //开发团队设计师人数上限
    private static final int MAX_NUM_ARCHITECT = 1; //开发团队架构师人数上限
    private int total_mem = 0; //开发团队的现有实际人数
    private int total_prg = 0; //开发团队的现有实际程序员数
    private int total_des = 0; //开发团队的现有实际设计师数
    private int total_arc = 0; //开发团队的现有实际架构师数

    public TeamService() {
        super();
    }

    public Programmer[] getTeam() {
        Programmer[] exist_team = new Programmer[total_mem];
        if (total_mem >= 0)
            System.arraycopy(this.team, 0, exist_team, 0, total_mem);
        return exist_team;
    }

    public void addMember(Employee ne) throws TeamException {
        // 判断团队成员是否已满
        if (total_mem >= MAX_NUM_MEMBER) {
            throw new TeamException("团队人数已满，最多为" + MAX_NUM_MEMBER + "人,无法添加!");
        }

        // 判断该员工是否是开发人员(程序员、设计师或者架构师中的一种)
        if (!(ne instanceof Programmer)) {
            throw new TeamException("该成员不是开发成员，无法添加!");
        }
        Programmer np = (Programmer) ne;

        // 判断该员工是否已经在团队内
        if (isExist(np)) {
            throw new TeamException("该成员已经在团队内，无法添加!");
        }

        // 判断该员工是否忙碌或休假
        if (Status.BUSY.equals(np.getStatus())) {
            throw new TeamException("该员工正在忙碌状态，无法添加!");
        } else if (Status.VACATION.equals(np.getStatus())) {
            throw new TeamException("该员工正在休假，无法添加!");
        }

        // 判断团队成员中各类别员工数量是否过多
        if (np instanceof Architect) {
            if (total_arc < MAX_NUM_ARCHITECT) {
                total_arc++;
            } else {
                throw new TeamException("该团队中架构师已有" + total_arc + "名,无法添加!");
            }
        } else if (np instanceof Designer) {
            if (total_des < MAX_NUM_DESIGNER) {
                total_des++;
            } else {
                throw new TeamException("该团队中设计师已有" + total_des + "名,无法添加!");
            }
        } else {
            if (total_prg < MAX_NUM_PROGRAMMER) {
                total_prg++;
            } else {
                throw new TeamException("该团队中程序员已有" + total_des + "名,无法添加!");
            }
        }

        // 添加该员工到团队内
        np.setMemberId(counter++);
        np.setStatus(Status.BUSY);
        team[total_mem++] = np;

    }

    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total_mem; i++) {
            if (team[i].getMemberId() == memberId) {
                break;
            }
        }
        if (i == total_mem) {
            throw new TeamException("未找到指定的团队成员!");
        }
        team[i].setStatus(Status.FREE);
        team[i].setMemberId(0);
        for (int j = i + 1; j < total_mem; j++) {
            team[j - 1] = team[j];
        }
        team[--total_mem] = null;
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total_mem; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

}

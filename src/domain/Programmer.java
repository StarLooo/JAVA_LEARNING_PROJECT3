package domain;

import service.Status;

public class Programmer extends Employee {

    private int memberId; //团队id
    private Status status; //状态
    private Equipment equipment; //使用设备

    public Programmer() {
        super();
        this.status = Status.FREE;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status = Status.FREE;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return String.format("%-38s %-6s %s %-28s %-15s", getDetails(), "程序员", status, "", equipment);
    }

    public String getDetailsForTeam() {
        return String.format("%d %s %-2d %2s %-6s %s %-2d %4s %-6.1f %s %s",
                memberId, "/", getId(), "", getName(), "\t", getAge(), '\t', getSalary(), '\t', "程序员");
    }

}

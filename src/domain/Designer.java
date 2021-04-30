package domain;

public class Designer extends Programmer {

    private double bonus; //奖金

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return String.format("%-38s %-6s %s %4s %-7.1f %15s %-15s", getDetails(), "设计师", getStatus(), "",
                getBonus(), "", getEquipment().getDescription());
    }

    @Override
    public String getDetailsForTeam() {
        return String.format("%d %s %-2d %2s %-6s %s %-2d %4s %-6.1f %s %s %s %-7.1f", getMemberId(), "/",
                getId(), "", getName(), "\t", getAge(), '\t', getSalary(), '\t', "设计师", "\t   ", bonus);
    }

}

package domain;

public class Architect extends Designer {

    private int stock; //股票

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%-38s %-6s %s %4s %-7.1f %4s %5d %4s %-15s", getDetails(), "架构师", getStatus(), "",
                getBonus(), "", getStock(), "", getEquipment().getDescription());
    }

    @Override
    public String getDetailsForTeam() {
        return String.format("%d %s %-2d %2s %-6s %s %-2d %4s %-6.1f %s %s %s %-7.1f %3s %-5d", getMemberId(), "/", getId(), "",
                getName(), "\t", getAge(), '\t', getSalary(), '\t', "设计师", "\t   ", getBonus(), "", stock);
    }

}

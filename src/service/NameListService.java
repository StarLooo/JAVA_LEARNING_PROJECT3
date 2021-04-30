package service;

import domain.*;

public class NameListService {

    private final Employee[] employees;

    public NameListService() {
        this.employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < this.employees.length; ++i) {
            int position = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Integer.parseInt(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            switch (position) {
                case Data.EMPLOYEE:
                    this.employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = this.createEquipment(i);
                    this.employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    equipment = this.createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    this.employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = this.createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    this.employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
        }
    }

    private Equipment createEquipment(int index) {
        int eq_type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        String model_or_type;
        switch (eq_type) {
            case Data.PC:
                model_or_type = Data.EQIPMENTS[index][1];
                String display = Data.EQIPMENTS[index][2];
                return new PC(model_or_type, display);
            case Data.NOTEBOOK:
                model_or_type = Data.EQIPMENTS[index][1];
                double price = Integer.parseInt(Data.EQIPMENTS[index][2]);
                return new NoteBook(model_or_type, price);
            case Data.PRINTER:
                model_or_type = Data.EQIPMENTS[index][1];
                String name = Data.EQIPMENTS[index][2];
                return new Printer(model_or_type, name);
            default:
                System.out.println("NO EQUIPMENT");
                return null;
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到指定的员工！");
    }

}

package junit;

import domain.Employee;
import org.junit.jupiter.api.Test;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {

    @Test
    //Test the constructor and getAllEmployees
    public void testGetAllEmployee() {
        NameListService namelist_service = new NameListService();
        Employee[] employees = namelist_service.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    //Test the constructor and getEmployee
    public void testGetEmployee() {
        NameListService namelist_service = new NameListService();
        int i = 1;
        int j = 10;
        int k = 15;
        try {
            System.out.println(namelist_service.getEmployee(i));
            System.out.println(namelist_service.getEmployee(j));
            System.out.println(namelist_service.getEmployee(k));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}

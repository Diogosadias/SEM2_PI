package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;

import java.util.List;

public class ListEmployeesUI implements Runnable {

    public ListEmployeesUI () {

    }

    public void run() {
        RegisterEmployeeController rec = new RegisterEmployeeController();
        List<Employee> list  = rec.getCompany().getEmployeeStore().getEmployees();
        for (Employee e : list ) {
            System.out.println(e);
        }
    }

}

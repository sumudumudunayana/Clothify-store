package controller.dto_controllers;

import dto.Employee;
import javafx.collections.ObservableList;
import service.custom.EmployeeService;
import service.custom.impl.EmployeeServiceImpl;

public class EmployeeController {
    private final EmployeeService employeeService= new EmployeeServiceImpl();
    private static EmployeeController instance;
    private EmployeeController(){}

    public static EmployeeController getInstance() {
        return instance==null?instance=new EmployeeController():instance;
    }

    public boolean addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }


}

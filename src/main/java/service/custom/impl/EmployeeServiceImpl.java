package service.custom.impl;

import dto.Employee;
import javafx.collections.ObservableList;
import service.custom.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public ObservableList<Employee> getAllEmployees() {
        return null;
    }
}

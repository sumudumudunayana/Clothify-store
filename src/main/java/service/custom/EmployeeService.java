package service.custom;

import dto.Employee;
import javafx.collections.ObservableList;

public interface EmployeeService {
    boolean addEmployee(Employee employee);

    ObservableList<Employee> getAllEmployees();
}

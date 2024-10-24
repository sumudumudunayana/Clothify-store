package controller.form_controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Employee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EmployersFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> clmEmpAccNo;

    @FXML
    private TableColumn<?, ?> clmEmpAddress;

    @FXML
    private TableColumn<?, ?> clmEmpBranch;

    @FXML
    private TableColumn<?, ?> clmEmpContact;

    @FXML
    private TableColumn<?, ?> clmEmpDob;

    @FXML
    private TableColumn<?, ?> clmEmpGender;

    @FXML
    private TableColumn<?, ?> clmEmpId;

    @FXML
    private TableColumn<?, ?> clmEmpName;

    @FXML
    private TableColumn<?, ?> clmEmpNic;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private JFXTextField txtAccNo;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtBranch;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private DatePicker txtDob;

    @FXML
    private JFXTextField txtEmployeId;

    @FXML
    private JFXTextField txtEmployeName;

    @FXML
    private JFXComboBox<?> txtGender;

    @FXML
    private JFXTextField txtNic;

    EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

    @FXML
    void btnAddEmp(ActionEvent event) {

        Employee employee = new Employee(
          txtEmployeId.getText(),
          txtEmployeName.getText(),
          txtDob.getAccessibleText(),
          txtContactNumber.getText(),
          txtAddress.getText(),
          txtAccNo.getText(),
          txtBranch.getText(),
          txtNic.getText(),
          txtGender.getAccessibleText()
        );

        if (employeeService.addEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added !!").show();
        }


    }

    @FXML
    void btnDeleteEmp(ActionEvent event) {

    }

    @FXML
    void btnEmployeeBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadTable();
    }

    private void loadTable(){
        ObservableList<Employee> all = employeeService.getAllEmployees();
        all.forEach(employee -> {
            System.out.println(employee);
        });
        employeeTable.setItems(all);
    }

    @FXML
    void btnSearchEmp(ActionEvent event) {

    }

    @FXML
    void btnUpdateEmp(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

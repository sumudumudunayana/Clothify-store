package controller.form_controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.dto_controllers.EmployeeController;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private JFXTextField txtDob;

    @FXML
    private JFXTextField txtEmployeId;

    @FXML
    private JFXTextField txtEmployeName;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXTextField txtNic;

    EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

    @FXML
    void btnAddEmp(ActionEvent event) {

        Employee employee = new Employee(
          txtEmployeId.getText(),
          txtEmployeName.getText(),
          txtDob.getText(),
          txtContactNumber.getText(),
          txtAddress.getText(),
          txtAccNo.getText(),
          txtBranch.getText(),
          txtNic.getText(),
          txtGender.getText()
        );

        if (employeeService.addEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added !!").show();
        }


    }

    @FXML
    void btnDeleteEmp(ActionEvent event) {
        if (employeeService.deleteEmployee(txtEmployeId.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Not Deleted").show();
        }

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
    void btnViewEmp(ActionEvent event) {
        String employeeId = txtEmployeId.getText().trim();

        if (employeeId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee Id ").showAndWait();
        }else{
            Employee employee= EmployeeController.getInstance().searchEmployeeById(employeeId);
            if (employee==null){
                new Alert(Alert.AlertType.ERROR,"Employee Not Found ").showAndWait();
            }else {
                txtEmployeId.setEditable(false);
                txtEmployeName.setText(employee.getEmpName());
                txtNic.setText(employee.getEmpNic());
                txtDob.setText(employee.getEmpDob());
                txtAddress.setText(employee.getEmpAddress());
                txtContactNumber.setText(employee.getEmpCnumber());
                txtGender.setText(employee.getEmpGender());
                txtAccNo.setText(employee.getEmpAccNo());
                txtBranch.setText(employee.getEmpBranch());
            }
        }
    }

    @FXML
    void btnUpdateEmp(ActionEvent event) {
        Employee employee = new Employee(
                txtEmployeId.getText(),
                txtEmployeName.getText(),
                txtDob.getText(),
                txtContactNumber.getText(),
                txtAddress.getText(),
                txtAccNo.getText(),
                txtBranch.getText(),
                txtNic.getText(),
                txtGender.getText()
        );
        employeeService.updateEmployee(employee);

        if (employeeService.updateEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Updated!!").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Updated!!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        clmEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        clmEmpName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        clmEmpNic.setCellValueFactory(new PropertyValueFactory<>("empNic"));
        clmEmpDob.setCellValueFactory(new PropertyValueFactory<>("empDob"));
        clmEmpAddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));
        clmEmpContact.setCellValueFactory(new PropertyValueFactory<>("empCnumber"));
        clmEmpGender.setCellValueFactory(new PropertyValueFactory<>("empGender"));
        clmEmpAccNo.setCellValueFactory(new PropertyValueFactory<>("empAccNo"));
        clmEmpBranch.setCellValueFactory(new PropertyValueFactory<>("empBranch"));
        loadTable();
        employeeTable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));

    }

    private void setTextToValues(Employee newValue) {
        txtEmployeId.setText(newValue.getEmpId());
        txtEmployeName.setText(newValue.getEmpName());
        txtNic.setText(newValue.getEmpNic());
        txtDob.setText(newValue.getEmpDob());
        txtAddress.setText(newValue.getEmpAddress());
        txtContactNumber.setText(newValue.getEmpCnumber());
        txtGender.setText(newValue.getEmpGender());
        txtAccNo.setText(newValue.getEmpAccNo());
        txtBranch.setText(newValue.getEmpBranch());
    }



    private int num = 1;
    private void generateId(){

        String id="";
        if(num<10){
            id=("EM000"+ num++);
            txtEmployeId.setText(id);
        }else if(num<100){
            id=("EM00"+ num++);
            txtEmployeId.setText(id);
        }else if(num<1000){
            id=("EM0"+ num++);
            txtEmployeId.setText(id);
        }else if(num<10000){
            id="EM"+ num++;
            txtEmployeId.setText(id);
        }

    }


}

package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployersFormController {

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

    @FXML
    void btnAddEmp(ActionEvent event) {

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

    }

    @FXML
    void btnSearchEmp(ActionEvent event) {

    }

    @FXML
    void btnUpdateEmp(ActionEvent event) {

    }

}

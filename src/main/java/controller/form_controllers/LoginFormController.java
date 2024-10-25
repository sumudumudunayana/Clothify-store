package controller.form_controllers;

import com.jfoenix.controls.JFXTextField;
import controller.dto_controllers.EmployeeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.hibernate.Session;
import util.HibernateUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private JFXTextField txtPassWord;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    void btnLogin(ActionEvent event) {
        String email = txtUserName.getText();
        String password = txtPassWord.getText();
        Stage stage=new Stage();
        if (email.equals("sumudu") && password.equals("1234")){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
                new Alert(Alert.AlertType.INFORMATION,"Log In Successfully").showAndWait();
                stage.show();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,"LogIn Failed").showAndWait();
            }
        }else{
            if (EmployeeController.getInstance().authenticateEmployee(email, password)){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
                    new Alert(Alert.AlertType.INFORMATION,"Log In Successfully").showAndWait();
                     stage.show();
                } catch (IOException e) {
                    new Alert(Alert.AlertType.ERROR,"Login Failed").showAndWait();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Employee username or Password Mismatch").showAndWait();
            }

        }
    }

    @FXML
    void btnSignin(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/sign_in_form_controller.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Session sessionEmployee = HibernateUtil.getEmployeeSession();
        sessionEmployee.close();

    }


}

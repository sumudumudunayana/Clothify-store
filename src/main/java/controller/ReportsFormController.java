package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportsFormController {

    @FXML
    void btnAnnualReport(ActionEvent event) {

    }

    @FXML
    void btnDailyReport(ActionEvent event) {

    }

    @FXML
    void btnEmployeeReport(ActionEvent event) {

    }

    @FXML
    void btnInventoryReport(ActionEvent event) {

    }

    @FXML
    void btnMonthlyReport(ActionEvent event) {

    }

    @FXML
    void btnReportsBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSupplierReport(ActionEvent event) {

    }

}

package controller.form_controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderDetailsFormController {

    @FXML
    private TableColumn<?, ?> clmOrderDetailsContactNumber;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsCustomerName;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsDate;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsEmployeId;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsItemId;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsItemName;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsOrderId;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsPrice;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsQty;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsSize;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsTotal;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsTotalSpending;

    @FXML
    private TableColumn<?, ?> clmOrderDetailsType;

    @FXML
    private JFXTextField txtSearchOrderId;

    @FXML
    void btnOrderDetailsBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSearchOrderId(ActionEvent event) {

    }

}

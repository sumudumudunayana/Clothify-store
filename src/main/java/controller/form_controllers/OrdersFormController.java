package controller.form_controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersFormController {

    @FXML
    private TableColumn<?, ?> clmOrderItemId;

    @FXML
    private TableColumn<?, ?> clmOrderItemName;

    @FXML
    private TableColumn<?, ?> clmOrderQty;

    @FXML
    private TableColumn<?, ?> clmOrderSize;

    @FXML
    private TableColumn<?, ?> clmOrderTotalPrice;

    @FXML
    private TableColumn<?, ?> clmOrderType;

    @FXML
    private TableColumn<?, ?> clmOrderUnitPrice;

    @FXML
    private Label lblOrderTotalSpending;

    @FXML
    private JFXTextField txtCopntactNumber;

    @FXML
    private JFXTextField txtCustomerEmail;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private DatePicker txtOrderDate;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtOrderItemId;

    @FXML
    private JFXTextField txtOrderItemName;

    @FXML
    private JFXTextField txtOrderItemPrice;

    @FXML
    private JFXTextField txtOrderItemQty;

    @FXML
    private JFXTextField txtOrderItemSize;

    @FXML
    private JFXTextField txtOrderItemType;

    @FXML
    private JFXComboBox<?> txtPaymentMethod;

    @FXML
    void btnOrderAdd(ActionEvent event) {

    }

    @FXML
    void btnOrderPlace(ActionEvent event) {

    }

    @FXML
    void btnOrderRemove(ActionEvent event) {

    }

    @FXML
    void btnOrderSearch(ActionEvent event) {

    }

    @FXML
    void btnOrderUpdate(ActionEvent event) {

    }

    @FXML
    void btnOrdersBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

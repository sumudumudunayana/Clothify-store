package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class SuplyersFormController {

    @FXML
    private TableColumn<?, ?> clmSupplierCompanyName;

    @FXML
    private TableColumn<?, ?> clmSupplierContactNumber;

    @FXML
    private TableColumn<?, ?> clmSupplierId;

    @FXML
    private TableColumn<?, ?> clmSupplierItemId;

    @FXML
    private TableColumn<?, ?> clmSupplierItemName;

    @FXML
    private TableColumn<?, ?> clmSupplierItemQty;

    @FXML
    private TableColumn<?, ?> clmSupplierItemSize;

    @FXML
    private TableColumn<?, ?> clmSupplierName;

    @FXML
    private JFXTextField txtSearchSupplierId;

    @FXML
    private JFXTextField txtSupplierCompanyName;

    @FXML
    private JFXTextField txtSupplierContactNumber;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    void btnAddSupplier(ActionEvent event) {

    }

    @FXML
    void btnRemoveSupplier(ActionEvent event) {

    }

    @FXML
    void btnSearchSupplier(ActionEvent event) {

    }

    @FXML
    void btnSupplierBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnUpdateSupplier(ActionEvent event) {

    }

}

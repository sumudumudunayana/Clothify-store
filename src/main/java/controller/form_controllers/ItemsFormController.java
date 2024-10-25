package controller.form_controllers;

import com.jfoenix.controls.JFXTextField;
import controller.dto_controllers.ItemController;
import dto.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.ItemService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> clmItemId;

    @FXML
    private TableColumn<?, ?> clmName;

    @FXML
    private TableColumn<?, ?> clmPrice;

    @FXML
    private TableColumn<?, ?> clmQty;

    @FXML
    private TableColumn<?, ?> clmSize;

    @FXML
    private TableColumn<?, ?> clmType;

    @FXML
    private TableView<Item> itemTable;

    @FXML
    private JFXTextField txtItemId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtType;

    ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

    @FXML
    void btnAddItem(ActionEvent event) {
        Item item = new Item(
                txtItemId.getText(),
                txtName.getText(),
                txtQty.getText(),
                txtType.getText(),
                txtPrice.getText(),
                txtSize.getText()
        );

        if (itemService.addItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Added !!").show();
        }
        loadTable();

    }

    private void loadTable(){
        ObservableList<Item> all = itemService.getAll();
        itemTable.setItems(all);
    }


    @FXML
    void btnDeleteItem(ActionEvent event) {
        if (itemService.deleteItem(txtItemId.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Item Deleted").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Deleted").show();
        }

    }

    @FXML
    void btnSearchItem(ActionEvent event) {
        String itemId = txtItemId.getText().trim();

        if (itemId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Id ").showAndWait();
        }else{
            Item item= ItemController.getInstance().searchItem(itemId);
            if (item==null){
                new Alert(Alert.AlertType.ERROR,"Item Not Found ").showAndWait();
            }else {
                txtItemId.setEditable(false);
                txtName.setText(item.getItemName());
                txtQty.setText(String.valueOf(item.getItemQty()));
                txtType.setText(item.getItemType());
                txtPrice.setText(String.valueOf(item.getItemPrice()));
                txtSize.setText(String.valueOf(item.getItemSize()));
            }
        }

    }

    @FXML
    void btnUpdateItem(ActionEvent event) {
        Item item = new Item(
                txtItemId.getText(),
                txtName.getText(),
                txtQty.getText(),
                txtType.getText(),
                txtPrice.getText(),
                txtSize.getText()
        );

        itemService.updateItem(item);

        if (itemService.updateItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Updated!!").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Updated!!").show();
        }

    }

    @FXML
    void btnItemBack(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private int num = 1;
    private void generateId(){

        String id="";
        if(num<10){
            id=("IT000"+ num++);
            txtItemId.setText(id);
        }else if(num<100){
            id=("IT00"+ num++);
            txtItemId.setText(id);
        }else if(num<1000){
            id=("IT"+ num++);
            txtItemId.setText(id);
        }else if(num<10000){
            id="IT"+ num++;
            txtItemId.setText(id);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        clmItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        clmType.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        clmSize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        loadTable();
        itemTable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));


    }

    private void setTextToValues(Item newValue) {
        txtItemId.setText(newValue.getItemId());
        txtName.setText(newValue.getItemName());
        txtQty.setText(String.valueOf(newValue.getItemQty()));
        txtType.setText(newValue.getItemType());
        txtPrice.setText(String.valueOf(newValue.getItemPrice()));
        txtSize.setText(String.valueOf(newValue.getItemSize()));
    }
}

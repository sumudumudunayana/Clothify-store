package controller.form_controllers;

import com.jfoenix.controls.JFXTextField;
import controller.dto_controllers.ItemController;
import controller.dto_controllers.OrderController;
import dto.Cart;
import dto.Item;
import dto.Order;
import dto.OrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrdersFormController implements Initializable {

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
    private TableView<Cart> orderTable;

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
    private JFXTextField txtOrderDate;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private ComboBox<String> txtOrderItemId;

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
    private JFXTextField txtPaymentMethod;

    ObservableList<Cart> cart = FXCollections.observableArrayList();

    @FXML
    void btnOrderAdd(ActionEvent event) {
        clmOrderItemId.setCellValueFactory(new PropertyValueFactory<>("OrderItemId"));
        clmOrderItemName.setCellValueFactory(new PropertyValueFactory<>("OrderItemName"));
        clmOrderType.setCellValueFactory(new PropertyValueFactory<>("OrderItemType"));
        clmOrderSize.setCellValueFactory(new PropertyValueFactory<>("OrderItemSize"));
        clmOrderQty.setCellValueFactory(new PropertyValueFactory<>("OrderItemQty"));
        clmOrderUnitPrice.setCellValueFactory(new PropertyValueFactory<>("OrderItemPrice"));
        clmOrderTotalPrice.setCellValueFactory(new PropertyValueFactory<>("OrderItemTotalPrice"));

        String OrderItemId = txtOrderItemId.getValue().toString();
        String OrderItemName = txtOrderItemName.getText();
        String OrderItemType = txtOrderItemType.getText();
        String OrderItemSize = txtOrderItemSize.getText();
        Integer OrderItemQty = Integer.parseInt(txtOrderItemQty.getText());
        Double OrderItemPrice = Double.parseDouble(txtOrderItemPrice.getText());

        Double OrderItemTotalPrice = OrderItemPrice*OrderItemQty;

        cart.add(new Cart(OrderItemId,OrderItemName,OrderItemType,OrderItemSize,OrderItemQty,OrderItemPrice,OrderItemTotalPrice));
        calcNetTotal();

        orderTable.setItems(cart);
    }

    private void calcNetTotal(){
        Double total = 0.0;

        for(Cart cart1:cart){
            total+=cart1.getTotal();
        }

        lblOrderTotalSpending.setText(total.toString());
    }

    @FXML
    void btnOrderPlace(ActionEvent event) throws SQLException {
        String orderId = txtOrderId.getText();

        Order order=new Order(orderId,Double.parseDouble(lblOrderTotalSpending.getText()),txtCustomerName.getText(),txtCopntactNumber.getText());

        ObservableList <OrderDetails> orderDetails =  FXCollections.observableArrayList();

        cart.forEach(obj-> {
            orderDetails.add(new OrderDetails(order,obj.getOrderItemId(),obj.getOrderItemName(),obj.getOrderItemQty(),obj.getOrderItemPrice(),obj.getOrderItemSize()));
        });

        OrderController.getInstance().placeOrder(order,orderDetails);

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemIds();
        generateId();
        txtOrderItemId.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue)->{
            if (newValue!=null){
                textToTextFiels(newValue);
            }
        }));
    }

    private void loadItemIds(){
        ObservableList<String> ids = ItemController.getInstance().gettemIds();
        txtOrderItemId.setItems(ids);
    }


    private void textToTextFiels(String id) {
        Item item = ItemController.getInstance().searchItem(id);
        txtOrderItemName.setText(item.getItemName());
        txtOrderItemSize.setText(item.getItemSize());
        txtOrderItemPrice.setText(item.getItemPrice());
        txtOrderItemType.setText(item.getItemType());
    }


    private int num = 1;
    private void generateId(){

        String id="";
        if(num<10){
            id=("ORD000"+ num++);
            txtOrderId.setText(id);
        }else if(num<100){
            id=("ORD00"+ num++);
            txtOrderId.setText(id);
        }else if(num<1000){
            id=("ORD"+ num++);
            txtOrderId.setText(id);
        }else if(num<10000){
            id="ORD"+ num++;
            txtOrderId.setText(id);
        }

    }
}

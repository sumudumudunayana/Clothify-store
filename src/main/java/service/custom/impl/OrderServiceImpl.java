package service.custom.impl;

import dto.Order;
import dto.OrderDetails;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import repository.DaoFactory;
import repository.custom.OrderDao;
import service.custom.OrderService;
import util.DaoType;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao= DaoFactory.getInstance().getDaoType(DaoType.ORDER);

    @Override
    public ObservableList<OrderEntity> getAllOrders() {
        return null;
    }

    @Override
    public Boolean addOrder(Order order, ObservableList<OrderDetails> orderDetails) {
//        ObservableList<OrderDetailEntity> orderDetailEntities= FXCollections.observableArrayList();
//        orderDetails.forEach(orderDetail ->orderDetailEntities.add(new ModelMapper().map(orderDetail, OrderDetailEntity.class)));
//        OrderEntity orderEntity = new ModelMapper().map(order, OrderEntity.class);
//        orderEntity.setOrderDetails(orderDetailEntities);
//        return orderDao.save(orderEntity,orderDetailEntities);
        return false;
    }

    @Override
    public OrderEntity searchOrderById(String id) {
        return null;
    }

    @Override
    public boolean updateOrder(Order order, ObservableList<OrderDetails> orderDetails) {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        return false;
    }

}

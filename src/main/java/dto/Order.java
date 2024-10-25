package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private Double orderTotal;
    private String custName;
    private String custContact;

    private List<OrderDetails> orderDetailsList;

    public Order(String orderId, Double orderTotal, String custName, String custContact) {
        this.orderId = orderId;
        this.orderTotal = orderTotal;
        this.custName = custName;
        this.custContact = custContact;
    }


}

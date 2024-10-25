package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    private String OrderItemId;
    private String OrderItemName;
    private String OrderItemType;
    private String OrderItemSize;
    private Integer OrderItemQty;
    private Double OrderItemPrice;
    private Double OrderItemTotalPrice;

    public Double getTotal() {
        return 0.0;
    }
}

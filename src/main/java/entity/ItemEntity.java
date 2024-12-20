package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemEntity {
    @Id
    private String itemId;
    private String itemName;
    private String itemQty;
    private String itemType;
    private String itemPrice;
    private String itemSize;
}

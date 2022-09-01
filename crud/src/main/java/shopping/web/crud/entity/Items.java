package shopping.web.crud.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer id;

    @NotEmpty
    @Column(name="item_name",nullable=false)
    private String itemName;

    @NotEmpty
    @Column(name="item_price",nullable=false)
    private Long itemPrice;

    @NotEmpty
    @Column(name="item_type",nullable=false)
    private String itemType;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemType='" + itemType + '\'' +
                '}';
    }
}

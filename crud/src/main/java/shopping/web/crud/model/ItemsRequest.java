package shopping.web.crud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemsRequest {
    private String itemName;
    private Long itemPrice;
    private String itemType;
}

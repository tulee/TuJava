package shopping.web.crud.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemsDTO {
    private Integer id;
    private String itemName;
    private Long itemPrice;
    private String itemType;
}

package shopping.web.crud.service;

import shopping.web.crud.entity.Items;
import shopping.web.crud.model.ItemsDTO;
import shopping.web.crud.model.ItemsRequest;

import java.util.List;
import java.util.Optional;


public interface ItemsService {
    //search by item name
    List<ItemsDTO> findByItemsName(String term);

    //save item
    Items saveItems(Items item);

    //find all
    List<ItemsDTO> findAllItems();

    //delete item
    void deleteItems(Integer id);

    Optional<Items> updateItems(ItemsRequest itemsRequest,Integer id);

}

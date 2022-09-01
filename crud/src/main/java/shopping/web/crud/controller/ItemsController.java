package shopping.web.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.web.crud.entity.Items;
import shopping.web.crud.model.ItemsDTO;
import shopping.web.crud.model.ItemsRequest;
import shopping.web.crud.service.ItemsService;

import java.util.List;

@RestController
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @GetMapping("/items")
    public List<ItemsDTO> getAllItems(){
        return itemsService.findAllItems();
    }

    @DeleteMapping("/items")
    public void deleteItemsById(@RequestParam Integer id){
        itemsService.deleteItems(id);
    }

    @PostMapping("/items")
    public void saveItems(@RequestBody Items item){
        itemsService.saveItems(item);
    }

    @PutMapping("/items/{id}")
    public void editItems(@RequestBody ItemsRequest itemsRequest, @PathVariable Integer id){
        itemsService.updateItems(itemsRequest,id);
    }

    @PostMapping("/search-items")
    public List<ItemsDTO> searchItemsByName(@RequestParam String term){
        return itemsService.findByItemsName(term);
    }
}

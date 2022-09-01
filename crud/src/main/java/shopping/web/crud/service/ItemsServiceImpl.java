package shopping.web.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.web.crud.entity.Items;
import shopping.web.crud.entity.repository.ItemsRepository;
import shopping.web.crud.model.ItemsDTO;
import shopping.web.crud.model.ItemsRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemsServiceImpl implements ItemsService{
    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public List<ItemsDTO> findByItemsName(String term) {
        List<Items> items = itemsRepository.findByItemNameContaining(term);
        if(items.size() == 0){
            return new ArrayList<>();
        }else {
            return items.stream().map(item -> itemsDTOConverter(item)).collect(Collectors.toList());
        }
    }

    @Override
    public Items saveItems(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public List<ItemsDTO> findAllItems() {
        List<Items> items = itemsRepository.findAll();
        if(items.size() == 0){
            return new ArrayList<>();
        }else {
            return items.stream().map(item -> itemsDTOConverter(item)).collect(Collectors.toList());
        }
    }

    @Override
    public void deleteItems(Integer id) {
        itemsRepository.deleteById(id);
    }

    @Override
    public Optional<Items> updateItems(ItemsRequest itemsRequest, Integer id){
        Optional<Items> item = itemsRepository.findById(id);
        if(item.isPresent()){
            item.get().setItemName(itemsRequest.getItemName());
            item.get().setItemPrice(itemsRequest.getItemPrice());
            item.get().setItemType(itemsRequest.getItemType());
            itemsRepository.save(item.get());
        }
        return item;
    }

    public ItemsDTO itemsDTOConverter(Items item) {
        return ItemsDTO.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .itemPrice(item.getItemPrice())
                .itemType(item.getItemType())
                .build();
    }
}


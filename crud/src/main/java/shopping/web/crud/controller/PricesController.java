package shopping.web.crud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.web.crud.entity.Prices;
import shopping.web.crud.model.ItemsDTO;
import shopping.web.crud.service.PriceService;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PricesController {
    @Autowired
    PriceService priceService;

    @GetMapping("/getprice")
    public Prices getApiPrice() throws JsonProcessingException {
        return priceService.getApiPrice();
    }
}

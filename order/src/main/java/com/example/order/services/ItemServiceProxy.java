package com.example.order.services;

import com.example.order.models.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "item-service")
//@FeignClient(name="zuul-gateway-server")
//@RibbonClient(name="item-service")
//public interface ItemServiceProxy {
//    @GetMapping("item-service/api/item/items/{name}")
//    Item getItemByName(@PathVariable("name") String name);
//}

@FeignClient(name="item-service")
@RibbonClient(name="item-service")
public interface ItemServiceProxy {
    @GetMapping("api/item/items/{name}")
    Item getItemByName(@PathVariable("name") String name);
}

package com.project.Order.controller;

import com.project.Order.modal.Items;
import com.project.Order.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemsController {
    private static final Logger logger = LoggerFactory.getLogger(ItemsController.class);
    private ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    //*******************************************************************************************
    @PostMapping()
    public Items createItem(@RequestBody Items items){
        return itemsService.createService(items);
    }

    //**************************************************************************************
    @GetMapping()
    public Items findItem(@RequestParam(value = "id")Long itemId){
        return itemsService.findItem(itemId);
    }

    //**************************************************************************************
    @GetMapping("/all")
    public Iterable<Items> findAllItems(){
        return itemsService.findAll();
    }

    //***************************************************************************************
    @PutMapping()
    public Items updateItem(@PathVariable(value = "id")Long itemId,@RequestBody Items items){
        return itemsService.updateItem(itemId,items);
    }
}

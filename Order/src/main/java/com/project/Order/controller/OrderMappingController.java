package com.project.Order.controller;

import com.project.Order.modal.OrderMapping;
import com.project.Order.service.OrderMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ordermap")
public class OrderMappingController {
    private static final Logger logger = LoggerFactory.getLogger(OrderMappingController.class);
    private OrderMappingService orderMappingService;
    @Autowired
    public OrderMappingController(OrderMappingService orderMappingService) {
        this.orderMappingService = orderMappingService;
    }

    @PostMapping()
    public OrderMapping mapOrder(@RequestBody OrderMapping orderMapping){
        return orderMappingService.mapOrder(orderMapping);
    }
    @GetMapping()
    public OrderMapping getOrderMap(@RequestParam(value = "id")Long userId){
        return orderMappingService.getordermap(userId);
    }
}

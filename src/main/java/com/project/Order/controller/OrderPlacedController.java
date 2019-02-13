package com.project.Order.controller;

import com.project.Order.modal.OrderPlaced;
import com.project.Order.service.OrderPlacedService;
import com.project.Order.service.OrderUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderplaced")
public class OrderPlacedController {
    private static final Logger logger = LoggerFactory.getLogger(OrderPlacedController.class);

    private OrderPlacedService orderPlacedService;
    private final OrderUpdateService orderUpdateService;
    @Autowired
    public OrderPlacedController(OrderPlacedService orderPlacedService, OrderUpdateService orderUpdateService) {
        this.orderPlacedService = orderPlacedService;
        this.orderUpdateService = orderUpdateService;
    }

  @PostMapping()
    public OrderPlaced creteorderplace(@RequestBody OrderPlaced orderPlaced) {
      return orderPlacedService.creteOrderPlace(orderPlaced);
  }
  @GetMapping()
    public OrderPlaced findOrderPlaced(@RequestParam(value = "id")Long OrderPlacedId){
        return orderPlacedService.findOrderPlaced(OrderPlacedId);
  }

  @PutMapping("/{orderPlacedId}")
    public OrderPlaced UpdateOrder(@PathVariable Long orderPlacedId,@RequestBody OrderPlaced orderPlaced){
        return orderUpdateService.updateOrderById(orderPlacedId,orderPlaced);
  }
}

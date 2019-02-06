package com.project.Order.service;

import com.project.Order.modal.Items;
import com.project.Order.modal.OrderMapping;
import com.project.Order.modal.OrderPlaced;
import com.project.Order.repository.ItemsRepository;
import com.project.Order.repository.OrderMappingRepository;
import com.project.Order.repository.OrderPlacedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderMappingService {
    private OrderMappingRepository orderMappingRepository;
    private final OrderPlacedRepository orderPlacedRepository;
    private final ItemsRepository itemsRepository;
    @Autowired
    public OrderMappingService(OrderMappingRepository orderMappingRepository, OrderPlacedRepository orderPlacedRepository, ItemsRepository itemsRepository) {
        this.orderMappingRepository = orderMappingRepository;
        this.orderPlacedRepository = orderPlacedRepository;
        this.itemsRepository = itemsRepository;
    }

    public OrderMapping mapOrder(OrderMapping orderMapping) {
        Optional<Items> a = itemsRepository.findById(orderMapping.getItemId());
        Optional<OrderPlaced> b = orderPlacedRepository.findById(orderMapping.getOrderMappingId());
        if (orderMapping.getQuantity() >= 5) {
            System.out.println("maximum quantity is 5 for single user");
            return null;
        } else if (!a.isPresent()) {
            System.out.println("item not present");
            return null;
        } else if (!b.isPresent()) {
            System.out.println("Order not exists");
            return null;
        } else {
//            Product product =productRepository.findById(cart.getProduct_id()).get();
//            Integer total = cart.getQuantity() * product.getProduct_price();
//            cart.setTotal(total);
            OrderMapping cart1 = orderMappingRepository.save(orderMapping);
            return cart1;

        }    }

    public OrderMapping getordermap(Long userId) {
        return orderMappingRepository.findById(userId).get();
    }
}

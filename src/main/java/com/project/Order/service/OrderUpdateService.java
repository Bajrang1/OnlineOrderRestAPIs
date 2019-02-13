package com.project.Order.service;

import com.project.Order.modal.Items;
import com.project.Order.modal.OrderMapping;
import com.project.Order.modal.OrderPlaced;
import com.project.Order.modal.User;
import com.project.Order.repository.ItemsRepository;
import com.project.Order.repository.OrderMappingRepository;
import com.project.Order.repository.OrderPlacedRepository;
import com.project.Order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderUpdateService {
    private final OrderPlacedRepository orderPlacedRepository;
    private final OrderMappingRepository orderMappingRepository;
    private final ItemsRepository itemsRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderUpdateService(OrderPlacedRepository orderPlacedRepository, OrderMappingRepository orderMappingRepository, ItemsRepository itemsRepository, UserRepository userRepository) {
        this.orderPlacedRepository = orderPlacedRepository;
        this.orderMappingRepository = orderMappingRepository;
        this.itemsRepository = itemsRepository;
        this.userRepository = userRepository;
    }

    public OrderPlaced updateOrderById(Long orderPlacedId, OrderPlaced orderPlaced) {
        Optional<OrderPlaced> resp=orderPlacedRepository.findById(orderPlacedId);
        if (!resp.isPresent()) {
            System.out.println("OrderPlaced Id is not valid");
            return null;
        }
        User user = userRepository.findByUserId(orderPlaced.getUserId());
        if (user == null) {
            System.out.println("User id is not valid");
            return null;
        }
            OrderPlaced orderPlaced1 = resp.get();
            float total = 0;
            for (OrderMapping a : orderPlaced.getOrderTraceList()) {
                Items product = itemsRepository.findByItemId(a.getItemId());
                total = total + (a.getQuantity() * product.getItemPrice());
                a.setOrderPlacedId(orderPlacedId);
            }
            orderPlaced1.setTotal(total);
            orderPlaced1.setOrderTraceList(orderPlaced.getOrderTraceList());
            orderPlaced1.setUserList(orderPlaced.getUserList());
            orderPlacedRepository.save(orderPlaced1);
            return orderPlaced1;


//        orderPlaced1.setUserId(orderPlaced.getUserId());
//        orderPlacedRepository.save(orderPlaced);
//        orderMappingRepository.saveAll(orderPlaced.getOrderTraceList());
//        return orderPlaced;

    }
}

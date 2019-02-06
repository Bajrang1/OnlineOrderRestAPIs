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

import java.util.List;

@Service
public class OrderPlacedService {
    private OrderPlacedRepository orderPlacedRepository;
    private final ItemsRepository itemsRepository;
    private final OrderMappingRepository orderMappingRepository;
    private final UserRepository userRepository;
    @Autowired
    public OrderPlacedService(OrderPlacedRepository orderPlacedRepository, ItemsRepository itemsRepository, OrderMappingRepository orderMappingRepository, UserRepository userRepository) {
        this.orderPlacedRepository = orderPlacedRepository;
        this.itemsRepository = itemsRepository;
        this.orderMappingRepository = orderMappingRepository;
        this.userRepository = userRepository;
    }

    public OrderPlaced creteOrderPlace(OrderPlaced orderPlaced) {
       orderPlaced =orderPlacedRepository.save(orderPlaced);
        float total = 0;
        int count=0;
        for(OrderMapping a : orderPlaced.getOrderTraceList()){
            Items product = itemsRepository.findByItemId(a.getItemId());
            total = total + (a.getQuantity() * product.getItemPrice());
            a.setOrderPlacedId(orderPlaced.getOrderPlacedId());
            count+=1;
        }
        if(count<10){
            System.out.println("You have placed " +count+ " orders with us. Buy "+(10-count) +"  more stuff and you will be promoted to Gold customer and enjoy 10% discounts!");
            orderPlaced.setTotal(total);
            User users=userRepository.findByUserId(orderPlaced.getUserId());
            users.setCustomerType("Regular");

        }else if(count<=19){
            System.out.println("you are our Gold custmor and you get 10% discount. Now order "+(20-count)+" product for upgrade yourself Platinum user and get 20% discount");
            orderPlaced.setTotal(total-((total*10)/100));
            User users=userRepository.findByUserId(orderPlaced.getUserId());
            users.setCustomerType("Gold");


        }else{
            System.out.println("You got 20% discount .You are Platinum user");
            orderPlaced.setTotal(total-((total*20)/100));
            User users=userRepository.findByUserId(orderPlaced.getUserId());
            users.setCustomerType("Platinum");
        }


        orderPlacedRepository.save(orderPlaced);
        orderMappingRepository.saveAll(orderPlaced.getOrderTraceList());
        return orderPlaced;
    }

    public OrderPlaced findOrderPlaced(Long OrderPlacedId) {
        OrderPlaced orderPlaced=orderPlacedRepository.findById(OrderPlacedId).get();
        List<OrderMapping> orderMappingList = orderMappingRepository.findByOrderPlacedId(orderPlaced.getOrderPlacedId());

       int a= orderMappingList.size();


        orderPlaced.setOrderTraceList(orderMappingList);
        return orderPlaced;
    }
}

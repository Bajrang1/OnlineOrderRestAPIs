package com.project.Order.repository;

import com.project.Order.modal.OrderPlaced;
import org.springframework.data.repository.CrudRepository;

public interface OrderPlacedRepository extends CrudRepository<OrderPlaced,Long>{
    int countByUserId(Long userId);
}

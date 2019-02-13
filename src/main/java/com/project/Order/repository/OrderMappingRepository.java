package com.project.Order.repository;

import com.project.Order.modal.OrderMapping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderMappingRepository extends CrudRepository<OrderMapping,Long> {


    List<OrderMapping> findByOrderPlacedId(Long orderPlacedId);
}

package com.project.Order.repository;

import com.project.Order.modal.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items,Long> {

    Items findByItemId(Long itemId);
}

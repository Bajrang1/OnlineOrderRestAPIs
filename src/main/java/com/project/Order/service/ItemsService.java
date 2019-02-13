package com.project.Order.service;

import com.project.Order.modal.Items;
import com.project.Order.repository.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsService {
    private ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }
//*****************************************************************************************************************

    public Items createService(Items items) {
        return itemsRepository.save(items);
    }

    public Items findItem(Long itemId) {
        return itemsRepository.findByItemId(itemId);
    }

    public Iterable<Items> findAll() {
        return itemsRepository.findAll();
    }

    public Items updateItem(Long itemId, Items items) {
        Items items1=itemsRepository.findByItemId(itemId);
        items1.setItemName(items.getItemName());
        items1.setItemPrice(items.getItemPrice());
        return items1;
    }
}

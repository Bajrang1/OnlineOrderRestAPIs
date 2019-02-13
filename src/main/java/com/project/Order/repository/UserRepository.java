package com.project.Order.repository;

import com.project.Order.modal.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserId(Long userId);
}

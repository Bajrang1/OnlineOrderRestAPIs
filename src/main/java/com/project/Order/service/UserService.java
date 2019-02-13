package com.project.Order.service;

import com.project.Order.modal.User;
import com.project.Order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//************************************************* post method ******************************************
    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User findUser(Long userId) {
        User user=userRepository.findByUserId(userId);
        return user;
    }

    public User updateUser(Long userId, User user) {
        User user1=userRepository.findByUserId(userId);
        user1.setAddress(user.getAddress());
        user1.setMob(user.getMob());
        user1.setName(user.getName());
        return user1;
    }
}

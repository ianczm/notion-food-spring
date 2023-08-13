package com.ianczm.notion.food.domain.services;

import com.ianczm.notion.food.domain.models.User;
import com.ianczm.notion.food.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<List<User>> getUsers() {
        return this.userRepository.getUsers();
    }
}

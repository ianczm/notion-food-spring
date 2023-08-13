package com.ianczm.notion.food.infrastructure;

import com.ianczm.notion.food.domain.models.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserRepository {

     Mono<List<User>> getUsers();

}

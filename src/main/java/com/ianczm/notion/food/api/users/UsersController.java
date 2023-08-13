package com.ianczm.notion.food.api.users;

import com.ianczm.notion.food.api.data.ListResultsWrapperDTO;
import com.ianczm.notion.food.api.users.data.UserDTO;
import com.ianczm.notion.food.domain.models.User;
import com.ianczm.notion.food.domain.services.UserService;
import com.ianczm.notion.food.utils.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Mono<ListResultsWrapperDTO<UserDTO>> getUsers() {
        return this.userService.getUsers()
                .map(users -> users.stream().map(ApiMapper::fromModel).toList())
                .map(ApiMapper::wrapListResults);
    }

}

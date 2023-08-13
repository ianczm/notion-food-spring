package com.ianczm.notion.food.utils;

import com.ianczm.notion.food.api.data.ListResultsWrapperDTO;
import com.ianczm.notion.food.api.food.data.FoodDTO;
import com.ianczm.notion.food.api.users.data.UserDTO;
import com.ianczm.notion.food.domain.models.Food;
import com.ianczm.notion.food.domain.models.User;

import java.util.List;

public class ApiMapper {

    public static FoodDTO fromModel(Food model) {
        FoodDTO dto = new FoodDTO();
        dto.setDateVisited(model.getDateVisited());
        dto.setFood(model.getFood());
        dto.setRestaurantName(model.getRestaurantName());
        dto.setState(model.getState());
        dto.setRating(model.getRating());
        dto.setLocation(model.getLocation());
        dto.setVisited(model.getVisited());
        return dto;
    }

    public static Food toModel(FoodDTO dto) {
        Food model = new Food();
        model.setDateVisited(dto.getDateVisited());
        model.setFood(dto.getFood());
        model.setRestaurantName(dto.getRestaurantName());
        model.setState(dto.getState());
        model.setRating(dto.getRating());
        model.setLocation(dto.getLocation());
        model.setVisited(dto.getVisited());
        return model;
    }

    public static User toModel(UserDTO dto) {
        return User.builder()
                .type(dto.getType())
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static UserDTO fromModel(User model) {
        return UserDTO.builder()
                .type(model.getType())
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }

    public static <T> ListResultsWrapperDTO<T> wrapListResults(List<T> list) {
        ListResultsWrapperDTO<T> results = new ListResultsWrapperDTO<>();
        results.setResults(list);
        return results;
    }

}

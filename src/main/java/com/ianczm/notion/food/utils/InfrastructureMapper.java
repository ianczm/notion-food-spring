package com.ianczm.notion.food.utils;

import com.ianczm.notion.food.domain.models.Food;
import com.ianczm.notion.food.domain.models.User;
import com.ianczm.notion.food.infrastructure.notion.data.pages.NotionPage;
import com.ianczm.notion.food.infrastructure.notion.data.pages.food.NotionFoodProperties;
import com.ianczm.notion.food.infrastructure.notion.data.users.NotionUser;

import java.time.ZonedDateTime;
import java.util.Objects;

public class InfrastructureMapper {

    public static Food toModel(NotionPage<NotionFoodProperties> page) {
        NotionFoodProperties properties = page.getProperties();
        ZonedDateTime dateVisited = properties.getDateVisited().getValue();
        return Food.builder()
                .dateVisited(dateVisited != null ? dateVisited.toString() : null)
                .restaurantName(properties.getRestaurantName().getValue())
                .state(properties.getState().getValue())
                .visited(properties.getVisited().getValue())
                .location(properties.getLocation().getValue())
                .rating(properties.getRating().getValue())
                .food(properties.getFood().getValue())
                .build();
    }

    public static User toModel(NotionUser user) {
        return User.builder()
                .email(user.getPerson() != null ? user.getPerson().getEmail() : null)
                .id(user.getId())
                .name(user.getName())
                .type(user.getType())
                .build();
    }

}

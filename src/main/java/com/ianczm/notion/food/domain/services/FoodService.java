package com.ianczm.notion.food.domain.services;

import com.ianczm.notion.food.domain.models.Food;
import com.ianczm.notion.food.infrastructure.FoodRepository;
import com.ianczm.notion.food.infrastructure.notion.NotionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(NotionClient foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Mono<List<Food>> getFood() {
        return this.foodRepository.getFood();
    }

    public Mono<List<Food>> getTestFood() {

        Food first = new Food();
        first.setFood("Char Kuey Teow Hoho");
        first.setLocation("O&S Restaurant");
        first.setState("KL");
        first.setRating(3);
        first.setRestaurantName("Char Kuey Teow with KL taste");
        first.setVisited(true);
        first.setDateVisited("2022-22-22");

        Food second = new Food();
        second.setFood("Char Kuey Teow Actual");
        second.setLocation("Penang");
        second.setState("Penang");
        second.setRating(7);
        second.setRestaurantName("Char Kuey Teow 40 Years of Experience");
        second.setVisited(true);
        second.setDateVisited("2011-11-11");

        return Mono.just(List.of(
                first, second
        ));
    }
}

package com.ianczm.notion.food.infrastructure;

import com.ianczm.notion.food.domain.models.Food;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FoodRepository {

     Mono<List<Food>> getFood();

}

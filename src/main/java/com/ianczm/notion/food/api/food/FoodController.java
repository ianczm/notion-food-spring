package com.ianczm.notion.food.api.food;

import com.ianczm.notion.food.api.data.ListResultsWrapperDTO;
import com.ianczm.notion.food.api.food.data.FoodDTO;
import com.ianczm.notion.food.domain.services.FoodService;
import com.ianczm.notion.food.utils.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ListResultsWrapperDTO<FoodDTO>> getTestFood() {
        return this.foodService.getTestFood()
                .map(list -> list.stream().map(ApiMapper::fromModel).toList())
                .map(ApiMapper::wrapListResults);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ListResultsWrapperDTO<FoodDTO>> getFood() {
        return this.foodService.getFood()
                .map(list -> list.stream().map(ApiMapper::fromModel).toList())
                .map(ApiMapper::wrapListResults);
    }

}

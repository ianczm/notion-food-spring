package com.ianczm.notion.food.api.food.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodDTO {

    public String state;
    public String dateVisited;
    public Boolean visited;
    public String food;
    public String location;
    public Integer rating;
    public String restaurantName;

}
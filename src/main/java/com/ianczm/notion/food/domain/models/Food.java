package com.ianczm.notion.food.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    public String state;
    public String dateVisited;
    public Boolean visited;
    public String food;
    public String location;
    public Integer rating;
    public String restaurantName;

}

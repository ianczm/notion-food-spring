package com.ianczm.notion.food.infrastructure.notion.data.pages.food;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ianczm.notion.food.infrastructure.notion.data.pages.properties.*;
import lombok.Data;

@Data
public class NotionFoodProperties {

    @JsonProperty("State")
    public NotionPagePropertySelect state;

    @JsonProperty("Date Visited")
    public NotionPagePropertyDate dateVisited;

    @JsonProperty("Visited")
    public NotionPagePropertyCheckbox visited;

    @JsonProperty("Food")
    public NotionPagePropertyRichText food;

    @JsonProperty("Location")
    public NotionPagePropertyRichText location;

    @JsonProperty("Rating")
    public NotionPagePropertyNumber rating;

    @JsonProperty("Restaurant Name")
    public NotionPagePropertyRichText restaurantName;

}

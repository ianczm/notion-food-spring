package com.ianczm.notion.food.api.data;

import lombok.Data;

import java.util.List;

@Data
public class ListResultsWrapperDTO<T> {

    public List<T> results;

}

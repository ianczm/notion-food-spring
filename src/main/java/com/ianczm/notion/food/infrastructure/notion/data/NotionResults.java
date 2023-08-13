package com.ianczm.notion.food.infrastructure.notion.data;

import lombok.Data;

import java.util.List;

@Data
public class NotionResults<T> {

    private List<T> results;

}

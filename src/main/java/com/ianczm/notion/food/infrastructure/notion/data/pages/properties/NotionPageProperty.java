package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public abstract class NotionPageProperty<T> {

    public String id;
    public String type;

    @Nullable
    public abstract T getValue();

}

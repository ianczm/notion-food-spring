package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotionPagePropertyNumber extends NotionPageProperty<Integer> {

    @Nullable
    public Integer number;

    @Nullable
    @Override
    public Integer getValue() {
        return this.number;
    }
}

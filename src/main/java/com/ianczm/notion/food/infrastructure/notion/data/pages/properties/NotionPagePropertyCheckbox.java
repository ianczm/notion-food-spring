package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotionPagePropertyCheckbox extends NotionPageProperty<Boolean> {

    public Boolean checkbox;

    @Override
    public Boolean getValue() {
        return this.checkbox;
    }
}

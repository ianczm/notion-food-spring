package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotionPagePropertySelect extends NotionPageProperty<String> {

    @Nullable
    public Map<String, String> select;

    @Nullable
    @Override
    public String getValue() {
        return this.select != null
                ? this.select.get("name")
                : null;
    }
}

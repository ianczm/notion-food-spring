package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotionPagePropertyDate extends NotionPageProperty<ZonedDateTime> {

    @Nullable
    public Map<String, String> date;

    @Nullable
    @Override
    public ZonedDateTime getValue() {
        return this.date != null
                ? ZonedDateTime.parse(this.date.get("start"))
                : null;
    }
}

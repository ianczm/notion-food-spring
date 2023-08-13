package com.ianczm.notion.food.infrastructure.notion.data.pages.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotionPagePropertyRichText extends NotionPageProperty<String> {

    @Nullable
    @JsonProperty("rich_text")
    public ArrayNode richText;

    @Nullable
    @Override
    public String getValue() {

        if (richText == null) {
            return null;
        }

        String result = StreamSupport.stream(this.richText.spliterator(), false)
                .map(richTextObj -> richTextObj.get("plain_text").toString())
                .collect(Collectors.joining());

        return !result.isEmpty()
                ? result
                : null;

    }
}

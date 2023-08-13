package com.ianczm.notion.food.infrastructure.notion.data.pages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ianczm.notion.food.infrastructure.notion.data.users.NotionUser;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class NotionPage<T> {

    public String object;

    public String id;

    @JsonProperty("created_time")
    public String createdTime;

    @JsonProperty("created_by")
    public NotionUser createdBy;

    @JsonProperty("last_edited_time")
    public ZonedDateTime lastEditedTime;

    @JsonProperty("last_edited_by")
    public NotionUser lastEditedBy;

    public Boolean archived;

    public T properties;

    public Map<String, Object> parent;

    public String url;

    @JsonProperty("public_url")
    public String publicUrl;

}

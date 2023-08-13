package com.ianczm.notion.food.infrastructure.notion.data.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class NotionUser {

    private String id;

    private String name;

    private String object;

    private String type;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @Nullable
    private NotionUserPerson person;

    @Nullable
    private NotionUserBot bot;

}

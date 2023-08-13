package com.ianczm.notion.food.infrastructure.notion.data.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotionUserBot {

    public NotionUserOwner owner;

    @JsonProperty("workspace_name")
    public String workspaceName;
}

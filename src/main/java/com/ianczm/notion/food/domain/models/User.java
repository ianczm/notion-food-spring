package com.ianczm.notion.food.domain.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
public class User {

    private String id;
    private String name;

    @Nullable
    private String email;

    private String type;

}

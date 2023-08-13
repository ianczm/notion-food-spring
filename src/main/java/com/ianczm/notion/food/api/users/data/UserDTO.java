package com.ianczm.notion.food.api.users.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    private String type;

}

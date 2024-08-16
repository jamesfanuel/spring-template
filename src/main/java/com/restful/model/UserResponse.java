package com.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String memberUsername;
    private String memberFullname;
    private Integer memberLevel;
    private String memberPassword;
    private String memberEmail;

}

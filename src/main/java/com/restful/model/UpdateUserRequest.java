package com.restful.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

    @Size(max = 30)
    private String memberUsername;

    @Size(max = 60)
    private String memberFullname;

    private Integer memberLevel;

    @Size(max = 100)
    private String memberPassword;

    @Email
    @Size(max = 300)
    private String memberEmail;
}
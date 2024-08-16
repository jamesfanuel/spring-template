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
public class RegisterUserRequest {

    @NotBlank
    @Size(max = 30)
    private String memberUsername;

    @NotBlank
    @Size(max = 100)
    private String memberPassword;

    @Size(max = 60)
    private String memberFullname;

    private Integer memberLevel;

    @Email
    @Size(max = 300)
    private String memberEmail;

}
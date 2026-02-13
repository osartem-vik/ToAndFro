package com.ToAndFro.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatchUserRequestDto {
    @Pattern(regexp = "^\\+?[1-9]\\d{7,14}$")
    private String phone;

    @Email
    private String email;

    private String firstName;
    private String lastName;
}

package com.devteria.identityservice.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.devteria.identityservice.Enum.Gender;
import com.devteria.identityservice.Enum.Shift;
import com.devteria.identityservice.validator.DobConstraint;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    String firstName;
    String lastName;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;

    String email;
    String phone;
    String address;

    @Enumerated(EnumType.STRING)
    Gender gender;

    double height;
    double weight;

    private Shift shift;
    double salary;

    List<String> roles;
}

package com.devteria.identityservice.dto.request;

import com.devteria.identityservice.Enum.Gender;
import com.devteria.identityservice.Enum.Shift;
import com.devteria.identityservice.validator.DobConstraint;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreationRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstName;
    String lastName;
    @DobConstraint(min = 10, message = "INVALID_DOB")
    LocalDate dob;
    String email;
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Enumerated(EnumType.STRING)
    private Shift shift;
    double salary;
    List<String> roles;

}

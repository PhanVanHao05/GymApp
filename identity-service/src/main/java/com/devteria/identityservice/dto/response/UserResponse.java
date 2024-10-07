package com.devteria.identityservice.dto.response;

import java.time.LocalDate;
import java.util.Set;

import com.devteria.identityservice.Enum.Gender;
import com.devteria.identityservice.Enum.Shift;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
    String email;
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    Gender gender;
    double height;
    double weight;
    Double salary;
    Shift shift;
    Set<RoleResponse> roles;
}

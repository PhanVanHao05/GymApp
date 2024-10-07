package com.devteria.identityservice.entity;

import java.time.LocalDate;
import java.util.Set;

import com.devteria.identityservice.Enum.Gender;
import com.devteria.identityservice.Enum.Shift;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String username;

    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    String email;
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //nhan vien
    @Enumerated(EnumType.STRING)
    private Shift shift;
    double salary;
    //khach hang
    double height;
    double weight;
    //cac moi quan he
    @ManyToMany
    Set<Role> roles;
}

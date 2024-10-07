package com.devteria.identityservice.controller;

import java.util.List;

import com.devteria.identityservice.dto.request.EmployeeCreationRequest;
import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.devteria.identityservice.dto.request.ApiResponse;
import com.devteria.identityservice.dto.request.CustomerCreationRequest;
import com.devteria.identityservice.dto.request.UserUpdateRequest;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.service.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    // Tạo mới Customer
    @PostMapping("/customers")
    //@PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<UserResponse> createCustomer(@RequestBody @Valid CustomerCreationRequest request) {
        UserResponse response = userService.createUser(request);
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Customer created successfully")
                .result(response)
                .build();
    }

    // Tạo mới Employee hoặc PT với role được truyền vào
    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<UserResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
        UserResponse response = userService.createEmployee(request);
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Employee created successfully")
                .result(response)
                .build();
    }


    // Lấy danh sách khách hàng
    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<UserResponse>> getCustomers() {
        List<UserResponse> response = userService.getCustomers();
        return ApiResponse.<List<UserResponse>>builder()
                .code(1000)
                .message("Customer list retrieved successfully")
                .result(response)
                .build();
    }

    // Lấy danh sách nhân viên và PT
    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<UserResponse>> getEmployeesAndPTs() {
        List<UserResponse> response = userService.getEmployeesAndPTs();
        return ApiResponse.<List<UserResponse>>builder()
                .code(1000)
                .message("Employee and PT list retrieved successfully")
                .result(response)
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/my-info")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }


}

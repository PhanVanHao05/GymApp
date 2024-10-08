package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.EmployeeCreationRequest;
import com.devteria.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.devteria.identityservice.dto.request.CustomerCreationRequest;
import com.devteria.identityservice.dto.request.UserUpdateRequest;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.entity.User;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Chuyển đổi từ CustomerCreationRequest sang User
    User toUser(CustomerCreationRequest request);

    // Chuyển đổi từ EmployeeCreationRequest sang User
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesFromStringList")
    User toUser(EmployeeCreationRequest request);

    // Chuyển đổi từ User sang UserResponse DTO
    UserResponse toUserResponse(User user);

    // Cập nhật thuộc tính của User từ UserUpdateRequest
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    // Phương thức ánh xạ List<String> sang Set<Role>
    @Named("mapRolesFromStringList")
    default Set<Role> mapRolesFromStringList(List<String> roleNames) {
        if (roleNames == null || roleNames.isEmpty()) {
            return new HashSet<>();
        }
        // Tạo các đối tượng Role từ các giá trị roleNames
        return roleNames.stream()
                .map(roleName -> Role.builder().name(roleName).build())
                .collect(Collectors.toSet());
    }
}

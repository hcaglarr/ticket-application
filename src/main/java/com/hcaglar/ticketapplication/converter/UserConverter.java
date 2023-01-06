package com.hcaglar.ticketapplication.converter;

import com.hcaglar.ticketapplication.dto.request.UserRequest;
import com.hcaglar.ticketapplication.dto.response.UserResponse;
import com.hcaglar.ticketapplication.entity.security.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.stream.Collectors;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserResponse convert(User user);

    default Page<UserResponse> convert(Page<User> users){
        var userResponse = users.getContent().stream().map(user ->
                UserResponse.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .accountNonExpired(user.isAccountNonExpired())
                        .accountNonLocked(user.isAccountNonLocked())
                        .credentialsNonExpired(user.isCredentialsNonExpired())
                        .enabled(user.isEnabled())
                        .build()
        ).collect(Collectors.toList());

        return new PageImpl<>(userResponse);
    }

    User convert(UserRequest userRequest);
}

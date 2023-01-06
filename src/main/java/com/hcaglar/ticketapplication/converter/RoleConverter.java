package com.hcaglar.ticketapplication.converter;

import com.hcaglar.ticketapplication.dto.request.RoleRequest;
import com.hcaglar.ticketapplication.dto.response.RoleResponse;
import com.hcaglar.ticketapplication.entity.security.Role;
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
public interface RoleConverter {
    RoleConverter INSTANCE = Mappers.getMapper(RoleConverter.class);

    RoleResponse convert(Role role);

    default Page<RoleResponse> convert(Page<Role> pageRoles){
        var roles = pageRoles.get().map(role ->
                RoleResponse.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .build())
                .collect(Collectors.toList());

        return new PageImpl<>(roles);
    }

    Role convert(RoleRequest roleRequest);

}

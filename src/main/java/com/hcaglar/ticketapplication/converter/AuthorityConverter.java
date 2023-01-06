package com.hcaglar.ticketapplication.converter;

import com.hcaglar.ticketapplication.dto.request.AuthorityRequest;
import com.hcaglar.ticketapplication.dto.response.AuthorityResponse;
import com.hcaglar.ticketapplication.entity.security.Authority;
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
public interface AuthorityConverter {
    AuthorityConverter INSTANCE = Mappers.getMapper(AuthorityConverter.class);

    AuthorityResponse convert(Authority authority);

    default Page<AuthorityResponse> convert(Page<Authority> pageAuthorities){
        var authorities = pageAuthorities.get().map(authority -> 
                AuthorityResponse.builder()
                        .id(authority.getId())
                        .permission(authority.getPermission())
                        .build())
                .collect(Collectors.toList());
        
        return new PageImpl<>(authorities);
    }

    Authority convert(AuthorityRequest authorityRequest);
}

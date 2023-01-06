package com.hcaglar.ticketapplication.dto.request;

import lombok.*;

import java.util.UUID;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private UUID id;
    private String password;
    private String username;
    private String email;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}

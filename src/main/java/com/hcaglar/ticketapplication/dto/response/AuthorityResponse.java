package com.hcaglar.ticketapplication.dto.response;

import lombok.*;

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
public class AuthorityResponse {
    private Integer id;
    private String permission;
}

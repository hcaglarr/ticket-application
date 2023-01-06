package com.hcaglar.ticketapplication.dto.request;

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
public class AuthorityRequest {
    private Integer id;
    private String permission;
}

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
public class RoleRequest {
    private Integer id;
    private String name;
}

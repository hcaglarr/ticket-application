package com.hcaglar.ticketapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 5.01.2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class BaseEntity<T> {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;

    @CreatedBy
    @Column(nullable = false)
    private T createBy;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @LastModifiedBy
    private T updateBy;

}

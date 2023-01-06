package com.hcaglar.ticketapplication.entity.security;

import com.hcaglar.ticketapplication.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "authorities", indexes = {
        @Index(name = "IX_AUTHORITY_ID", columnList = "id", unique = true),
        @Index(name = "IX_AUTHORITY_NAME", columnList = "permission", unique = true)})
public class Authority extends BaseEntity<String> {
    private final static String PERMISSION_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){8,64}[a-zA-Z0-9]$";

    @Id
    @SequenceGenerator(name = "SEQ_AUTHORITY_ID", sequenceName = "SEQ_GEN_AUTHORITY_ID")
    @GeneratedValue(generator = "SEQ_AUTHORITY_ID", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false, unique = true)
    private Integer id;


    @NotNull(message = "{validation.message.notnull.permission}")
    @Size(min = 2, max = 64, message = "{validation.message.size.permission}")
    @Pattern(regexp = PERMISSION_REGEX, message = "{validation.message.pattern.permission}")
    @Column(unique = true)
    private String permission;

    @ManyToMany(mappedBy = "authorities", cascade = {MERGE, PERSIST}, fetch = EAGER)
    private Set<Role> roles = new HashSet<>();
}

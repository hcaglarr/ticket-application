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

import static javax.persistence.CascadeType.*;
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
@Table(name = "roles", indexes = {
        @Index(name = "IX_ROLE_ID", columnList = "id", unique = true),
        @Index(name = "IX_ROLE_NAME", columnList = "name", unique = true)})
public class Role extends BaseEntity<String> {
    private final static String NAME_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){8,64}[a-zA-Z0-9]$";

    @Id
    @SequenceGenerator(name = "SEQ_ROLE_ID", sequenceName = "SEQ_GEN_ROLE_ID")
    @GeneratedValue(generator = "SEQ_ROLE_ID", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false, unique = true)
    private Integer id;


    @NotNull(message = "{validation.message.notnull.name}")
    @Size(min = 2, max = 64, message = "{validation.message.size.name}")
    @Pattern(regexp = NAME_REGEX, message = "{validation.message.pattern.name}")
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = {MERGE, PERSIST}, fetch = EAGER)
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(name = "roles_authorities",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities = new HashSet<>();
}

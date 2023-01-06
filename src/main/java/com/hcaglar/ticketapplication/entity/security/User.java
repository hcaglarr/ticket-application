package com.hcaglar.ticketapplication.entity.security;

import com.hcaglar.ticketapplication.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

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
@Entity
@Table(name = "users", indexes = {
        @Index(name = "IX_USER_USERNAME", columnList = "username", unique = true),
        @Index(name = "IX_USER_EMAIL", columnList = "email", unique = true)})
public class User extends BaseEntity<String> implements UserDetails, CredentialsContainer {
    private final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private final static String USERNAME_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){8,64}[a-zA-Z0-9]$";
    private final static String FALSE_OR_TRUE_REGEX = "^true$|^false$";

    @Id
    @GeneratedValue(generator = "USER_UUID")
    @GenericGenerator(
            name = "USER_UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {@Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    @NotNull(message = "{validation.message.notnull.password}")
    @Size(min = 8, max = 64, message = "{validation.message.size.password}")
    @Pattern(regexp = PASSWORD_REGEX, message = "{validation.message.pattern.password}")
    private String password;

    @NotNull(message = "{validation.message.notnull.username}")
    @Size(min = 8, max = 64, message = "{validation.message.size.username}")
    @Pattern(regexp = USERNAME_REGEX, message = "{validation.message.pattern.username}")
    @Column(unique = true)
    private String username;

    @NotNull(message = "{validation.message.notnull.email}")
    @Size(min = 8, max = 128, message = "{validation.message.size.email}")
    @Email(message = "{validation.message.email.email}")
    @Column(unique = true)
    private String email;

    @NotNull(message = "{validation.message.notnull.account-non-expired}")
    @Pattern(regexp = FALSE_OR_TRUE_REGEX, message = "{validation.message.pattern.account-non-expired}")
    private boolean accountNonExpired;

    @NotNull(message = "{validation.message.notnull.account-non-locked}")
    @Pattern(regexp = FALSE_OR_TRUE_REGEX, message = "{validation.message.pattern.account-non-locked}")
    private boolean accountNonLocked;

    @NotNull(message = "{validation.message.notnull.credentials-non-expired}")
    @Pattern(regexp = FALSE_OR_TRUE_REGEX, message = "{validation.message.pattern.credentials-non-expired}")
    private boolean credentialsNonExpired;

    @NotNull(message = "{validation.message.notnull.enabled}")
    @Pattern(regexp = FALSE_OR_TRUE_REGEX, message = "{validation.message.pattern.enabled}")
    private boolean enabled;

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var simpleGrantedAuthorities = new HashSet<SimpleGrantedAuthority>();

        roles.stream().map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .map(simpleGrantedAuthorities::add)
                .collect(Collectors.toList());
        roles.stream().map(Role::getAuthorities)
                .flatMap(Set::stream)
                .map(Authority::getPermission)
                .map(SimpleGrantedAuthority::new)
                .map(simpleGrantedAuthorities::add).collect(Collectors.toList());

        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

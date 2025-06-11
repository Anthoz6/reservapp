package com.anthonycorp.reservapp.User.infrastructure.model;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
>>>>>>> 8335205 (Module User Updated)

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@Builder
=======
>>>>>>> 8335205 (Module User Updated)
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    // Return the email as the username
    @Getter
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
=======
    @ManyToOne()
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
>>>>>>> 8335205 (Module User Updated)
    }

    @Override
    public String getUsername() {
<<<<<<< HEAD
        return email;
=======
        return this.email; //Return the email as the username
>>>>>>> 8335205 (Module User Updated)
    }

    @Override
    public boolean isAccountNonExpired() {
<<<<<<< HEAD
        return accountNonExpired;
=======
        return true; // Return true if the account is not expired
>>>>>>> 8335205 (Module User Updated)
    }

    @Override
    public boolean isAccountNonLocked() {
<<<<<<< HEAD
        return accountNonLocked;
=======
        return true; // Return true if the account is not locked
>>>>>>> 8335205 (Module User Updated)
    }

    @Override
    public boolean isCredentialsNonExpired() {
<<<<<<< HEAD
        return credentialsNonExpired;
=======
        return true; // Return true if the credentials are not expired
>>>>>>> 8335205 (Module User Updated)
    }

    @Override
    public boolean isEnabled() {
<<<<<<< HEAD
        return enabled;
    }
    
=======
        return true; // Return true if the account is enabled
    }
>>>>>>> 8335205 (Module User Updated)
}

package com.healthcare.userandaccessmanagement.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OauthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userId;

    @NotNull
    @Column(nullable = false, length = 10)
    private String firstName;

    @NotNull
    @Column(nullable = false, length = 5)
    private String lastName;

    @NotNull
    @Column(unique = true, nullable = false, length = 30)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false, length = 12)
    private String phoneNumber;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    private boolean isNotLocked;

    public enum Roles {
        ROLE_USER, ROLE_ADMIN;
    }

}

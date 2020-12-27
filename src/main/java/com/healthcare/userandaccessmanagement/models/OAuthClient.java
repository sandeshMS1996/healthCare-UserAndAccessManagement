package com.healthcare.userandaccessmanagement.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OAuthClient implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(nullable = false, unique = true, length = 100)
    private String clientId;

    @NotNull
    @Column(nullable = false, length = 100)
    private String clientSecret;

    //@Enumerated(EnumType.STRING)
    private String clientGrantType;

    //@Enumerated(EnumType.STRING)
    private String clientScope;

    /*public enum ClientGrantType {
        password, authorization_code
    }

    public enum ClientScope {
        USER, ADMIN
    }
*/
}

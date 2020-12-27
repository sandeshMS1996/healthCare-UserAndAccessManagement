package com.healthcare.userandaccessmanagement.security;

import com.healthcare.userandaccessmanagement.models.OAuthClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyClientDetails implements ClientDetails {

    private OAuthClient oAuthClient;

    public MyClientDetails(OAuthClient oAuthClient) {
        this.oAuthClient = oAuthClient;
    }

    @Override
    public String getClientId() {
        return this.oAuthClient.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.oAuthClient.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return Set.of(this.oAuthClient.getClientScope().toString());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Set.of(this.oAuthClient.getClientGrantType().toString());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        System.out.println(this.oAuthClient.getClientGrantType().toString());
        return List.of(() -> this.oAuthClient.getClientGrantType().toString());

    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}

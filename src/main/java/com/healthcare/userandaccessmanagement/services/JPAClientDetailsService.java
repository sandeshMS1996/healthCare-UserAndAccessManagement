package com.healthcare.userandaccessmanagement.services;

import com.healthcare.userandaccessmanagement.models.OAuthClient;
import com.healthcare.userandaccessmanagement.repos.ClientRepo;
import com.healthcare.userandaccessmanagement.security.MyClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class JPAClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OAuthClient oAuthClient = this.clientRepo.findOAuthClientByClientId(clientId)
                .orElseThrow(() -> new ClientRegistrationException("No Client with name " + clientId));
        System.out.println(oAuthClient);
        return new MyClientDetails(oAuthClient);
    }
}

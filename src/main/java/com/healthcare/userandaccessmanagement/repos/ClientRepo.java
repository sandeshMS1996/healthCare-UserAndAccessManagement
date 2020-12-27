package com.healthcare.userandaccessmanagement.repos;

import com.healthcare.userandaccessmanagement.models.OAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<OAuthClient, Long> {
    Optional<OAuthClient> findOAuthClientByClientId(String clientId);
}

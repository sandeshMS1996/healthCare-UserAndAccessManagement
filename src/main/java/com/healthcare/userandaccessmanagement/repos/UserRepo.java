package com.healthcare.userandaccessmanagement.repos;

import com.healthcare.userandaccessmanagement.models.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<OauthUser, Long> {

    Optional<OauthUser> findOauthUserByUsername(String username);

}

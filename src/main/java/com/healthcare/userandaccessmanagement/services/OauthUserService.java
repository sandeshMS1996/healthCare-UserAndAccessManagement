package com.healthcare.userandaccessmanagement.services;

import com.healthcare.userandaccessmanagement.models.OauthUser;
import com.healthcare.userandaccessmanagement.repos.UserRepo;
import com.healthcare.userandaccessmanagement.security.OauthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OauthUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OauthUser user = this.userRepo.findOauthUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        System.out.println(user);
        return new OauthUserDetails(user);
    }

    public OauthUser createUser(OauthUser user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRole(OauthUser.Roles.ROLE_USER);
        user.setNotLocked(true);
        return this.userRepo.save(user);
    }

    public boolean changePassword(String username, String newPassword) {
        Optional<OauthUser> oauthUserByUsername = this.userRepo.findOauthUserByUsername(username);
        if (oauthUserByUsername.isPresent()) {
            OauthUser user = oauthUserByUsername.get();
            user.setPassword(this.passwordEncoder.encode(newPassword));
            this.userRepo.save(user);
            return true;
        }
        return false;
    }

    // Delete account need to be implemented
}

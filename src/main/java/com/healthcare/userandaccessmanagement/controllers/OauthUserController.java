package com.healthcare.userandaccessmanagement.controllers;

import com.healthcare.userandaccessmanagement.models.OauthUser;
import com.healthcare.userandaccessmanagement.services.OauthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin("*")
public class OauthUserController {
    @Autowired
    private OauthUserService oauthUserService;

    @PostMapping("register")
    public ResponseEntity<OauthUser> register(@RequestBody OauthUser user) {
        OauthUser oauthUser = this.oauthUserService.createUser(user);
        return ResponseEntity.ok(oauthUser);
    }

    @GetMapping("get-role")
    public ResponseEntity<String> getRole(@RequestParam("username") String s) {
        UserDetails details = this.oauthUserService.loadUserByUsername(s);
        if(details != null)
            return ResponseEntity.ok(details.getAuthorities().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not found");
    }

    @PutMapping("change-password")
    public ResponseEntity<String> changePassword(@RequestParam("username") String username,
                                                     @RequestParam("newPassword") String newPassword) {
        UserDetails details = this.oauthUserService.loadUserByUsername(username);
        if(details != null) {
            this.oauthUserService.changePassword(username, newPassword);
            return ResponseEntity.ok("password changed");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}

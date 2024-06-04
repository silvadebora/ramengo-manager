package com.redventures.ramengo.admin.controllers;

import com.redventures.ramengo.admin.domain.User;
import com.redventures.ramengo.admin.dto.LoginDTO;
import com.redventures.ramengo.admin.dto.LoginResponse;
import com.redventures.ramengo.admin.dto.UserDTO;
import com.redventures.ramengo.admin.repository.UserRepository;
import com.redventures.ramengo.admin.services.auth.TokenService;
import com.redventures.ramengo.admin.services.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class UserController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserDTO data){
        if (userRepository.findByEmail(data.getEmail()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserDTO newUser = new UserDTO(data.getFirstName(), data.getLastName(), data.getEmail(), encryptedPassword);
        userService.save(newUser);
        return ResponseEntity.ok().build();
    }
}

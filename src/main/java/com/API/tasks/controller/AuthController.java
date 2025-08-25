package com.API.tasks.controller;

import com.API.tasks.business.dtos.LoginDto;
import com.API.tasks.business.dtos.UserDTO;
import com.API.tasks.business.dtos.UserRegisterDTO;
import com.API.tasks.infra.security.TokenService;
import com.API.tasks.infrastructure.entitys.UserEntity;
import com.API.tasks.infrastructure.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final SecurityService securityService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserDTO userDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.password());
        var auth =  this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDto(token));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterDTO dto){
        if( userRepo.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        UserEntity user = new UserEntity(dto.login(), encryptedPassword, dto.role());

        this.userRepo.save(user);

        return ResponseEntity.ok().build();

    }
}

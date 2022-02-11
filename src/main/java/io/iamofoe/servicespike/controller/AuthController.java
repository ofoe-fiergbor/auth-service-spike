package io.iamofoe.servicespike.controller;

import io.iamofoe.servicespike.domain.AuthDto;
import io.iamofoe.servicespike.domain.model.User;
import io.iamofoe.servicespike.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/")
    public ResponseEntity<User> authenticateUser(@RequestBody AuthDto requestDto) {
        return new ResponseEntity<>(authService.verifyToken(requestDto.getIdTokenString()), HttpStatus.CREATED);
    }
}

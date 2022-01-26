package com.lovemesomecoding.oauth2.user;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovemesomecoding.oauth2.dto.AuthenticationResponseDTO;
import com.lovemesomecoding.oauth2.dto.SignInDTO;
import com.lovemesomecoding.oauth2.dto.SignUpDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Users", description = "User Operations")
@Slf4j
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * sign up
     */
    @Operation(summary = "Sign Up", description = "sign up")
    @PostMapping(value = "/signup")
    public ResponseEntity<AuthenticationResponseDTO> signup(@RequestBody SignUpDTO signup) {
        AuthenticationResponseDTO authDto = userService.signUp(signup);
        return new ResponseEntity<>(authDto, OK);
    }
    
    /**
     * sign in
     */
    @Operation(summary = "Sign In", description = "sign in")
    @PostMapping(value = "/signin")
    public ResponseEntity<AuthenticationResponseDTO> signin(@RequestBody SignInDTO signin) {
        AuthenticationResponseDTO authDto = userService.signIn(signin);
        return new ResponseEntity<>(authDto, OK);
    }
}

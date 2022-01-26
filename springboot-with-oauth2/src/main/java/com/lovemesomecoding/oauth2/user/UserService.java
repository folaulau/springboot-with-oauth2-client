package com.lovemesomecoding.oauth2.user;

import com.lovemesomecoding.oauth2.dto.AuthenticationResponseDTO;
import com.lovemesomecoding.oauth2.dto.SignInDTO;
import com.lovemesomecoding.oauth2.dto.SignUpDTO;

public interface UserService {
    
    AuthenticationResponseDTO signUp(SignUpDTO signup);

    AuthenticationResponseDTO signIn(SignInDTO signin);
}

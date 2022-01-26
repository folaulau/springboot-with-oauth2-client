package com.lovemesomecoding.oauth2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.oauth2.client.GithubService;
import com.lovemesomecoding.oauth2.dto.AccessTokenDTO;
import com.lovemesomecoding.oauth2.dto.AuthenticationResponseDTO;
import com.lovemesomecoding.oauth2.dto.ClientInfoDTO;
import com.lovemesomecoding.oauth2.dto.SignInDTO;
import com.lovemesomecoding.oauth2.dto.SignUpDTO;
import com.lovemesomecoding.oauth2.utils.ObjectMapperUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GithubService  githubService;

    @Override
    public AuthenticationResponseDTO signUp(SignUpDTO signup) {
        log.info("signup={}", ObjectMapperUtils.toJson(signup));

        AuthenticationResponseDTO authResponse = new AuthenticationResponseDTO();

        AccessTokenDTO accessToken = githubService.getAccessToken(signup.getToken());
        log.info("accessToken={}", ObjectMapperUtils.toJson(accessToken));

        if (accessToken != null && accessToken.getAccessToken() != null) {
            ClientInfoDTO githubInfo = null;
            Oauth2ClientType clientType = signup.getClientType();

            switch (clientType) {
                case USERNAME_PASSWORD:

                    break;
                case GITHUB:

                    githubInfo = githubService.getProfile(accessToken.getAccessToken());
                    break;

                case GOOGLE:

                    break;

                default:

                    break;
            }

            log.info("githubInfo={}", ObjectMapperUtils.toJson(githubInfo));

            if (githubInfo.getEmail() != null && githubInfo.getEmail().trim().length() > 0) {

                // sign up user

                authResponse.setAuthenticated(true);
            } else {
                // let front end know that authenticated=false to ask for email still.
            }
        }

        return authResponse;
    }

    @Override
    public AuthenticationResponseDTO signIn(SignInDTO signin) {
        // TODO Auto-generated method stub
        return null;
    }
}

package com.lovemesomecoding.oauth2.client;

import com.lovemesomecoding.oauth2.dto.AccessTokenDTO;
import com.lovemesomecoding.oauth2.dto.ClientInfoDTO;

public interface GithubService {

    public AccessTokenDTO getAccessToken(String code);

    public ClientInfoDTO getProfile(String accessToken);
}

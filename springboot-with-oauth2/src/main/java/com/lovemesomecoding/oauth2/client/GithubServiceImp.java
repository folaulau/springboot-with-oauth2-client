package com.lovemesomecoding.oauth2.client;

import java.io.IOException;
import java.net.URI;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.oauth2.ApiBinding;
import com.lovemesomecoding.oauth2.dto.AccessTokenDTO;
import com.lovemesomecoding.oauth2.dto.ClientInfoDTO;
import com.lovemesomecoding.oauth2.utils.HttpRequestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GithubServiceImp implements GithubService {

    private static final String API_BASE_URL = "https://api.github.com";

    private RestTemplate        restTemplate = new RestTemplate();

    @PostConstruct
    public void init() {
       // restTemplate.getInterceptors().add(new HttpRequestInterceptor());
    }

    @Override
    public ClientInfoDTO getProfile(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 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
        headers.set("Authorization", "Bearer " + accessToken.trim());

        HttpEntity<String> entity = new HttpEntity<>(new String(), headers);

        ResponseEntity<ClientInfoDTO> response = null;
        try {

            response = restTemplate.exchange(new URI(API_BASE_URL + "/user"), HttpMethod.GET, entity, ClientInfoDTO.class);

        } catch (Exception e) {
            log.warn("Exception, msg={}", e.getLocalizedMessage());
        }

        if (response == null) {
            return null;
        }

        return response.getBody();
    }

    @Override
    public AccessTokenDTO getAccessToken(String code) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(new String(), headers);

        try {

            String clientId = "";
            String clientSecret = "";

            ResponseEntity<AccessTokenDTO> response = restTemplate.exchange(
                    new URI("https://github.com/login/oauth/access_token?client_id=" + clientId + "&client_secret=" + clientSecret + "&code=" + code), HttpMethod.POST, entity, AccessTokenDTO.class);

            AccessTokenDTO accessToken = response.getBody();

            return accessToken;

        } catch (Exception e) {
            log.error("Exception, msg={}", e.getLocalizedMessage());
            return null;
        }

    }

}

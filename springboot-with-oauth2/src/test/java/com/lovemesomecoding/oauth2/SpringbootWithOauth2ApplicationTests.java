package com.lovemesomecoding.oauth2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.oauth2.client.GithubService;
import com.lovemesomecoding.oauth2.dto.ClientInfoDTO;
import com.lovemesomecoding.oauth2.utils.ObjectMapperUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpringbootWithOauth2ApplicationTests {
    @Autowired
    GithubService githubService;

    @Test
    void contextLoads() {
        ClientInfoDTO githubProfile = githubService.getProfile("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");

        log.info("githubProfile={}", ObjectMapperUtils.toJson(githubProfile));

    }

}

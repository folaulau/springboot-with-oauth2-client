package com.lovemesomecoding.oauth2.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lovemesomecoding.oauth2.utils.PathUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // ...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.cors().and().csrf().disable()
        .authorizeRequests()
        
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll()
        .antMatchers(PathUtils.PING_URLS)
            .permitAll()
        .antMatchers(PathUtils.PUBLIC_URLS)
            .permitAll()
        .antMatchers(PathUtils.TEST_URLS)
            .permitAll()
        .antMatchers(PathUtils.SWAGGER_DOC_URLS)
            .permitAll()
        .antMatchers(PathUtils.LOGIN_URLS)
            .permitAll()
        .anyRequest()
            .permitAll();

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher(PathUtils.LOGOUT_URLS[0]));
        // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) {
        // @formatter:off
        web.ignoring()
        .antMatchers(PathUtils.PING_URLS)
        .antMatchers(PathUtils.PUBLIC_URLS)
        .antMatchers(PathUtils.TEST_URLS)
        .antMatchers(PathUtils.LOGIN_URLS)
        .antMatchers(PathUtils.SWAGGER_DOC_URLS)
        .antMatchers("/resources/**")
        .antMatchers("/actuator/**");
        // @formatter:on
    }

}

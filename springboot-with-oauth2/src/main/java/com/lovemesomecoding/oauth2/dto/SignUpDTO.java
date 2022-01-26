package com.lovemesomecoding.oauth2.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.oauth2.user.Oauth2ClientType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(value = Include.NON_NULL)
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Oauth2ClientType  clientType;

    /**
     * for GITHUB, GOOGLE, and FACEBOOK
     */
    private String            token;

    /**
     * for USERNAME_PASSWORD
     */
    private String            password;

    private String            email;

}

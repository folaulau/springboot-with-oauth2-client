package com.lovemesomecoding.oauth2.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccessTokenDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "access_token")
    private String            accessToken;
    private String            scope;
    @JsonProperty(value = "token_type")
    private String            tokenType;
}

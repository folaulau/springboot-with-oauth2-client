package com.lovemesomecoding.oauth2.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
public class ClientInfoDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public String             login;
    public String             name;
    public String             email;

}

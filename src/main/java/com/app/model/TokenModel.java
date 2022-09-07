package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenModel {
    String access_token;
    String token;
    String expires_in;
    String refresh_token;
    String identity_token;
    String token_type;
    StatusModel status;

}

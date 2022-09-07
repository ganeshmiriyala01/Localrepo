package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LDAPRequestBodyModel {

    String domain;
    String login_id;
    String password;
    String group_code;
    String return_user_data;
    String create_session;
}
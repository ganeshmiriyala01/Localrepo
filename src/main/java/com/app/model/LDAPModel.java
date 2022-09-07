package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LDAPModel {
    String session_id;
    StatusModel status;
    UserDataModel user_data;
}

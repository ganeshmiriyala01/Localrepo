package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataModel {
    UserInfoModel user_info;
    LoggedInUserDataModel user_login_data; // add attributes
    List<GroupModel> groups;
    List<PermissionModel> permissions;
    List<RoleModel> roles;
    List<String> profiles;  // need to find profile model data
    List<String> account_ids;
    List<String> ip_restrictions;
    List<String> sec_questions;
    List<String> user_nvps;
}

package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoModel {
    public String login_id;
    public String first_name;
    public String last_name;
    public String email_address ;
    public String phone;
    public String phone_ext;
    public String status;
    public String employee_id;
    public String user_type;
    public String id_typ ;
    public String internal_type_status;
    public String date_added;
    public String user_added;
    public String auth_user_id;
    public String domain;
    public String work_fax;
    public String date_changed;
    public String user_changed;
    public boolean is_sales_rep;

}

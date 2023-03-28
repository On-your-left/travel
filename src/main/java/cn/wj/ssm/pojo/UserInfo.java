package cn.wj.ssm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;


    public String getStatusStr() {

        if (status == 1){
            this.statusStr = "开启";
        }else if (status == 0){
            this.statusStr = "关闭";
        }

        return statusStr;
    }
}
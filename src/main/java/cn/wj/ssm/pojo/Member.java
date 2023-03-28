package cn.wj.ssm.pojo;

import lombok.Data;


@Data
public class Member {
    private String id;
    private String mname;
    private String nickname;
    private String mphoneNum;
    private String email;
}
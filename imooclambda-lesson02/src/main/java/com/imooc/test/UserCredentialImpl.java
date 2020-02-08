package com.imooc.test;

public class UserCredentialImpl implements  IUserCredential {
    @Override
    public String verifyUser(String username) {
        if("admin".equals(username)){
            return "系统管理管理员";
        } else if("mangaer".equals(username)){
            return "用户管理员";
        }
        return "普通会员";
    }
}

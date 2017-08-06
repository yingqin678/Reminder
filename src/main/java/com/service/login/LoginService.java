package com.service.login;

import com.service.login.mapper.LoginMapper;
import com.service.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public void setIpAndName(String ip, String name) {
        User user = new User(ip, name);

        loginMapper.setIpAndName(user);
    }

    public String getName(String ip) {
        return loginMapper.getName(ip);
    }
}

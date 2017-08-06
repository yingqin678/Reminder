package com.service.login.mapper;

import com.service.login.model.User;

public interface LoginMapper {
    void setIpAndName(User user);

    String getName(String ip);
}

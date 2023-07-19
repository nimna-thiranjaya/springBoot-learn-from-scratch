package com.nimna.securitywithjwt.service;

import com.nimna.securitywithjwt.entity.User;

public interface UserService {
    public User registerUser(User user);

    public void initRoleAndUser();
}

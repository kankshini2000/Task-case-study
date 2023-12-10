package com.casestudy.formservice.service;

import com.casestudy.formservice.entity.User;

public interface UserService {

    User addUser(User user);
    User getUser(String userName);
}

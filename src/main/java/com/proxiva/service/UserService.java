package com.proxiva.service;

import com.proxiva.model.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);
}
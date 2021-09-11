package com.kcode.library.service;



import com.kcode.library.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long userId);

    List<User> findUsers();

    void updateUser(Long userId, User user);

    void deleteUser(Long userId);

    String generateNewPassword(Long userId);
}

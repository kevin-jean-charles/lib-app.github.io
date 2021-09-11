package com.kcode.library.service.impl;

import com.kcode.library.model.User;
import com.kcode.library.repository.UserRepository;
import com.kcode.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;
    private static final String USER_NOT_FOUND_MSG = "User with id %s not found";

    @Override
    public User findUserById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, userId)
                ));
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    //pour
    @Override
    public void updateUser(Long userId, User user) {
        User _user = findUserById(userId);
        _user.setUsername(user.getUsername());
        _user.setEmail(user.getEmail());
        _user.setPassword(user.getPassword());
        userRepository.save(_user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public String generateNewPassword(Long userId) {
        User user = findUserById(userId);
        String newPassword = UUID.randomUUID().toString();
        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
        return newPassword;
    }
}

package com.redventures.ramengo.admin.services.impl;

import com.redventures.ramengo.admin.domain.User;
import com.redventures.ramengo.admin.dto.UserDTO;
import com.redventures.ramengo.admin.repository.UserRepository;
import com.redventures.ramengo.admin.services.IUserService;
import com.redventures.ramengo.admin.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDTO user) {
        var userEntity = UserConverter.toEntity(user);
        return userRepository.save(userEntity);
    }
}

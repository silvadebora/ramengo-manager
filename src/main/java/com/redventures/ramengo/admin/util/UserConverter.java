package com.redventures.ramengo.admin.util;

import com.redventures.ramengo.admin.domain.User;
import com.redventures.ramengo.admin.dto.UserDTO;

public class UserConverter {

    public static User toEntity(UserDTO user){
        return new User(user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword());
    }
}

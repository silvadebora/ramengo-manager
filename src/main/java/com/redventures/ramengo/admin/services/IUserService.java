package com.redventures.ramengo.admin.services;

import com.redventures.ramengo.admin.domain.User;
import com.redventures.ramengo.admin.dto.UserDTO;

public interface IUserService {

    User save(UserDTO user);
}

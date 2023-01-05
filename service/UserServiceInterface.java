package com.cssewa.sample.user.service;

import com.cssewa.sample.login.model.Status;
import com.cssewa.sample.user.model.dto.UserDto;
import com.cssewa.sample.user.model.dto.UserRegisterDto;
import com.cssewa.sample.user.model.entity.User;
import org.springframework.data.domain.Page;

public interface UserServiceInterface {
    User saveUser(UserDto dto);

    UserRegisterDto saveUserDetails(UserRegisterDto dto);

    Page<UserRegisterDto> getAllUser(int offset, int page);

    UserRegisterDto getById(long id);

    UserRegisterDto changeStatus(Status status, long id);

    UserRegisterDto changeRole(long userId, long roleId);
}

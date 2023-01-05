package com.cssewa.sample.user.service;

import com.cssewa.sample.user.model.dto.UserRelativeDto;
import com.cssewa.sample.user.model.entity.UserRelative;

public interface UserRelativeServiceInterface {

    UserRelative saveUserRelative(UserRelativeDto dto);
}

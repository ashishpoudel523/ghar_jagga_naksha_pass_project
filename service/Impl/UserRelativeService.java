package com.cssewa.sample.user.service.Impl;

import com.cssewa.sample.user.model.dto.UserRelativeDto;
import com.cssewa.sample.user.model.entity.UserRelative;
import com.cssewa.sample.user.repository.UserRelativeRepository;
import com.cssewa.sample.user.service.UserRelativeServiceInterface;
import com.cssewa.sample.utils.DtoConverter;
import com.cssewa.sample.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRelativeService implements UserRelativeServiceInterface {

    @Autowired
    UserRelativeRepository repo;

    public UserRelative saveUserRelative(UserRelativeDto dto){
        return repo.save(DtoConverter.convert(dto));
    }

}

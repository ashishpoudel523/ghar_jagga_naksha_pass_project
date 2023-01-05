package com.cssewa.sample.user.controller;


import com.cssewa.sample.user.model.dto.UserRelativeDto;
import com.cssewa.sample.user.model.entity.UserRelative;
import com.cssewa.sample.user.repository.UserRelativeRepository;
import com.cssewa.sample.user.service.Impl.UserRelativeService;
import com.cssewa.sample.user.service.UserRelativeServiceInterface;
import com.cssewa.sample.utils.DtoConverter;
import com.cssewa.sample.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/relative")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRelativesController {

    @Autowired
    UserRelativeServiceInterface service;

    public ResponseEntity saveUserRelative(@RequestBody UserRelativeDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveUserRelative(dto)));
    }

}

package com.cssewa.sample.user.controller;

import com.cssewa.sample.user.model.dto.UserDocumentDto;
import com.cssewa.sample.user.model.dto.UserDto;
import com.cssewa.sample.user.model.entity.UserDocument;
import com.cssewa.sample.user.service.UserDocumentServiceInterface;
import com.cssewa.sample.user.service.UserServiceInterface;
import com.cssewa.sample.utils.DtoConverter;
import com.cssewa.sample.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/document")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserDocumentController {

    @Autowired
    UserDocumentServiceInterface service;

    @PostMapping
    public ResponseEntity saveUserDocument(@RequestBody UserDocumentDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveUserDocument(dto)));
    }

}

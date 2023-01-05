package com.cssewa.sample.user.controller;

import com.cssewa.sample.login.model.Status;
import com.cssewa.sample.user.model.dto.UserDto;
import com.cssewa.sample.user.model.dto.UserRegisterDto;
import com.cssewa.sample.user.service.UserServiceInterface;
import com.cssewa.sample.utils.Constants;
import com.cssewa.sample.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto dto){
        return ResponseMessage.success(userServiceInterface.saveUser(dto));
    }

    @PostMapping("/details")
    public ResponseEntity saveUserDetails(@RequestBody UserRegisterDto dto){
        return ResponseMessage.success(userServiceInterface.saveUserDetails(dto));
    }

    @GetMapping("/{offset}/{page}")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity getUserDetails(@PathVariable("offset") int offset, @PathVariable("page") int page){
        return ResponseMessage.success(userServiceInterface.getAllUser(offset, page));

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        return ResponseMessage.success(userServiceInterface.getById(id));
    }

    @GetMapping("/status/{id}/{status}")
//    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity changeUserStatus(@PathVariable("id") long id, @PathVariable("status")Status status){
        return ResponseMessage.success(userServiceInterface.changeStatus(status,id));
    }

    @GetMapping("/role")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity changeUserRole(@RequestParam("roleId") long roleId, @RequestParam("userId") long userId){
        return ResponseMessage.success(userServiceInterface.changeRole(userId,roleId));

    }

}

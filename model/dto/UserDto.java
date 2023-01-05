package com.cssewa.sample.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;

    private String nameEng;

    private String nameNep;

    private String email;

    private String gender;

    private String maritalStatus;

    private String photoName;

    private String phoneNo;



}

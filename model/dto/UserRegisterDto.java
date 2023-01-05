package com.cssewa.sample.user.model.dto;



import com.cssewa.sample.login.model.Dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    private UserDto user;

    private List<UserRelativeDto> userRelative;

    private UserDocumentDto userDocument;

    private LoginDto login;

    private List<UserAddressDto> addresses;

    private List<UserAddressDetail> addressDetails;
}

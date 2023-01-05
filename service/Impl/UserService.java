package com.cssewa.sample.user.service.Impl;


import com.cssewa.sample.personrole.model.PersonRole;
import com.cssewa.sample.personrole.repository.PersonRoleRepository;
import com.cssewa.sample.login.model.Login;
import com.cssewa.sample.login.model.Status;
import com.cssewa.sample.login.repository.SecurityUserRepository;
import com.cssewa.sample.user.model.dto.UserAddressDto;
import com.cssewa.sample.user.model.dto.UserDto;
import com.cssewa.sample.user.model.dto.UserRegisterDto;
import com.cssewa.sample.user.model.dto.UserRelativeDto;
import com.cssewa.sample.user.model.entity.User;
import com.cssewa.sample.user.model.entity.UserAddress;
import com.cssewa.sample.user.model.entity.UserDocument;
import com.cssewa.sample.user.model.entity.UserRelative;
import com.cssewa.sample.user.repository.UserAddressRepository;
import com.cssewa.sample.user.repository.UserDocumentRepository;
import com.cssewa.sample.user.repository.UserRelativeRepository;
import com.cssewa.sample.user.repository.UserRepository;
import com.cssewa.sample.user.service.UserServiceInterface;
import com.cssewa.sample.utils.DtoConverter;
import com.cssewa.sample.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService  implements UserServiceInterface {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SecurityUserRepository loginRepo;

    @Autowired
    UserRelativeRepository relativeRepo;

    @Autowired
    UserDocumentRepository documentRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserAddressRepository addressRepo;

    @Autowired
    PersonRoleRepository roleRepo;

    @Override
    public User saveUser(UserDto dto){
        return userRepo.save(DtoConverter.convert(dto));
    }


    @Transactional
    public UserRegisterDto saveUserDetails(UserRegisterDto dto){

        User user =userRepo.save(DtoConverter.convert(dto.getUser()));

        Login login = new Login();
        login.setUsername(dto.getLogin().getUsername());
        login.setPassword(bCryptPasswordEncoder.encode(dto.getLogin().getPassword()));
        PersonRole personRole = new PersonRole();
        personRole.setId(dto.getLogin().getUserRole());
        login.setUser(user);
        login.setUserRole(personRole);
        login.setStatus(Status.unapproved);

        Login findLogin = loginRepo.getUserByUsername(dto.getLogin().getUsername());
        if (findLogin==null)
            loginRepo.save(login);
        else
            throw new SendErrorMessageCustom("Username already exists");


        UserDocument userDocument = DtoConverter.convert(dto.getUserDocument());
        userDocument.setUser(user);

        UserDocument savedUserDocument = documentRepo.save(userDocument);
        List<UserRelative> userRelatives = new ArrayList<>();
        for (UserRelativeDto rDto: dto.getUserRelative()) {
            UserRelative userRelative = DtoConverter.convert(rDto);
            userRelative.setUser(user);
            userRelatives.add(relativeRepo.save(userRelative));
        }

        List<UserAddress> savedAddress = new ArrayList<>();
        for (UserAddressDto aDto: dto.getAddresses()){
                UserAddress address = DtoConverter.convert(aDto);
                address.setUser(user);
                savedAddress.add(addressRepo.save(address));
        }

        UserRegisterDto sendDto = new UserRegisterDto();
        sendDto.setUser(DtoConverter.convert(user));
        sendDto.setUserDocument(DtoConverter.convert(savedUserDocument));
        sendDto.setUserRelative(userRelatives.stream().map(DtoConverter::convert).collect(Collectors.toList()));
        sendDto.setAddresses(savedAddress.stream().map(DtoConverter::convert).collect(Collectors.toList()));
        return sendDto;

    }

    @Override
    public Page<UserRegisterDto> getAllUser(int offset, int page) {
        Page<User> getUser= userRepo.findAll(PageRequest.of(offset, page));
        Page<UserRegisterDto> dto = getUser.map((a)->DtoConverter.convertSend(a,addressRepo.findByUser(a)));
        return dto;
    }

    @Override
    public UserRegisterDto getById(long id) {
        try {
            User user = userRepo.findById(id).orElseThrow();
            return DtoConverter.convertSend(user,addressRepo.findByUser(user));
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided User Doesn't Exists");
        }

    }

    @Override
    public UserRegisterDto changeStatus(Status status, long id){
        User user = null;
        try {
            user = userRepo.findById(id).orElseThrow();
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided user doesn't exists");
        }
        Login login = loginRepo.findByUser(user);
        login.setStatus(status);
        loginRepo.save(login);
        return DtoConverter.convertSend(user,addressRepo.findByUser(user));
    }

    @Override
    public UserRegisterDto changeRole(long userId, long roleId) {
        User user = null;
        try {
            user = userRepo.findById(userId).orElseThrow();
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided user doesn't exists");
        }
        Login login = loginRepo.findByUser(user);

        try{
            PersonRole personRole = roleRepo.findById(roleId).orElseThrow();
            login.setUserRole(personRole);
            loginRepo.save(login);
            return DtoConverter.convertSend(user,addressRepo.findByUser(user));
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Given Role doesn't exists");
        }

    }


}

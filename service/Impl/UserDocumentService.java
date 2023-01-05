package com.cssewa.sample.user.service.Impl;


import com.cssewa.sample.user.model.dto.UserDocumentDto;
import com.cssewa.sample.user.model.entity.UserDocument;
import com.cssewa.sample.user.repository.UserDocumentRepository;
import com.cssewa.sample.user.service.UserDocumentServiceInterface;
import com.cssewa.sample.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDocumentService  implements UserDocumentServiceInterface {

    @Autowired
    UserDocumentRepository userDocumentRepository;

    @Override
    public UserDocument saveUserDocument(UserDocumentDto dto){
        return userDocumentRepository.save(DtoConverter.convert(dto));
    }
}

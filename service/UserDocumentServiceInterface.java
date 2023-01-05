package com.cssewa.sample.user.service;

import com.cssewa.sample.user.model.dto.UserDocumentDto;
import com.cssewa.sample.user.model.entity.UserDocument;

public interface UserDocumentServiceInterface {

    UserDocument saveUserDocument(UserDocumentDto dto);
}

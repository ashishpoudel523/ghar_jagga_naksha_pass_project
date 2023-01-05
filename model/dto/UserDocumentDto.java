package com.cssewa.sample.user.model.dto;

import com.cssewa.sample.user.model.entity.DocumentType;
import com.cssewa.sample.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocumentDto {

    private long id;

    private String identityNo;

    private String issuedPlace;

    private Date issueDate;

    private String filename;

    private long userId;

    private DocumentType documentType;
}

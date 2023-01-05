package com.cssewa.sample.user.model.dto;

import com.cssewa.sample.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRelativeDto {

    private long id;

    private String relativeNameEng;

    private String relativeNameNep;

    private String relations;

    private long userId;
}

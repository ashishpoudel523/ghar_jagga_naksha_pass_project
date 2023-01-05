package com.cssewa.sample.user.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRelative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String relativeNameEng;

    private String relativeNameNep;

    private String relations;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
}

package com.cssewa.sample.user.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String identityNo;

    private String issuedPlace;

    private Date issueDate;

    private String filename;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

}

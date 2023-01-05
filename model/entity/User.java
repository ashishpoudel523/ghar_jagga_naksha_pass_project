package com.cssewa.sample.user.model.entity;

import com.cssewa.sample.login.model.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameEng;

    private String nameNep;

    private String email;

    private String gender;

    private String maritalStatus;

    private String photoName;

    private String phoneNo;

    @OneToOne(mappedBy = "user")
    private Login login;

    @OneToMany(mappedBy = "user")
    private List<UserDocument> userDocument;

    @OneToMany(mappedBy = "user")
    private List<UserRelative> userRelative;

    @OneToMany(mappedBy = "user")
    private List<UserAddress> addresses;

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


}

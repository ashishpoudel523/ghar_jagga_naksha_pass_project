package com.cssewa.sample.user.model.entity;


import com.cssewa.sample.address.model.entity.DefaultEntityModel;
import com.cssewa.sample.address.model.entity.Ward;
import jakarta.persistence.*;


@Entity
public class UserAddress extends DefaultEntityModel {


	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ward_id", referencedColumnName = "id"),
			@JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id"),
			@JoinColumn(name = "district_id", referencedColumnName = "district_id"),
			@JoinColumn(name = "province_id", referencedColumnName = "province_id")

	})
	private Ward ward;

	private String toleNep;

	private String toleEng;

	@Enumerated(EnumType.STRING)
	private UserAddressType type;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public String getToleNep() {
		return toleNep;
	}

	public void setToleNep(String toleNep) {
		this.toleNep = toleNep;
	}

	public String getToleEng() {
		return toleEng;
	}

	public void setToleEng(String toleEng) {
		this.toleEng = toleEng;
	}

	public UserAddressType getType() {
		return type;
	}

	public void setType(UserAddressType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//	public List<UserAddress> getUserAddresses() {
//		return userAddresses;
//	}
//
//	public void setUserAddresses(List<UserAddress> userAddresses) {
//		this.userAddresses = userAddresses;
//	}

}

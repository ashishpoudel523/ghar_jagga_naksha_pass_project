package com.cssewa.sample.user.service;



import com.cssewa.sample.user.model.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
	
	List<UserAddress>getAddress();
	
	UserAddress saveAddress(UserAddress address);
	boolean deleteAddress(long id);

}

package com.cssewa.sample.user.service.Impl;


import com.cssewa.sample.user.model.entity.UserAddress;
import com.cssewa.sample.user.repository.UserAddressRepository;
import com.cssewa.sample.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
	
	@Autowired
	private UserAddressRepository addressRepository;

	@Override
	public List<UserAddress> getAddress() {
		
		return addressRepository.findAll();
	}

	@Override
	public UserAddress saveAddress(UserAddress address) {
		
		/*
		System.out.println("Ward id: "+address.getWard().getWardPK().getId());
		System.out.println("Municipality id: "+address.getWard().getWardPK().getMunicipality().getMunicipalityPK().getId());
		System.out.println("District id: "+address.getWard().getWardPK().getMunicipality().getMunicipalityPK()
				.getDistrict().getDistrictPK().getId());
		
		System.out.println("Province id: "+address.getWard().getWardPK().getMunicipality().getMunicipalityPK()
				.getDistrict().getDistrictPK().getProvince().getId());
		*/
		return addressRepository.save(address);
	}

	@Override
	public boolean deleteAddress(long id){
		UserAddress address = addressRepository.findById(id).orElse(null);
		if (address!=null){
			addressRepository.delete(address);
			return true;
		}else{
			return false;
		}
	}

}

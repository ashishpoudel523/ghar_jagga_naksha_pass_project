package com.cssewa.sample.user.controller;

import com.cssewa.sample.user.model.dto.UserAddressDto;
import com.cssewa.sample.user.model.entity.UserAddress;
import com.cssewa.sample.user.service.UserAddressService;
import com.cssewa.sample.utils.DtoConverter;
import com.cssewa.sample.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserAddressController {
	@Autowired
	private UserAddressService addressService;
	
	@GetMapping("/all")
	//@Secured(ADDRESS_MODULE.SELECT)
	public ResponseEntity getAllAddress() {
		
		return ResponseMessage.success(addressService.getAddress().stream()
				.map(DtoConverter::convert)
				.collect(Collectors.toList())
				);
	}
	@PostMapping
	//@Secured(ADDRESS_MODULE.INSERT)
	public ResponseEntity saveAddress(@RequestBody UserAddressDto address) {
	System.out.println(" -------------- address controller -------------" );
		UserAddress address1 = addressService.saveAddress(DtoConverter.convert(address));
		return ResponseMessage.success(address1.getId(), "Address Saved Successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteAddress(@PathVariable("id") long id){
		boolean check = addressService.deleteAddress(id);
		return ResponseMessage.success("Address Deleted Successfully");
	}
	
}

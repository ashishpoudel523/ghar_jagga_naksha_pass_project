package com.cssewa.sample.user.model.dto;


import com.cssewa.sample.user.model.entity.UserAddressType;

public class UserAddressDto {

	private long id;

	private long wardId;
	private long municipalityId;
	private long districtId;
	private long provinceId;
	private String toleNep;
	private String toleEng;
	private UserAddressType type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWardId() {
		return wardId;
	}
	public void setWardId(long wardId) {
		this.wardId = wardId;
	}
	public long getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(long municipalityId) {
		this.municipalityId = municipalityId;
	}
	public long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
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

}


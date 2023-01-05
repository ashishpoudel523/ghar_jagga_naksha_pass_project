package com.cssewa.sample.user.repository;


import com.cssewa.sample.user.model.entity.UserAddress;
import com.cssewa.sample.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{
        List<UserAddress> findByUser(User user);

}

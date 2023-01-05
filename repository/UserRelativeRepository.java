package com.cssewa.sample.user.repository;

import com.cssewa.sample.user.model.entity.UserRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRelativeRepository extends JpaRepository<UserRelative,Long> {
}

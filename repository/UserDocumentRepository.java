package com.cssewa.sample.user.repository;


import com.cssewa.sample.user.model.entity.UserDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDocumentRepository extends JpaRepository<UserDocument,Long> {
}

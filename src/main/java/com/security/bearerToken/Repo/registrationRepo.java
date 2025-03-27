package com.security.bearerToken.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.bearerToken.model.userRegistration;

@Repository
public interface registrationRepo extends JpaRepository<userRegistration, String> {

}

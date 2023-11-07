package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Userr;

public interface UserRepository extends JpaRepository<Userr, Long>{

}

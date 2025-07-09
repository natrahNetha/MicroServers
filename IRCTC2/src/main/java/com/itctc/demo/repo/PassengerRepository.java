package com.itctc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itctc.demo.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity,Integer> {

}

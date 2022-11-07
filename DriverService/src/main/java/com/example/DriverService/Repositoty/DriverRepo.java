package com.example.DriverService.Repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DriverService.Entity.Driver;


public interface DriverRepo extends JpaRepository<Driver, Integer>{

}

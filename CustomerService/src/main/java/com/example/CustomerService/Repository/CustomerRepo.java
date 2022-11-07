package com.example.CustomerService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CustomerService.Entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}

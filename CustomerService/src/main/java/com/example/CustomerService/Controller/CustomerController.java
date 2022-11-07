package com.example.CustomerService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Entity.Customer;
import com.example.CustomerService.Repository.CustomerRepo;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo;
	@RequestMapping(path ="/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	
	@RequestMapping(path ="/customer")
	public ResponseEntity<java.util.List<Customer>> getAll() {
		
		List<Customer> listCitizen = customerRepo.findAll();
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	
	@PostMapping(path ="/add")
	public ResponseEntity<Customer> addCitizen(@RequestBody Customer newCustomer) {
		
		Customer customer = customerRepo.save(newCustomer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	
}

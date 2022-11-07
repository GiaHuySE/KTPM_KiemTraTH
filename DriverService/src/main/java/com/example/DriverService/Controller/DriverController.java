package com.example.DriverService.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.DriverService.Entity.Driver;
import com.example.DriverService.Model.Customer;
import com.example.DriverService.Model.RequireResponse;
import com.example.DriverService.Repositoty.DriverRepo;




@RestController
@RequestMapping("/driver")
public class DriverController {
	
	private static final String USER_SERVIVE="vaccinationService";
	private int attempt = 1;
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path ="/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	
	@PostMapping(path ="/add")
	public ResponseEntity<Driver> addVaccinationCenter(@RequestBody Driver newDriver) {
		
		Driver vaccinationCenter = driverRepo.save(newDriver);
		return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	//@CircuitBreaker(name = USER_SERVIVE,fallbackMethod = "handleCitizenDownTime")
	//@Retry(name = USER_SERVIVE,fallbackMethod = "handleCitizenDownTime")
	//@RateLimiter(name = USER_SERVIVE,fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequireResponse> getAllDataBasedonCenterId(@PathVariable Integer id){
		RequireResponse requireResponse = new RequireResponse();
		Driver driver = driverRepo.findById(id).get();
		requireResponse.setDriver(driver);
		List<Customer> listOfCustomer =restTemplate.getForObject("http://localhost:8081/customer/customer", List.class);
		requireResponse.setCustomer(listOfCustomer);
		System.out.println("retry method called"+attempt++ +"times"+" at "+ new Date());
		return new ResponseEntity<RequireResponse>(requireResponse,HttpStatus.OK);
	}
	
}

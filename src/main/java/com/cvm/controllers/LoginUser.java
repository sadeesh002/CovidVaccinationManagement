package com.cvm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.AdminAuthentication;
import com.cvm.entities.EmployeesAuthentication;
import com.cvm.entities.MedicalstaffAuthentication;
import com.cvm.exceptions.EmailIdNotFoundException;
import com.cvm.services.EmployeeAuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/api/v1")
public class LoginUser {

	@Autowired
	EmployeeAuthenticationService uas;
	
	@Operation(summary = "Employee Login")
	@PostMapping("/login/employees")
	public ResponseEntity<String> doLogin(@RequestBody EmployeesAuthentication emp) throws EmailIdNotFoundException {
		String msg = uas.login(emp.getEmailId(), emp.getPassword());
		ResponseEntity<String> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	@Operation(summary = "Admin Login")
	@PostMapping("/login/admins")
	public ResponseEntity<String> doLoginAdmin(@RequestBody AdminAuthentication admin) throws EmailIdNotFoundException {
		String msg = uas.loginadmin(admin.getEmailId(), admin.getPassword());
		ResponseEntity<String> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	@Operation(summary = "Medical Staff Login")
	@PostMapping("/login/staffs")
	public ResponseEntity<String> doLoginStaff(@RequestBody MedicalstaffAuthentication staff) throws EmailIdNotFoundException {
		String msg = uas.loginstaff(staff.getEmailId(), staff.getPassword());
		ResponseEntity<String> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	

}

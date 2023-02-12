package com.cvm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.Admin;
import com.cvm.entities.Employeess;
import com.cvm.entities.MedicalStaff;
import com.cvm.services.RegisterUserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/api/v1")
public class RegisterUser {

	@Autowired
	RegisterUserService rs;
	
	@Operation(summary = "Register Admin")
	@PostMapping("/admins")
	public ResponseEntity<String> addAdmin( @Valid @RequestBody Admin admin) {
		String msg = rs.insertAdmin(admin);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Register Employee")
	@PostMapping("/employees")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employeess emp) {
		String msg = rs.insertEmployee(emp);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Register Medical Staff")
	@PostMapping("/staffs")
	public ResponseEntity<String> addMedicalStaff(@Valid @RequestBody MedicalStaff staff) {
		String msg = rs.insertMedicalStaff(staff);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
}

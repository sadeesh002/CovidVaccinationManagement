package com.cvm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.Admin;
import com.cvm.exceptions.AdminsIdNotFoundException;
import com.cvm.exceptions.NoAdminsFoundException;
import com.cvm.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService as;

//	@PostMapping("/admins")
//	public ResponseEntity<String> addAdmin( @Valid @RequestBody Admin admin) {
//		String msg = as.insertAdmin(admin);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@GetMapping("/admins")
	public List<Admin> fetchAllAdmins() throws NoAdminsFoundException {
		return as.findAll();
	}

	@GetMapping("/admins/{adminId}")
	public ResponseEntity<Admin> fetchAdminById(@PathVariable("adminId") long adminId) throws AdminsIdNotFoundException {
		Admin msg = as.findByAdminId(adminId);
		ResponseEntity<Admin> rEntity = new ResponseEntity<Admin>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@PutMapping("/admins/{adminId}")
	public String modifyAdmin(@PathVariable("adminId") long adminId,@Valid @RequestBody Admin admins)
			throws AdminsIdNotFoundException {
		return as.updateAdmin(adminId, admins);
	}

	@DeleteMapping("/admins/{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("adminId") long adminId)
			throws AdminsIdNotFoundException {
		String msg = as.deleteById(adminId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}

}

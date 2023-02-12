package com.cvm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.Slot;
import com.cvm.exceptions.NoSlotsFoundException;
import com.cvm.exceptions.SlotIdNotFoundException;
import com.cvm.services.AdminsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/api/v1")
public class AdminsController {
	
	@Autowired
	AdminsService ass;
	
	@Operation(summary = "Adding slots")
	@PostMapping("/add/slotdetails/{adminId}")
	public ResponseEntity<String> addSlot(@Valid @RequestBody Slot slots) {
		String msg = ass.insertSlot(slots);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Get Registered Slot Details")
	@GetMapping("/employees/{slotId}")
	public List<Slot> fetchAllSlots() throws NoSlotsFoundException {
		return ass.findAll();
	}

}

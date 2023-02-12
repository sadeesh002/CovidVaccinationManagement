package com.cvm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.Certification;
import com.cvm.entities.VitalsAtVaccination;
import com.cvm.services.MedicalStaffsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/api/v1")
public class MedicalStaffsController {
	
	@Autowired
	MedicalStaffsService msService;
	
	@Operation(summary = "Add VitalDetails")
	@PostMapping("/vitals/Vaccination/{empId}/{slotId}/{staffId}")
	public ResponseEntity<String> addVitals(@Valid @RequestBody VitalsAtVaccination vitals) {
		String msg = msService.insertVitals(vitals);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Add Certificates")
	@PostMapping("/employee/{empId}/certificates")
	public ResponseEntity<String> addCertificate(@RequestBody Certification certificates) {
		String msg = msService.insertCertificate(certificates);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
}

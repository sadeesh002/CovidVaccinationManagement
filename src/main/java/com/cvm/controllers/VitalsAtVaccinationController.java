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

import com.cvm.entities.VitalsAtVaccination;
import com.cvm.exceptions.NoVitalsFoundException;
import com.cvm.exceptions.VitalIdNotFoundException;
import com.cvm.services.VitalsAtVaccinationService;

@RestController
public class VitalsAtVaccinationController {
	@Autowired
	VitalsAtVaccinationService vs;

//	@PostMapping("/vitals")
//	public ResponseEntity<String> addVitals(@Valid @RequestBody VitalsAtVaccination vitals) {
//		String msg = vs.insertVitals(vitals);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@GetMapping("/vitals")
	public List<VitalsAtVaccination> fetchAllVitals() throws NoVitalsFoundException {
		return vs.findAll();
	}

//	@GetMapping("/vitals/{vitalId}")
//	public ResponseEntity<VitalsAtVaccination> fetchVitalsById(@PathVariable("vitalId") long vitalId)
//			throws VitalIdNotFoundException {
//		VitalsAtVaccination msg = vs.findByVitalId(vitalId);
//		ResponseEntity<VitalsAtVaccination> rEntity = new ResponseEntity<VitalsAtVaccination>(msg, HttpStatus.FOUND);
//		return rEntity;
//	}

	@PutMapping("/vitals/{vitalId}")
	public String modifyVital(@PathVariable("vitalId") long vitalId,@Valid @RequestBody VitalsAtVaccination vitals)
			throws VitalIdNotFoundException {
		return vs.updateVital(vitalId, vitals);
	}

	@DeleteMapping("/vitals/{vitalId}")
	public ResponseEntity<String> deleteVitalById(@PathVariable("vitalId") long vitalId)
			throws VitalIdNotFoundException {
		String msg = vs.deleteById(vitalId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}
	
//	@GetMapping("/vitals/{empId}")
//	public ResponseEntity<List<VitalsAtVaccination>> fetchVitalsByEmpId(@PathVariable("empId") long empId)
//			throws VitalIdNotFoundException {
//		List<VitalsAtVaccination> msg = vs.findByVitalsId(empId);
//		ResponseEntity<List<VitalsAtVaccination>> rEntity = new ResponseEntity<List<VitalsAtVaccination>>(msg,
//				HttpStatus.FOUND);
//		return rEntity;
//	}

}

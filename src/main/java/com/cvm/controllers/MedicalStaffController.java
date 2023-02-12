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

import com.cvm.entities.MedicalStaff;
import com.cvm.exceptions.MedicalStaffIdNotFoundException;
import com.cvm.exceptions.NoMedicalStaffFoundException;
import com.cvm.services.MedicalStaffService;

@RestController
public class MedicalStaffController {

	@Autowired
	MedicalStaffService mss;

//	@PostMapping("/staffs")
//	public ResponseEntity<String> addMedicalStaff(@Valid @RequestBody MedicalStaff staff) {
//		String msg = mss.insertMedicalStaff(staff);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@GetMapping("/staffs")
	public List<MedicalStaff> fetchAllMedicalStaffs() throws NoMedicalStaffFoundException {
		return mss.findAll();
	}

	@GetMapping("/staffs/{staffId}")
	public ResponseEntity<MedicalStaff> findMedicalStaffById(@PathVariable("staffId") long staffId)
			throws MedicalStaffIdNotFoundException {
		MedicalStaff msg = mss.findByMedicalStaffId(staffId);
		ResponseEntity<MedicalStaff> rEntity = new ResponseEntity<MedicalStaff>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@PutMapping("/staffs/{staffId}")
	public String modifyMedicalStaff(@PathVariable("staffId") long staffId,@Valid @RequestBody MedicalStaff staffs)
			throws MedicalStaffIdNotFoundException {
		return mss.updateMedicalStaff(staffId, staffs);
	}

	@DeleteMapping("/staffs/{staffId}")
	public ResponseEntity<String> deleteMedicalStaffById(@PathVariable("staffId") long staffId)
			throws MedicalStaffIdNotFoundException {
		String msg = mss.deleteById(staffId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}

}

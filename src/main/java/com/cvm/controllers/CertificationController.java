package com.cvm.controllers;

import java.util.List;

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

import com.cvm.entities.Certification;
import com.cvm.exceptions.CertificatesIdNotFoundException;
import com.cvm.exceptions.NoCertificatesFoundException;
import com.cvm.services.CertificationService;

@RestController
public class CertificationController {

	@Autowired
	CertificationService cs;

//	@PostMapping("/certificates")
//	public ResponseEntity<String> addCertificate(@RequestBody Certification certificates) {
//		String msg = cs.insertCertificate(certificates);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}


	@GetMapping("/certificates/{certificateId}")
	public ResponseEntity<Certification> fetchCertificateById(@PathVariable("certificateId") long certificateId)
			throws CertificatesIdNotFoundException {
		Certification msg = cs.findBycertificateId(certificateId);
		ResponseEntity<Certification> rEntity = new ResponseEntity<Certification>(msg, HttpStatus.FOUND);
		return rEntity;
	}
    
//	@GetMapping("/certificates/{empId}")
//	public ResponseEntity<List<Certification>> fetchCertificateByEmpId(@PathVariable("empId") long empId)
//			throws CertificatesIdNotFoundException {
//		List<Certification> msg = cs.findByCertificateEmpId(empId);
//		ResponseEntity<List<Certification>> rEntity = new ResponseEntity<List<Certification>>(msg, HttpStatus.FOUND);
//		return rEntity;
//	}

}

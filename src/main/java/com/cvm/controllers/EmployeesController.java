package com.cvm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entities.Certification;
import com.cvm.entities.Employeess;
import com.cvm.entities.VitalsAtVaccination;
import com.cvm.exceptions.CertificatesIdNotFoundException;
import com.cvm.exceptions.EmployeessIdNotFoundException;
import com.cvm.exceptions.VitalIdNotFoundException;
import com.cvm.services.EmployeesService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/covid/api/v1/employee")
public class EmployeesController {

	@Autowired
	EmployeesService ess;
	
	@Operation(summary = "Register Slot")
	@PatchMapping("/{empId}/slot/{slotId}")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employeess emp) {
		String msg = ess.insertEmployee(emp);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Cancel Slot")
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deleteTraineeById(@PathVariable("empId") long employeeId)
			throws EmployeessIdNotFoundException {
		String msg = ess.deleteById(employeeId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	@Operation(summary = "Get Vital Details")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="OK",content=@Content(mediaType="application/json",schema=@Schema(oneOf = VitalsAtVaccination.class))),
			@ApiResponse(responseCode="404",description="NOT_FOUND",content=@Content(mediaType="application/json",schema=@Schema(oneOf = VitalIdNotFoundException.class)))
		})
	@GetMapping("/{empId}/vitals")
	public ResponseEntity<List<VitalsAtVaccination>> fetchVitalsByEmpId(@PathVariable("empId") long empId)
			throws VitalIdNotFoundException {
		List<VitalsAtVaccination> msg = ess.findByVitalsEmpId(empId);
		ResponseEntity<List<VitalsAtVaccination>> rEntity = new ResponseEntity<List<VitalsAtVaccination>>(msg,
				HttpStatus.FOUND);
		return rEntity;
	}
	
	@Operation(summary = "Get Certificate")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="OK",content=@Content(mediaType="application/json",schema=@Schema(oneOf = Certification.class))),
			@ApiResponse(responseCode="404",description="NOT_FOUND",content=@Content(mediaType="application/json",schema=@Schema(oneOf = CertificatesIdNotFoundException.class)))
		})
	@GetMapping("/certificate/{empId}/{doseNo}")
	public ResponseEntity<List<Certification>> fetchCertificateByEmpId(@PathVariable("empId") long empId)
			throws CertificatesIdNotFoundException {
		List<Certification> msg = ess.findByCertificateEmpId(empId);
		ResponseEntity<List<Certification>> rEntity = new ResponseEntity<List<Certification>>(msg, HttpStatus.FOUND);
		return rEntity;
	}
	
}

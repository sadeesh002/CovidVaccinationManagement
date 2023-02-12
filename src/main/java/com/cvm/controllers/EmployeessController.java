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

import com.cvm.entities.Employeess;
import com.cvm.exceptions.EmployeessIdNotFoundException;
import com.cvm.exceptions.NoEmployeesFoundException;
import com.cvm.services.EmployeessService;


@RestController
public class EmployeessController {

	@Autowired
	EmployeessService es;

//	@PostMapping("/employeess")
//	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employeess emp) {
//		String msg = es.insertEmployee(emp);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@GetMapping("/employeess")
	public List<Employeess> fetchAllEmployees() throws NoEmployeesFoundException {
		return es.findAll();
	}

	@GetMapping("/employeess/{employeeId}")
	public ResponseEntity<Employeess> findEmployeeById(@PathVariable("employeeId") long employeeId)
			throws EmployeessIdNotFoundException {
		Employeess msg = es.findByEmployeeId(employeeId);
		ResponseEntity<Employeess> rEntity = new ResponseEntity<Employeess>(msg, HttpStatus.FOUND);
		return rEntity;
	}
	

	@PutMapping("/employeess/{employeeId}")
	public String modifyEmployee(@PathVariable("employeeId") long employeeId,@Valid @RequestBody Employeess emps)
			throws EmployeessIdNotFoundException {
		return es.updateEmployee(employeeId, emps);
	}

//	@DeleteMapping("/employeess/{employeeId}")
//	public ResponseEntity<String> deleteTraineeById(@PathVariable("employeeId") long employeeId)
//			throws EmployeessIdNotFoundException {
//		String msg = es.deleteById(employeeId);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
//		return rEntity;
//	}

}

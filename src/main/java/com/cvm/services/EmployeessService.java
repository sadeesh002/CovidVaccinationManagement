package com.cvm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.EmployeessDao;
import com.cvm.entities.Employeess;
import com.cvm.exceptions.EmployeessIdNotFoundException;
import com.cvm.exceptions.NoEmployeesFoundException;



@Service("es")
public class EmployeessService {
	
	@Autowired
	EmployeessDao ed;

//	public String insertEmployee(Employeess emp) {
//		
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//		String encryptedPwd = bcrypt.encode(emp.getPassword());
//		emp.setPassword(encryptedPwd);
//		
//		Employeess dbEmp=ed.save(emp);
//		return"Added Successfully with Id:"+dbEmp.getEmp_id();
//	}

	public List<Employeess> findAll() throws NoEmployeesFoundException {
		List<Employeess> list= ed.findAll();
		if(list.isEmpty()) {
			throw new NoEmployeesFoundException("No Employee found");			
		}
		return list;
	}

	public Employeess findByEmployeeId(long employeeId) throws EmployeessIdNotFoundException {
		Optional<Employeess> op=ed.findById(employeeId);
  	  if(op.isPresent()) {
  		  return op.get();}
  		  else {
  			throw new EmployeessIdNotFoundException("Employee Not Found For Id:"+employeeId);
  	  }
	}

	public String updateEmployee(long employeeId, Employeess emps) throws EmployeessIdNotFoundException {
		if(employeeId==emps.getEmpId()) {
  		 Employeess upTin=ed.save(emps);
  		  return "Updated Successfully for id:"+upTin.getEmpId();
  	  }
		throw new EmployeessIdNotFoundException("Employee Not Found For Id:"+employeeId);
	}

//	public String deleteById(long employeeId) throws EmployeessIdNotFoundException {
//		if(ed.existsById(employeeId)) {
//  		  ed.deleteById(employeeId);
//  		  return "Deleted Successfully for id:"+employeeId;
//  	  }
//		throw new EmployeessIdNotFoundException("Employee Not Found For Id:"+employeeId);
//    }

//	public Employeess findByEmp_name(String eName) throws EmployeessIdNotFoundException {
//		Optional<Employeess> op= ed.findByEmp_name(eName);
//		if(op.isPresent())
//			return op.get();
//		else
//			throw new EmployeessIdNotFoundException("Employee Not Found for name:"+eName);
//			
//	}
	
	
}

package com.cvm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.CertificationDao;
import com.cvm.dao.EmployeessDao;
import com.cvm.dao.VitalsAtVaccinationDao;
import com.cvm.entities.Certification;
import com.cvm.entities.Employeess;
import com.cvm.entities.VitalsAtVaccination;
import com.cvm.exceptions.CertificatesIdNotFoundException;
import com.cvm.exceptions.EmployeessIdNotFoundException;
import com.cvm.exceptions.VitalIdNotFoundException;

@Service("ess")
public class EmployeesService {
	
	@Autowired
	EmployeessDao edd;
	
	public String insertEmployee(Employeess emp) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(emp.getPassword());
		emp.setPassword(encryptedPwd);

		Employeess dbEmp = edd.save(emp);
		return "Added Successfully with Id:" + dbEmp.getEmpId();
	}

	public String deleteById(long employeeId) throws EmployeessIdNotFoundException {
		if(edd.existsById(employeeId)) {
  		  edd.deleteById(employeeId);
  		  return "Deleted Successfully for id:"+employeeId;
  	  }
		throw new EmployeessIdNotFoundException("Employee Not Found For Id:"+employeeId);
    }
	
	@Autowired
	VitalsAtVaccinationDao vdd;
	
	public List<VitalsAtVaccination> findByVitalsEmpId(long empId) throws VitalIdNotFoundException  {
		 List<VitalsAtVaccination> op = vdd.findByempId(empId);
		if (op.isEmpty()) {
			
			throw new VitalIdNotFoundException("Vital Not Found For employeeId:" + empId);
		} else {
			return op;
		}
	}
	
	@Autowired
	CertificationDao cdd;
	
	public List<Certification> findByCertificateEmpId(long empId) throws CertificatesIdNotFoundException {
		List<Certification> op = cdd.findByempId(empId);
		if (op.isEmpty()) {

			throw new CertificatesIdNotFoundException("Certificate Not Found For employeeId:" + empId);
		} 
		else {
			return op;
		}
	}

}

package com.cvm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.AdminDao;
import com.cvm.dao.EmployeessDao;
import com.cvm.dao.MedicalStaffDao;
import com.cvm.entities.Admin;
import com.cvm.entities.Employeess;
import com.cvm.entities.MedicalStaff;
import com.cvm.exceptions.EmailIdNotFoundException;

@Service("uas")
public class EmployeeAuthenticationService {
	
	@Autowired
	EmployeessDao ed;
	
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	public String login(String emailId, String password) throws EmailIdNotFoundException {
		Optional<Employeess> op= ed.findByEmailId(emailId);
		if(op.isEmpty()) {
			throw new EmailIdNotFoundException("EmailId not registered");
		}
		Employeess employee=op.get();
		if(bcrypt.matches(password,employee.getPassword())){
			 return "Authenticated Successfully";
		}
		throw new EmailIdNotFoundException("Enter Valid Password");
	}
	
	@Autowired
	AdminDao ad;
	
	BCryptPasswordEncoder bcrypt1 = new BCryptPasswordEncoder();
	public String loginadmin(String emailId, String password) throws EmailIdNotFoundException {
		Optional<Admin> opa= ad.findByEmailId(emailId);
		if(opa.isEmpty()) {
			throw new EmailIdNotFoundException("EmailId not registered");
		}
		Admin admin=opa.get();
		if(bcrypt1.matches(password,admin.getPassword())){
			 return "Authenticated Successfully";
		}
		throw new EmailIdNotFoundException("Enter Valid Password");
	}
	
	@Autowired
	MedicalStaffDao msd;
	
	BCryptPasswordEncoder bcrypt2 = new BCryptPasswordEncoder();
	public String loginstaff(String emailId, String password) throws EmailIdNotFoundException {
		Optional<MedicalStaff> opm= msd.findByEmailId(emailId);
		if(opm.isEmpty()) {
			throw new EmailIdNotFoundException("EmailId not registered");
		}
		MedicalStaff staff=opm.get();
		if(bcrypt2.matches(password,staff.getPassword())){
			 return "Authenticated Successfully";
		}
		throw new EmailIdNotFoundException("Enter Valid Password");
	}

}

package com.cvm.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.AdminDao;
import com.cvm.dao.EmployeessDao;
import com.cvm.dao.MedicalStaffDao;
import com.cvm.entities.Admin;
import com.cvm.entities.Employeess;
import com.cvm.entities.MedicalStaff;

@Service("rs")
public class RegisterUserService {
	
	@Autowired
	AdminDao ad; 
	
	public String insertAdmin(Admin admin) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(admin.getPassword());
		admin.setPassword(encryptedPwd);

		Admin dbAdmin = ad.save(admin);
		return "Added Successfully with AdminId:" + dbAdmin.getAdminId();
	}
	
	@Autowired
	EmployeessDao ed;
	
//	public String insertEmployee(Employeess emp) {
//
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//		String encryptedPwd = bcrypt.encode(emp.getPassword());
//		emp.setPassword(encryptedPwd);
//
//		Employeess dbEmp = ed.save(emp);
//		return "Added Successfully with Id:" + dbEmp.getEmp_id();
//	}
	
	@Autowired
	MedicalStaffDao msd;
	
	public String insertMedicalStaff(MedicalStaff staffs) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(staffs.getPassword());
		staffs.setPassword(encryptedPwd);

		MedicalStaff dbStaff = msd.save(staffs);
		return "Added Successfully with staffId:" + dbStaff.getStaffId();
	}

	public String insertEmployee(@Valid Employeess emp) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(emp.getPassword());
		emp.setPassword(encryptedPwd);

		Employeess dbEmp = ed.save(emp);
		return "Added Successfully with Id:" + dbEmp.getEmpId();
	}

}

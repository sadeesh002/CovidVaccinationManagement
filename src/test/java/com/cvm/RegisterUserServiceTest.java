package com.cvm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.AdminDao;
import com.cvm.dao.EmployeessDao;
import com.cvm.dao.MedicalStaffDao;
import com.cvm.entities.Admin;
import com.cvm.entities.Employeess;
import com.cvm.entities.MedicalStaff;
import com.cvm.services.RegisterUserService;

@SpringBootTest
public class RegisterUserServiceTest {
	
	@InjectMocks
	RegisterUserService rss;
	
	@Mock
	MedicalStaffDao mdd;
	
	@Test
	public void insertMedicalStaffTest()
	{
		MedicalStaff mStaff=new MedicalStaff();
		mStaff.setStaffId(1);
		mStaff.setStaff_Name("sadees");
		mStaff.setAssociated_with("abc");
		mStaff.setEmailId("abc1@gmail.com");
		mStaff.setPassword("sdfah5");
		mStaff.setLocation("chennai");
		mStaff.setMobile_no("837377409");
		
		when(mdd.save(mStaff)).thenReturn(mStaff);
		String result = rss.insertMedicalStaff(mStaff);
		assertEquals("Added Successfully with staffId:" + mStaff.getStaffId(), result);
		}
	
	@Mock
	AdminDao add;
	
	@Test
	public void inserAndimTest() {
		
		Admin admin=new Admin();
		admin.setAdminId(1);
		admin.setEmailId("ad@gmail.com");
		admin.setLocation("chennai");
		admin.setPassword("9786543210");
		
		when(add.save(admin)).thenReturn(admin);
		String result=rss.insertAdmin(admin);
		assertEquals("Added Successfully with AdminId:"+admin.getAdminId(), result);
	}
	
	@Mock
	EmployeessDao esd;
	
	@Test
	public void inssertEmployeeTest() {
		
		Employeess emp=new Employeess();
		emp.setEmpId(1);
		emp.setEmp_name("sadeesh");
		emp.setBirthdate(LocalDate.of(2002,10,1));
		emp.setEmailId("emp@gmail.com");
		emp.setPassword("sadee");
		emp.setMobile_no("9876543210");
		
		when(esd.save(emp)).thenReturn(emp);
		String result=rss.insertEmployee(emp);
		assertEquals("Added Successfully with Id:"+emp.getEmpId(), result);
	}

}

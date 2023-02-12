package com.cvm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.EmployeessDao;
import com.cvm.entities.Employeess;
import com.cvm.exceptions.EmployeessIdNotFoundException;
import com.cvm.services.EmployeesService;

@SpringBootTest
public class EmployeesServiceTest {
	
	@InjectMocks
	EmployeesService empService;
	
	@Mock
	EmployeessDao empd;
	
	@Test
	public void deleteByIdTest() throws EmployeessIdNotFoundException {
		
		Employeess emps=new Employeess();
		emps.setEmpId(1);
		emps.setEmp_name("sadeesh");
		emps.setBirthdate(LocalDate.of(2002,10,1));
		emps.setEmailId("emp@gmail.com");
		emps.setPassword("sadee");
		emps.setMobile_no("9876543210");
		
		when(empd.existsById(emps.getEmpId())).thenReturn(true);
    	Mockito.doNothing().when(empd).deleteById(emps.getEmpId());
    	assertEquals("Deleted Successfully for id:"+emps.getEmpId(),empService.deleteById(emps.getEmpId()));
	}

}

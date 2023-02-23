package com.cvm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.CertificationDao;
import com.cvm.dao.VitalsAtVaccinationDao;
import com.cvm.entities.Certification;
import com.cvm.entities.VitalsAtVaccination;
import com.cvm.services.MedicalStaffsService;

@SpringBootTest
public class MedicalStaffsServiceTest {
	
	@InjectMocks
	MedicalStaffsService msService;
	@Mock
	VitalsAtVaccinationDao vav;
	
	@Test
	public void insertVitalsTest() {
		
		VitalsAtVaccination vital=new VitalsAtVaccination();
		vital.setVitalId(1);
		vital.setTemperature(98.5f);
		vital.setBloodPressure(89);
		vital.setSaturation(128);
		vital.setVitalTime("10am");
		
		when(vav.save(vital)).thenReturn(vital);
		String result = msService.insertVitals(vital);
		assertEquals("Added Successfully with vitalId:" +vital.getVitalId(), result);
	}
	
	@Mock
	CertificationDao cdd;
	
	@Test 
	public void inserCerrtificateTest() {
		Certification cd=new Certification();
		cd.setCertificateId(0);
		
		when(cdd.save(cd)).thenReturn(cd);
		String result = msService.insertCertificate(cd);
		assertEquals("Added Successfully with certificateId:"+cd.getCertificateId(), result);
	}

}

package com.cvm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.CertificationDao;
import com.cvm.entities.Certification;
import com.cvm.exceptions.CertificatesIdNotFoundException;
import com.cvm.services.CertificationService;

@SpringBootTest
public class CertificationServiceTest {

	@InjectMocks
	CertificationService cs;
	@Mock
	CertificationDao cd;
	//@Test
//	public void  insertCertificateTest() {
//		Certification certification=new Certification();
//		certification.setCertificateId(1);
//		
//		when(cd.save(certification)).thenReturn(certification);
//		String result = cs.insertCertificate(certification);
//		assertEquals("Added Successfully with certificateId:"+certification.getCertificateId(), result);
//	}
	
	@Test
	public void findBycertificateIdTest() throws CertificatesIdNotFoundException {
		Certification certification=new Certification();
		certification.setCertificateId(1);
		Optional<Certification> opm = Optional.of(certification);

		when(cd.findById(certification.getCertificateId())).thenReturn(opm);

		Certification certificationObj = cs.findBycertificateId(1);
		assertEquals(1, certificationObj.getCertificateId());
	}
}

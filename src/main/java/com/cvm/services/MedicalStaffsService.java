package com.cvm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvm.dao.CertificationDao;
import com.cvm.dao.VitalsAtVaccinationDao;
import com.cvm.entities.Certification;
import com.cvm.entities.VitalsAtVaccination;

@Service("msservice")
public class MedicalStaffsService {
	
	@Autowired
	VitalsAtVaccinationDao vdd;
	
	public String insertVitals(VitalsAtVaccination vitals) {
		VitalsAtVaccination dbVital = vdd.save(vitals);
		return "Added Successfully with vitalId:" + dbVital.getVitalId();
	}
	
	@Autowired
	CertificationDao cdd;
	
	public String insertCertificate(Certification certificates) {
		Certification dbcertificate = cdd.save(certificates);
		return "Added Successfully with certificateId:" + dbcertificate.getCertificateId();
	}


}

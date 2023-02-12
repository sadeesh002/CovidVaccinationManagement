package com.cvm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cvm.dao.CertificationDao;
import com.cvm.entities.Certification;
import com.cvm.exceptions.CertificatesIdNotFoundException;
import com.cvm.exceptions.NoCertificatesFoundException;


@Repository("cs")
public class CertificationService {

	@Autowired
	CertificationDao cd;

//	public String insertCertificate(Certification certificates) {
//		Certification dbcertificate = cd.save(certificates);
//		return "Added Successfully with certificateId:" + dbcertificate.getCertificateId();
//	}


	public Certification findBycertificateId(long certificateId) throws CertificatesIdNotFoundException {
		Optional<Certification> op = cd.findById(certificateId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new CertificatesIdNotFoundException("Certificate Not Found For certificateId:" + certificateId);
		}
	}
	
//	public List<Certification> findByCertificateEmpId(long empId) throws CertificatesIdNotFoundException {
//		List<Certification> op = cd.findByempId(empId);
//		if (op.isEmpty()) {
//
//			throw new CertificatesIdNotFoundException("Certificate Not Found For employeeId:" + empId);
//		} 
//		else {
//			return op;
//		}
//	}

}

package com.cvm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cvm.dao.VitalsAtVaccinationDao;
import com.cvm.entities.VitalsAtVaccination;
import com.cvm.exceptions.NoVitalsFoundException;
import com.cvm.exceptions.VitalIdNotFoundException;

@Service("vs")
public class VitalsAtVaccinationService {

	@Autowired
	VitalsAtVaccinationDao vd;

//	public String insertVitals(VitalsAtVaccination vitals) {
//		VitalsAtVaccination dbVital = vd.save(vitals);
//		return "Added Successfully with vitalId:" + dbVital.getVital_id();
//	}

	public List<VitalsAtVaccination> findAll() throws NoVitalsFoundException {
		List<VitalsAtVaccination> list = vd.findAll();
		if (list.isEmpty()) {
			throw new NoVitalsFoundException("No Vitals found");

		}
		return list;
	}

//	public VitalsAtVaccination findByVitalId(long vitalId) throws VitalIdNotFoundException {
//		Optional<VitalsAtVaccination> op = vd.findById(vitalId);
//		if (op.isPresent()) {
//			return op.get();
//		} else {
//			throw new VitalIdNotFoundException("Vital Not Found For vitalId:" + vitalId);
//		}
//	}

	public String updateVital(long vitalId, VitalsAtVaccination vitals) throws VitalIdNotFoundException {
		if (vitalId == vitals.getVital_id()) {
			VitalsAtVaccination upVital = vd.save(vitals);
			return "Updated Successfully for vitalId:" + upVital.getVital_id();
		}

		throw new VitalIdNotFoundException("Vital Not Found For vitalId:" + vitalId);
	}

	public String deleteById(long vitalId) throws VitalIdNotFoundException {
		if (vd.existsById(vitalId)) {
			vd.deleteById(vitalId);
			return "Deleted Successfully for vitalId:" + vitalId;
		}
		throw new VitalIdNotFoundException("Vital Not Found For vitalId:" + vitalId);
	}
	
//	public VitalsAtVaccination findByVitalId(long vitalId) throws VitalIdNotFoundException {
//		Optional<VitalsAtVaccination> op = vd.findById(vitalId);
//		if (op.isPresent()) {
//			return op.get();
//		} else {
//			throw new VitalIdNotFoundException("Vital Not Found For vitalId:" + vitalId);
//		}
//	}

//	public List<VitalsAtVaccination> findByVitalsId(long empId) throws VitalIdNotFoundException  {
//		 List<VitalsAtVaccination> op = vd.findByempId(empId);
//		if (op.isEmpty()) {
//			//return ResponseEntity.notFound().build
//			throw new VitalIdNotFoundException("Vital Not Found For employeeId:" + empId);
//		} else {
//			return op;
//		}
//	}

}

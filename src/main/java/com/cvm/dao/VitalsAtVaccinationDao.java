package com.cvm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cvm.entities.VitalsAtVaccination;

@Repository("vd")
public interface VitalsAtVaccinationDao extends JpaRepository<VitalsAtVaccination, Long>{

	@Query("select u from VitalsAtVaccination u join u.employeess a where a.empId=:empId")
	List<VitalsAtVaccination>findByempId(@Param("empId")Long empId );
	
	

}

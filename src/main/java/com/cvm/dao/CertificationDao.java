package com.cvm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cvm.entities.Certification;


@Repository("cd")
public interface CertificationDao extends JpaRepository<Certification, Long>{
	
	@Query("select u from Certification u join u.employeess a where a.empId=:empId")
	List<Certification>findByempId(@Param("empId")Long empId );

}

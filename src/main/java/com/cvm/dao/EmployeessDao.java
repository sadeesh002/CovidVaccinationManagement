package com.cvm.dao;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cvm.entities.Employeess;


@Repository("ed")
public interface EmployeessDao extends JpaRepository<Employeess,Long> {


	//Optional<Employeess> findByEmp_name(String eName);
	
	@Query("select e from Employeess e where e.emailId =:emailId and e.password =:pwd")
	 Optional<Employeess> login(@Param("emailId") String emailId,@Param("pwd") String password);
	
	
	Optional<Employeess> findByEmailId(String emailId);
     Optional<Employeess> findById(long empId);

    
}

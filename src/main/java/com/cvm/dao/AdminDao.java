package com.cvm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cvm.entities.Admin;


@Repository("ad")
public interface AdminDao extends JpaRepository<Admin,Long> {
	
	@Query("select e from Admin e where e.emailId =:emailId and e.password =:pwd")
	 Optional<Admin> login(@Param("emailId") String emailId,@Param("pwd") String password);
	
	
	Optional<Admin> findByEmailId(String emailId);
    Optional<Admin> findById(long adminId);

}

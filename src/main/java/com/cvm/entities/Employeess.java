package com.cvm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employeess {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empId;
	@NotEmpty
	@NotBlank
	private String emp_name;
	//@Pattern(regexp = "([A-Za-z]+[1-9]+)",message = "Invald Password")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="Invalid Email")
	private String emailId;
	private String password;
	@DateTimeFormat
	private LocalDate birthdate;
	@Size(min = 10,message = "Enter valid Mobile Number")
	private String mobile_no;
	
	
	@ManyToMany
	List<Slot> slot;
	
	@OneToMany(mappedBy = "employeess",cascade = CascadeType.ALL)
	@JsonIgnore
	List<VitalsAtVaccination> vitals=new ArrayList<>();
	
	@OneToMany(mappedBy = "employeess",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Certification> certificates=new ArrayList<>();
	
	
}

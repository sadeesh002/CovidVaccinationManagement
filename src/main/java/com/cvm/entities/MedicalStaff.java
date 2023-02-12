package com.cvm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStaff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long staffId;
	@NotEmpty
	@NotBlank
	private String staff_Name;
	@NotEmpty
	@NotBlank
	private String associated_with;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="Invalid Email")
	private String emailId;
	//@Pattern(regexp = "([A-Za-z]+[1-9]+)",message = "Invald Password")
	private String password;
	@NotBlank
	@NotEmpty
	private String location;
	@Size(min =10, message = "Enter Valid Mobile Number")
	private String mobile_no;
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
	@JsonIgnore
	List<VitalsAtVaccination> vitals=new ArrayList<>();

	

		 

}

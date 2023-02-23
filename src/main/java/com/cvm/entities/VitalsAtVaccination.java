package com.cvm.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VitalsAtVaccination {
	@Id
	@GeneratedValue
	private long vitalId;
	@Min(value = 97)
	@Max(value = 105)
	private float temperature;
	@Min(value = 75)
	@Max(value=100)
	private float saturation;
	@Min(value = 90)
	@Max(value = 180)
	private float bloodPressure;
	private String vitalTime;
	
	@ManyToOne
	private MedicalStaff staff;
	
	@ManyToOne
	private Slot slot;
	
	@ManyToOne
	private Employeess employeess;

}

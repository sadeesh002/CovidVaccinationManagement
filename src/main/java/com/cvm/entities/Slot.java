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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Slot {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long slot_id;
    @DateTimeFormat
	private LocalDate date;
    @NotNull
    @NotBlank(message = "Enter valid Location")
	private String slotLocation;
    @Min(value = 1)@Max(value = 2,message = "Enter valid Dose No")
    private int doseNo;
    @Min(value =10)
    @Max(value = 100)
	private int current_availabe_slot;
    @Min(value =0)
    @Max(value = 100)
	private int balance_availabe_slot;
	
	
	
	@ManyToMany(mappedBy ="slot")
	@JsonIgnore
	List<Employeess> employeess;
	
	
	@OneToMany(mappedBy = "slot",cascade = CascadeType.ALL)
	@JsonIgnore
    List<VitalsAtVaccination> vitals=new ArrayList<>();
	
	@ManyToOne
	private Admin admin;
		
}

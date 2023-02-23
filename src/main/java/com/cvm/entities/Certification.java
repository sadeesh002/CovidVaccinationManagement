package com.cvm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Certification {
	@Id
	@GeneratedValue
	private long certificateId;
	
	@ManyToOne
	private Employeess employeess;

}

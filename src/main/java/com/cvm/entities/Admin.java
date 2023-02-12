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
import javax.validation.constraints.Pattern;



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
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
     private long adminId;
      @NotEmpty
	// @Pattern(regexp = "([A-Za-z]+[1-9]+)",message = "Invald Password")
    
	 @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="Invalid Email")
     private String emailId;
     private String password;
     @NotEmpty
     private String location;
    
     @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
     @JsonIgnore
     List<Slot> slot=new  ArrayList<>();
    
}

package com.everis.bootcamp.ejecicio01maven.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long class_id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    private String class_code;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @NotNull(message = "El apellido no puede ser nulo")
    private String class_name;

    @NotNull(message = "La fecha no puede ser nulo")
    @Past(message = "La fecha debe ser pasada")
    @Temporal(TemporalType.DATE)
    private Date date_start;
    
    @NotNull(message = "La fecha no puede ser nulo")
    @Past(message = "La fecha debe ser pasada")
    @Temporal(TemporalType.DATE)
    private Date date_end;


    @JsonIgnore
    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassStudent> class_student = new ArrayList<ClassStudent>();


	public Long getClass_id() {
		return class_id;
	}


	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}


	public String getClass_code() {
		return class_code;
	}


	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public Date getDate_start() {
		return date_start;
	}


	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}


	public Date getDate_end() {
		return date_end;
	}


	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}


	public List<ClassStudent> getMatriculates() {
		return class_student;
	}


	public void setMatriculates(List<ClassStudent> class_student) {
		this.class_student = class_student;
	}

    

}

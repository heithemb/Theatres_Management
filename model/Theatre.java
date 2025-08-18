package com.example.demo.model;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "Theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long theatre_id;
	@NotNull(message = "Capacity is required")
	private Integer capaciter;
	private String address;
	@NotBlank(message = "Name is required")
	private String nom;
	
	public Theatre() {
		super();
		
	}
	public Theatre(  Integer capaciter, String address, String nom) {
		super();
		
		this.capaciter = capaciter;
		this.address = address;
		this.nom = nom;
	}
	public long getId() {
		return theatre_id;
	}
	public void setId(long theatre_id) {
		this.theatre_id = theatre_id;
	}
	public Integer getCapaciter() {
		return capaciter;
	}
	public void setCapaciter(Integer capaciter) {
		this.capaciter = capaciter;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}

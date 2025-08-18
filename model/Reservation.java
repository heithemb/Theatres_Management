package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.*;
@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Client Name is required")
	private String client;
	@NotNull(message = "Number of Places is required")
	private Integer nbPlace;
	@ManyToOne
    @JoinColumn(name = "spectacle_id", nullable = false)
	private Spectacle spectacle;
	private Double total;
	public Reservation() {
		super();
	}
	public Reservation(String client, int nbPlace, Spectacle spectacle, double total) {
		super();
		this.client = client;
		this.nbPlace = nbPlace;
		this.spectacle = spectacle;
		this.total = total;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Spectacle getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}

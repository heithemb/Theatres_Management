package com.example.demo.model;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Spectacle")
public class Spectacle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatre;
	@NotBlank(message = "Name is required")
	private String nom;
	@NotNull(message = "Temps is required")
	private Date temps;
	@NotBlank(message = "Createur is required")
	private String createur;
	@ElementCollection
	@CollectionTable(name = "spectacle_acteurs", joinColumns = @JoinColumn(name = "spectacle_id"))
	@Column(name = "acteur")
	private List<String> acteurs;

	@ElementCollection
	@CollectionTable(name = "spectacle_personnages", joinColumns = @JoinColumn(name = "spectacle_id"))
	@Column(name = "personnage")
	private List<String> personnages;
	@NotNull(message = "Prix is required")
	private Double prix;
	
	public Spectacle() {
		super();
		
	}
	public Spectacle( String nom,Theatre theatre, Date temps, String createur,List<String> personnages, double prix,List<String>acteurs) {
		super();
		this.nom = nom;
		this.temps = temps;
		this.theatre=theatre;
		this.createur = createur;
		this.personnages = personnages;
		this.prix = prix;
		this.acteurs=acteurs;
	}
	public List<String> getActeurs() {
		return acteurs;
	}
	public void setActeurs(List<String> acteurs) {
		this.acteurs = acteurs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getTemps() {
		return temps;
	}
	public void setTemps(Date temps) {
		this.temps = temps;
	}
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	public List<String> getPersonnages() {
		return personnages;
	}
	public void setPersonnages(List<String> personnages) {
		this.personnages = personnages;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
}

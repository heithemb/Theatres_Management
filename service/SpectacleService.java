package com.example.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Spectacle;
import com.example.demo.repository.SpectacleRepository;
import com.example.demo.repository.TheatreRepository;

@Service
public class SpectacleService {
	private final SpectacleRepository specrepo;
	final TheatreRepository t ;
	@Autowired
	public SpectacleService(SpectacleRepository specrepo,TheatreRepository t) {
		super();
		this.specrepo = specrepo;
		this.t=t;
	}
	public List<Spectacle> getAllSpectacle() {
		return specrepo.findAll();
	}
	public Spectacle getById(long id) {
		return specrepo.findById(id).get();
	}
	public List<Spectacle> getByDate(LocalDate d){
		return specrepo.findSpectaclesByDate(d);
	}
	public List<Spectacle> getByCreator(String c){
		return specrepo.findSpectaclesByCreator(c);
	}
	public List<Spectacle> getByIdTheatre(Long idT){
		if(t.findById(idT).isEmpty()) {
		return null;
		}
		return specrepo.findByIdTheatre(idT);
	}
	public Spectacle Create(Spectacle s){
		return specrepo.save(s);
	}
	public Spectacle Update(Spectacle s) {
		Spectacle s1=specrepo.findById(s.getId()).get();
		s1.setActeurs(s.getActeurs());
		s1.setCreateur(s.getCreateur());
		s1.setNom(s.getNom());
		s1.setPersonnages(s.getPersonnages());
		s1.setPrix(s.getPrix());
		s1.setTemps(s.getTemps());
		
		return specrepo.save(s1);
	}
	public List <Spectacle> Delete(Long id){
		specrepo.delete(specrepo.findById(id).get());
		return specrepo.findAll();
	}
	public List<Spectacle> getByName(String name) {
		return specrepo.findByName(name);
	}
	
}

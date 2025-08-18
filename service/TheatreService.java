package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Theatre;
import com.example.demo.repository.TheatreRepository;

@Service
public class TheatreService {
	private final TheatreRepository theatrerepo;
	@Autowired
	public TheatreService(TheatreRepository theatrerepo) {
		super();
		this.theatrerepo = theatrerepo;
	}
	public List<Theatre> getAllTheatre(){
		return theatrerepo.findAll();
	}
	public Theatre getId(Long id){
		return theatrerepo.findById(id).get();
	}
	public List<Theatre> getByName(String name){
		return theatrerepo.findByName(name);
	}
	public List<Theatre> getByAddress(String address){
		return theatrerepo.findByAddress(address);
	}
	public Theatre Create(Theatre t){
		
		return theatrerepo.save(t);
	}
	public Theatre Update(Theatre t){
		Theatre t1=theatrerepo.findById(t.getId()).get();
		t1.setAddress(t.getAddress());
		t1.setCapaciter(t.getCapaciter());
		t1.setNom(t.getNom());
		
		return theatrerepo.save(t1);
	}
	public void DeleteById(long Id){
		theatrerepo.delete(theatrerepo.findById(Id).get());
		
	}
	public void DeleteByNameAndAddress(String name,String address){
		//theatrerepo.deleteNameAndAddress(name,address);
		List<Theatre> l=theatrerepo.findByNameAndAddress(name,address);
		for (Theatre s:l) {
			theatrerepo.delete(s);
		}
	}
	
}

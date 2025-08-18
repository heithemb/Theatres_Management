package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.SpectacleRepository;

@Service
public class ReservationService {
	private final SpectacleRepository specrepo;
	private final ReservationRepository reservationrepo;
	@Autowired
	public ReservationService(ReservationRepository reservationrepo,SpectacleRepository specrepo) {
		super();
		this.reservationrepo = reservationrepo;
		this.specrepo = specrepo;
	}
	public Reservation getReservationById(Long id){
		return reservationrepo.findById(id).get();
	}
	public List<Reservation> getByClient(String Client){
		return reservationrepo.findByClient(Client);
	}
	public List<Reservation> getBySpectacle(Long idS){
		if(specrepo.existsById(idS)) {
			return reservationrepo.findBySpectacle(idS);
		}
		return null;
	}
	public Reservation Create(Reservation r){
		List<Reservation> p=reservationrepo.findAll();
		int tp=0;
		for (Reservation r1 : p) {
			tp+=r1.getNbPlace();
		}
		if (tp+r.getNbPlace()<=r.getSpectacle().getTheatre().getCapaciter()) {
			return reservationrepo.save(r);
		}
		return null;
	}
	public Reservation Update(Reservation r){
		Reservation r1=reservationrepo.findById(r.getId()).get();
		List<Reservation> p=reservationrepo.findAll();
		int tp=0;
		for (Reservation r2 : p) {
			if(r2.getId()!=r1.getId()) tp+=r2.getNbPlace();
		}
		if (tp+r.getNbPlace()<=r.getSpectacle().getTheatre().getCapaciter()) {
			r1.setClient(r.getClient());
			r1.setNbPlace(r.getNbPlace());
			r1.setSpectacle(r.getSpectacle());
			r1.setTotal(r.getTotal());
			return reservationrepo.save(r1);
		}
		return null;
	}
	public void Delete(Long id,String client) {
		reservationrepo.deleteByIdAndClient(id,client);
	}
	
	
}

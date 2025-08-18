package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Reservation;

import com.example.demo.service.ReservationService;

import jakarta.validation.Valid;


@Validated
@RestController
@RequestMapping(path = "RestApi/reservation")
public class ReservationController {
	private final ReservationService rs;
	@Autowired
	public  ReservationController(ReservationService rs) {
		super();
		this.rs=rs;
	}
	@GetMapping()
	public ResponseEntity getReservationById(@RequestParam("id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(rs.getReservationById(id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/client")
	public ResponseEntity getReservationByClient(@RequestParam("client") String name){
		try {
			List<Reservation> l=rs.getByClient(name);
			if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);
			}else {
				return ResponseEntity.status(202).body("No Reservation for the client: "+name);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/spectacle")
	public ResponseEntity getReservationByIdSpectacle(@RequestParam("idspectacle") Long ids){
		try {
			List<Reservation> l=rs.getBySpectacle(ids);
			if (l==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id "+ids+" does not exist");
			}else if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);}
			else {return ResponseEntity.status(202).body("No reservation");}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@DeleteMapping()
	public ResponseEntity Delete(@RequestParam("id") Long id,@RequestParam("Client") String Client){
		try {
			rs.Delete(id,Client);
			return ResponseEntity.status(204).body(null);
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PostMapping()
	public ResponseEntity Create(@Valid @RequestBody Reservation r) {
		try {
			r.setTotal(r.getSpectacle().getPrix()*r.getNbPlace());
			r=rs.Create(r);
			if(r!=null) {
			return ResponseEntity.status(201).body(r);
			}else return ResponseEntity.status(409).body("Impossible pas de place ");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity Update(@Valid @RequestBody Reservation r,@PathVariable Long id) {
		try {
			r.setId(id);
			r.setTotal(r.getSpectacle().getPrix()*r.getNbPlace());
			r=rs.Update(r);
			if(r!=null) {
			return ResponseEntity.status(200).body(r);
			}else return ResponseEntity.status(404).body("reservation not found ");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}

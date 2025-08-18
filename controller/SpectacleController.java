package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Spectacle;
import com.example.demo.service.SpectacleService;

import jakarta.validation.Valid;
@Validated
@RestController
@RequestMapping(path = "RestApi/spectacle")
public class SpectacleController {
	private final SpectacleService ss;
	@Autowired
	public  SpectacleController(SpectacleService ss) {
		super();
		this.ss=ss;
	}
	@GetMapping()
	public ResponseEntity getAllSpectacle(){
		try {
			List<Spectacle> l=ss.getAllSpectacle();
			if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);
			}else {
				return ResponseEntity.status(202).body("No Spectacle");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity getSpectacleById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ss.getById(id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/name/{name}")
	public ResponseEntity getSpectacleByName(@PathVariable String name){
		try {
			List<Spectacle> l=ss.getByName(name);
			if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);
			}else {
				return ResponseEntity.status(202).body("No Spectacle with the name: "+name);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/creator/{creator}")
	public ResponseEntity getSpectacleByCreator(@PathVariable String creator){
		try {
			List<Spectacle> l=ss.getByCreator(creator);
			if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);
		}else {
			return ResponseEntity.status(202).body("No Spectacle with the Creator: "+creator);
		}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/date/{date}")
	public ResponseEntity getSpectacleByDate(@PathVariable LocalDate date){
		try {
			List<Spectacle> l=ss.getByDate(date);
			if (l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(l);
			}else {
				return ResponseEntity.status(202).body("No Spectacle In That Date: "+date);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping("/theatre/{idT}")
	public ResponseEntity getSpectacleByidTheatre(@PathVariable Long idT){
		try {
			List<Spectacle> l=ss.getByIdTheatre(idT);
			if (l==null) {
				return ResponseEntity.status(404).body("No Theatre with the id  "+idT);
		}else if(l.size()!=0){
			
			return ResponseEntity.status(HttpStatus.OK).body(l);
		}else {
			return ResponseEntity.status(202).body("No Spectacle Currently ");
		}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@PostMapping()
	public ResponseEntity Create(@Valid @RequestBody Spectacle s) {
		try {
			
			return ResponseEntity.status(201).body(ss.Create(s));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity Update(@Valid @RequestBody Spectacle s,@PathVariable Long id) {
		try {
			s.setId(id);
			return ResponseEntity.status(200).body(ss.Update(s));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity Delete(@PathVariable Long id) {
		try {
			ss.Delete(id);
			return ResponseEntity.status(204).build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
}

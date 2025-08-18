package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Theatre;
import com.example.demo.service.TheatreService;

import jakarta.validation.Valid;


@Validated
@RestController
@RequestMapping(path = "RestApi/theatre")
public class TheatreController {
	private final TheatreService ts;
	@Autowired
	public TheatreController(TheatreService ts) {
		super();
		this.ts = ts;
	}
	@GetMapping()
	public ResponseEntity getTheatres(){
		try {
			List<Theatre>l=ts.getAllTheatre();
			if ( l.size()!=0) {
		return ResponseEntity.status(HttpStatus.OK).body(l);
			}else {
				return ResponseEntity.status(202).body("No Theatre Currently");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@GetMapping(value="/name/{name}")
	public ResponseEntity getTheatreByName(@PathVariable String name) {
		try {
			List<Theatre>l=ts.getByName(name);
			if ( l.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(ts.getByName(name));
			}else {
				return ResponseEntity.status(202).body("No Theatre with the Name: "+name);
			}
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
	}
	@GetMapping(value="/address/{address}")
	public ResponseEntity getTheatreByAddress(@PathVariable String address) {
		try {
			List<Theatre>l=ts.getByAddress(address);
			if ( l.size()!=0) {
			return ResponseEntity.status(200).body(l);
			}else {
				return ResponseEntity.status(202).body("No Theatre with the Address: "+address);
			}
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
	}
	@PostMapping()
	public ResponseEntity Create(@Valid @RequestBody Theatre t) {
		try {
		return ResponseEntity.status(201).body(ts.Create(t));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity DeleteById(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		
	}
	@DeleteMapping("/{name}/{address}")
	public ResponseEntity DeleteById(@PathVariable String name,@PathVariable String address) {
		try {
			return ResponseEntity.status(204).build();
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity Update(@Valid @RequestBody Theatre t,@PathVariable long id ) {
		try {
			t.setId(id);
		return ResponseEntity.status(200).body(ts.Update(t));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
}

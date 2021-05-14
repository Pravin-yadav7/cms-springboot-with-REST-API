package com.divergentsl.cmsspringboot.restcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsspringboot.entity.Doctor;
import com.divergentsl.cmsspringboot.entity.Patient;
import com.divergentsl.cmsspringboot.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping(path = "cms/doctor", produces = "application/json")
@CrossOrigin(origins = "*")
public class DoctorRestController {
	
	@Autowired
	DoctorService doctorService;

	public DoctorRestController() {
		super();
	}
	
	@GetMapping
	protected ResponseEntity<List<Doctor>> doctorList() {
		
		List<Doctor> allDoctor = doctorService.findAll();
		return new ResponseEntity<List<Doctor>>(allDoctor, HttpStatus.OK);	
	}
	
	@GetMapping("/{doctorId}")
	private ResponseEntity<Doctor> find(@PathVariable int doctorId) {
		Doctor doctor = doctorService.find(doctorId);

		if (doctor != null) {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}
		//return new ResponseEntity<Patient>(null, HttpStatus.NOT_FOUND);
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Doctor doctor) {
		doctorService.insert(doctor);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
	}
	
	@DeleteMapping("/{doctorId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int doctorId) {
		doctorService.delete(doctorId);
	}
}

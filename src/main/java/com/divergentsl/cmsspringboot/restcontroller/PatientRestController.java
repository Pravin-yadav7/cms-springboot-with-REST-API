package com.divergentsl.cmsspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.divergentsl.cmsspringboot.entity.Patient;
import com.divergentsl.cmsspringboot.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping(path = "cms/patient", produces = "application/json")
@CrossOrigin(origins = "*")
public class PatientRestController {

	@Autowired
	private PatientService patientService;

	public PatientRestController() {
		super();
	}

	@GetMapping("/")
	protected ResponseEntity<List<Patient>> patientList() {
		
		List<Patient> allPatient = patientService.findAll();
		return new ResponseEntity<List<Patient>>(allPatient, HttpStatus.OK);	
	}
	
	@GetMapping("/{patientId}")
	private ResponseEntity<Patient> find(@PathVariable int patientId) {
		Patient patient = patientService.find(patientId);

		if (patient != null) {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}
		//return new ResponseEntity<Patient>(null, HttpStatus.NOT_FOUND);
		return null;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Patient patient) {
		patientService.insert(patient);
	}
	
	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Patient patient) {
		patientService.updatPatient(patient);
	}
	
	@DeleteMapping("/{patientId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int patientId) {
		patientService.delete(patientId);
	}

}

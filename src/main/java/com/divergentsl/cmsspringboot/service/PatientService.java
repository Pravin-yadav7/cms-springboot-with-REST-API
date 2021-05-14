package com.divergentsl.cmsspringboot.service;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Patient;

public interface PatientService {
	
	public void insert(Patient patient);

	public List<Patient>findAll();

	public Patient find(int patientId);

	public void delete(int patientId);
	
	public void updatPatient(Patient patient);

}

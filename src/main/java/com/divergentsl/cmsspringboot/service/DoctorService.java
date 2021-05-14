package com.divergentsl.cmsspringboot.service;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Doctor;
import com.divergentsl.cmsspringboot.entity.Patient;

public interface DoctorService {
	
	public void insert(Doctor doctor);

	public List<Doctor>findAll();

	public Doctor find(int doctorId);

	public void delete(int doctorId);
	
	public void updateDoctor(Doctor doctor);


}

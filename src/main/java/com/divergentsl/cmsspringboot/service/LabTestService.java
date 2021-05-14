package com.divergentsl.cmsspringboot.service;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.LabTest;
import com.divergentsl.cmsspringboot.entity.Patient;

public interface LabTestService {
	
	public void insert(LabTest labTest);

	public List<LabTest>findAll();

	public LabTest find(int testId);

	public void delete(int testId);
	
	public void updatLabTest(LabTest labTest);
	

}

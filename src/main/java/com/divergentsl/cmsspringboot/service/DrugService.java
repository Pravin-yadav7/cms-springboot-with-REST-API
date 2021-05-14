package com.divergentsl.cmsspringboot.service;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Drug;
import com.divergentsl.cmsspringboot.entity.Patient;

public interface DrugService {
	
	public void insert(Drug drug);

	public List<Drug>findAll();

	public Drug find(int drugId);

	public void delete(int drugId);
	
	public void updateDrug(Drug drug);

}

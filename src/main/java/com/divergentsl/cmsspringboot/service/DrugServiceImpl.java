package com.divergentsl.cmsspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.BaseDao;
import com.divergentsl.cmsspringboot.entity.Drug;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	BaseDao<Drug> drugDao;
	
	@Transactional
	@Override
	public void insert(Drug drug) {
		
		drugDao.insert(drug);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Drug> findAll() {

		return drugDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Drug find(int drugId) {
		
		return drugDao.find(drugId);
	}

	@Transactional
	@Override
	public void delete(int drugId) {
		
		drugDao.remove(drugId);
		
	}

	@Override
	public void updateDrug(Drug drug) {
		
		drugDao.update(drug);
	}

}

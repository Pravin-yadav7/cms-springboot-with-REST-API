package com.divergentsl.cmsspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.BaseDao;
import com.divergentsl.cmsspringboot.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	BaseDao<Doctor> doctorDao;
	
	@Transactional
	@Override
	public void insert(Doctor doctor) {
		
		doctorDao.insert(doctor);	
	}

	@Transactional(readOnly = true)
	@Override
	public List<Doctor> findAll() {

		return doctorDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Doctor find(int doctorId) {
		
		return doctorDao.find(doctorId);
	}

	@Transactional
	@Override
	public void delete(int doctorId) {
		
		doctorDao.remove(doctorId);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		
		doctorDao.update(doctor);
	}

}

package com.divergentsl.cmsspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.AppointmentDao;
import com.divergentsl.cmsspringboot.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;
	
	@Transactional
	@Override
	public void makeAppointment(Appointment appointment) {
		
		appointmentDao.makeAppointment(appointment);
	}

}

package com.divergentsl.cmsspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cmsspringboot.dao.AdminDao;
import com.divergentsl.cmsspringboot.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	public boolean login(String username, String password) {

		//AdminDao adminDao = new AdminDaoImpl();

		Admin admin = adminDao.login(username);
		if (admin == null)
			return false;
		return username.equals(admin.getUsername()) && password.equals(admin.getPassword());
	}

}

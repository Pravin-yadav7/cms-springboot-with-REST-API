package com.divergentsl.cmsspringboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.divergentsl.cmsspringboot.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public Admin login(String username) {
		
		//EntityManager entityManager = EntityManagerUtility.getEntityManager();
		//entityManager.getTransaction().begin();
//		entityManager.persist(username);
		

		Admin admin = entityManager.find(Admin.class, username);
		
		//entityManager.getTransaction().commit();
		entityManager.close();
		return admin;
	}

}

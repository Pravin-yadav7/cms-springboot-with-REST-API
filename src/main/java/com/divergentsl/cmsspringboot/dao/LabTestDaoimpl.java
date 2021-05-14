package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.cmsspringboot.entity.LabTest;

@Repository
public class LabTestDaoimpl implements BaseDao<LabTest> {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void insert(LabTest labTest) {
		
		entityManager.persist(labTest);
		
	}

	@Override
	public LabTest find(int id) {
		
		LabTest labTest = entityManager.find(LabTest.class, id);
		entityManager.close();
		return labTest;
	}

	@Override
	public List<LabTest> findAll() {
		
		TypedQuery<LabTest> query = entityManager.createQuery("Select lb from LabTest lb", LabTest.class);
		List<LabTest> labTest = query.getResultList();
		entityManager.close();
		return labTest;
	}

	@Override
	public void remove(int id) {
		
		LabTest labTest = entityManager.find(LabTest.class, id);
		if (labTest != null) {

			entityManager.remove(labTest);
			entityManager.close();
		}
		
	}

	@Override
	public void update(LabTest labTest) {
		
		entityManager.merge(labTest);
		
	}

}

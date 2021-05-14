package com.divergentsl.cmsspringboot.restcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsspringboot.entity.Doctor;
import com.divergentsl.cmsspringboot.entity.LabTest;
import com.divergentsl.cmsspringboot.service.LabTestService;

import lombok.extern.slf4j.Slf4j;
@Slf4j

@RestController
@RequestMapping(path = "cms/labTest", produces = "application/json")
@CrossOrigin(origins = "*")
public class LabTestRestController {
	
	@Autowired
	LabTestService labTestService;

	public LabTestRestController() {
		super();
	}
	
	@GetMapping
	protected ResponseEntity<List<LabTest>> testList() {
		
		List<LabTest> allLabTest = labTestService.findAll();
		return new ResponseEntity<List<LabTest>>(allLabTest, HttpStatus.OK);	
	}
	
	@GetMapping("/{labTestId}")
	private ResponseEntity<LabTest> find(@PathVariable int labTestId) {
		LabTest labTest = labTestService.find(labTestId);

		if (labTest != null) {
			return new ResponseEntity<LabTest>(labTest, HttpStatus.OK);
		}
		//return new ResponseEntity<LabTest>(null, HttpStatus.NOT_FOUND);
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody LabTest labTest) {
		labTestService.insert(labTest);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody LabTest labTest) {
		labTestService.updatLabTest(labTest);
	}
	
	@DeleteMapping("/{labTestId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int labTestId) {
		labTestService.delete(labTestId);
	}

}

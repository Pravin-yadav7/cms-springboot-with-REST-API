package com.divergentsl.cmsspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.divergentsl.cmsspringboot.entity.Drug;
import com.divergentsl.cmsspringboot.service.DrugService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping(path = "cms/drug", produces = "application/json")
@CrossOrigin(origins = "*")
public class DrugRestController {

	@Autowired
	DrugService drugService;

	public DrugRestController() {
		super();
	}

	@GetMapping
	protected ResponseEntity<List<Drug>> drugList() {

		List<Drug> allDrug = drugService.findAll();
		return new ResponseEntity<List<Drug>>(allDrug, HttpStatus.OK);
	}

	@GetMapping("/{drugId}")
	private ResponseEntity<Drug> find(@PathVariable int drugId) {
		Drug drug = drugService.find(drugId);

		if (drug != null) {
			return new ResponseEntity<Drug>(drug, HttpStatus.OK);
		}
		// return new ResponseEntity<Drug>(null, HttpStatus.NOT_FOUND);
		return null;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Drug drug) {
		drugService.insert(drug);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Drug drug) {
		drugService.updateDrug(drug);
	}

	@DeleteMapping("/{drugId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int drugId) {
		drugService.delete(drugId);
	}

}

package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LeadDto;
import com.app.entities.Lead;
import com.app.repository.LeadRepository;
import com.app.service.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	LeadRepository leadRepo;
	
	//http://localhost:8080/api/leads
	@GetMapping
	public List getAllLead() {
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}
	
	//http://localhost:8080/api/leads/{id}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id")long id) {
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/leads
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads
	@PutMapping
	public void Update(@RequestBody LeadDto dto) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/{id}
	@GetMapping("/{id}")
	public Lead getById(@PathVariable("id")long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}

package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Lead;
import com.app.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	LeadRepository leadRepo;
	
	@Override
	public void saveOneLead(Lead lead) {

		leadRepo.save(lead);
	}

	@Override
	public List<Lead> findAll() {
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(long id) {

		leadRepo.deleteById(id);
	}

	@Override
	public Lead findById(long id) {
     Optional<Lead> findById = leadRepo.findById(id);
     Lead lead = findById.get();
		return lead;
	}

}

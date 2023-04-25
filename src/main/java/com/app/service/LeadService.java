package com.app.service;

import java.util.List;

import com.app.entities.Lead;

public interface LeadService {
public void saveOneLead(Lead lead);

public List<Lead> findAll();

public void deleteById(long id);

public Lead findById(long id);
}

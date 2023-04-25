package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.LeadDto;
import com.app.entities.Lead;
import com.app.service.LeadService;
import com.app.utils.EmailService;


@Controller
public class LeadController {

	@Autowired
	LeadService leadService;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("/create")
	public String viewLeadForm() {
		return"create_lead";
	}
	
	@RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute Lead lead) {
		leadService.saveOneLead(lead);
		emailService.sendEmail(lead.getEmail(), "Registration Update", "you have register sucessfully");
		return"create_lead";
	}
	
	@RequestMapping("/read")
	public String readLeadList(Model map) {
		List<Lead> leads=leadService.findAll();
		map.addAttribute("leads", leads);
		return"read_lead";
	}
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id")long id,Model map) {
		leadService.deleteById(id);
		List<Lead> leads=leadService.findAll();
		map.addAttribute("leads", leads);
		return"read_lead";
	}
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id")long id,Model map) {
		Lead lead = leadService.findById(id);
		map.addAttribute("lead", lead);
		return"update_lead";
	}
	
	@RequestMapping("/editLead")
	public String editLead(@ModelAttribute LeadDto dto,Model map) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadService.saveOneLead(lead);
		List<Lead> leads=leadService.findAll();
		map.addAttribute("leads", leads);
		return"read_lead";
	}
}

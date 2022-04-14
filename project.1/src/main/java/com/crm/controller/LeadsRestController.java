package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Leads;
import com.crm.service.LeadsService;

@RestController
@RequestMapping("/leads")
public class LeadsRestController {

	
	@Autowired
	public LeadsService leadsService;
	
	@GetMapping
	public List<Leads> getleads(){
	
		return leadsService.getleads();
		
	}
	
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Leads> getleads(@PathVariable("id") long id){
		
		try {
		Leads leads = leadsService.getleads(id);
		return new ResponseEntity<Leads>(leads, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);	
		}
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteLeads(@PathVariable("id") long id) {
	
		leadsService.deleteLeads(id);
	}
	
	@PostMapping
	public void saveLeads(@RequestBody Leads leads) {
		leadsService.saveLeads(leads);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Leads> updateLeads(@PathVariable("id") long id, @RequestBody Leads leads) {
		
		try {
		
		Leads existsLeads = leadsService.getleads(id);
		existsLeads.setEmail(leads.getEmail());
		existsLeads.setMobile(leads.getMobile());
		
		Leads update_leads  = leadsService.updateLeads(existsLeads);
		return new ResponseEntity<Leads>(update_leads, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}

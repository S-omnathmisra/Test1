package com.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.crm.entity.Leads;
import com.crm.repository.LeadsRepository;

@Component
@Service
public class LeadsService {
	
	@Autowired
	private LeadsRepository leadsRepo;
	
	public List<Leads> getleads(){
		
		return leadsRepo.findAll();
	}
	
	public Leads getleads(@PathVariable("id") long id){
		
		Optional<Leads> findById = leadsRepo.findById(id);
		Leads leads = findById.get();
		return leads;
	}
	
	public void deleteLeads(@PathVariable("id") long id) {
		leadsRepo.deleteById(id);
		
		
	}
	
	public void saveLeads(@RequestBody Leads leads) {
		
		leadsRepo.save(leads);
		
	}
	
	public Leads updateLeads(Leads leads) {
		leadsRepo.save(leads);
		return leads;
	}

}

package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.Leads;

public interface LeadsRepository extends JpaRepository<Leads, Long> {

	
}

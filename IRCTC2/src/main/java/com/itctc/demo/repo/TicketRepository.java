package com.itctc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itctc.demo.binding.Passenger;
import com.itctc.demo.binding.Ticket;
import com.itctc.demo.entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer>{
	
	TicketEntity findByTicketPnr(String pnr);

}

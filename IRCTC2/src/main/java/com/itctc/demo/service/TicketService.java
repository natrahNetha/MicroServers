package com.itctc.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itctc.demo.binding.Passenger;
import com.itctc.demo.binding.Ticket;

@Repository
public interface TicketService {
	
	Ticket bookTicket(Passenger passenger) throws Exception;
    Ticket getTicketByPnr(String ticketPnr);
    String updateTicket(Passenger passenger, Integer ticketId);
    String deleteTicket(Integer ticketId);
    List<Ticket> getAlltickets();
}

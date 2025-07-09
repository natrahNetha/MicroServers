package com.itctc.demo.controller;

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

import com.itctc.demo.binding.Passenger;
import com.itctc.demo.binding.Ticket;
import com.itctc.demo.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    
    private TicketService service;

    public TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@PostMapping("/bookTicket")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) throws Exception {
        Ticket ticket = service.bookTicket(passenger);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping("/getTicket/{pnr}")
    public ResponseEntity<Ticket> getTicket(@PathVariable String pnr) {
        Ticket ticket = service.getTicketByPnr(pnr);
        System.out.println(ticket+ " came 		" );
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PutMapping("/updateTicket/{ticketId}")
    public ResponseEntity<String> updateTicket(@RequestBody Passenger passenger, @PathVariable Integer ticketId) {
        String result = service.updateTicket(passenger, ticketId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTicket/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable Integer ticketId) {
        String result = service.deleteTicket(ticketId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> list = service.getAlltickets();
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}



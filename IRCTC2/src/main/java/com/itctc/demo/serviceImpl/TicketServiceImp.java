package com.itctc.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itctc.demo.binding.Passenger;
import com.itctc.demo.binding.Ticket;
import com.itctc.demo.entity.PassengerEntity;
import com.itctc.demo.entity.TicketEntity;
import com.itctc.demo.exception.InvalidPassengerException;
import com.itctc.demo.exception.TicketNotFoundException;
import com.itctc.demo.repo.PassengerRepository;
import com.itctc.demo.repo.TicketRepository;
import com.itctc.demo.service.TicketService;

@Service
public class TicketServiceImp implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Ticket bookTicket(Passenger passengerInfo) {
		if (passengerInfo == null) {
			throw new InvalidPassengerException("Passenger information cannot be null");
		}

		try {
			PassengerEntity pe = new PassengerEntity();
			BeanUtils.copyProperties(passengerInfo, pe);
			passengerRepository.save(pe);

			String pnr = "";
			for (int i = 0; i <= 8; i++) {
				pnr += (int) (Math.random() * 10);
			}

			TicketEntity tic = new TicketEntity();
			tic.setName(passengerInfo.getName());
			tic.setJourneryDate(passengerInfo.getJourneryDate());
			tic.setSource(passengerInfo.getSource());
			tic.setDestination(passengerInfo.getDestination());
			tic.setTicketPnr(pnr);
			tic.setTicketStatus("confirmed");
			tic.setTrainNum(passengerInfo.getTrainNum());

			TicketEntity save = ticketRepository.save(tic);

			Ticket ticket = new Ticket();
			BeanUtils.copyProperties(save, ticket);
			return ticket;

		} catch (Exception e) {
			throw new RuntimeException("Error while booking ticket: " + e.getMessage());
		}
	}

	@Override
	public Ticket getTicketByPnr(String pnr) {
		if (pnr == null || pnr.trim().isEmpty()) {
			throw new IllegalArgumentException("PNR must not be null or empty");
		}

		TicketEntity ticketEntity = ticketRepository.findByTicketPnr(pnr);

		if (ticketEntity == null) {
			throw new TicketNotFoundException("Ticket not found with PNR: " + pnr);
		}

		Ticket t = new Ticket();
		BeanUtils.copyProperties(ticketEntity, t);
		return t;
	}

	@Override
	public String updateTicket(Passenger passenger, Integer ticketid) {
		if (passenger == null) {
			throw new InvalidPassengerException("Passenger details cannot be null");
		}

		Optional<TicketEntity> optional = ticketRepository.findById(ticketid);

		if (!optional.isPresent()) {
			throw new TicketNotFoundException("Ticket not found with ID: " + ticketid);
		}

		try {
			TicketEntity existingTicket = optional.get();
			PassengerEntity pEntity = new PassengerEntity();
			BeanUtils.copyProperties(passenger, pEntity);

			existingTicket.setTrainNum(pEntity.getTrainNum());

			passengerRepository.save(pEntity);
			ticketRepository.save(existingTicket);

			return "Ticket Updated Successfully";
		} catch (Exception e) {
			throw new RuntimeException("Error while updating ticket: " + e.getMessage());
		}
	}

	@Override
	public String deleteTicket(Integer ticketId) {
		if (ticketId == null) {
			throw new IllegalArgumentException("Ticket ID must not be null");
		}

		Optional<TicketEntity> optional = ticketRepository.findById(ticketId);

		if (!optional.isPresent()) {
			throw new TicketNotFoundException("Ticket not found with ID: " + ticketId);
		}

		try {
			ticketRepository.deleteById(ticketId);
			return "Ticket deleted successfully";
		} catch (Exception e) {
			throw new RuntimeException("Error while deleting ticket: " + e.getMessage());
		}
	}

	@Override
	public List<Ticket> getAlltickets() {
		try {
			List<TicketEntity> all = ticketRepository.findAll();
			if (all.isEmpty()) {
				throw new TicketNotFoundException("No tickets found");
			}

			List<Ticket> tickets = new ArrayList<>();
			for (TicketEntity entity : all) {
				Ticket ticket = new Ticket();
				BeanUtils.copyProperties(entity, ticket);
				tickets.add(ticket);
			}

			return tickets;

		} catch (Exception e) {
			throw new RuntimeException("Error while fetching all tickets: " + e.getMessage());
		}
	}
}

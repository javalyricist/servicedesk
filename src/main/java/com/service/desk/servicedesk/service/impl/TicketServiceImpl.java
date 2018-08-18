package com.service.desk.servicedesk.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.service.desk.servicedesk.entity.TicketDO;
import com.service.desk.servicedesk.model.Ticket;
import com.service.desk.servicedesk.repository.TicketRepository;
import com.service.desk.servicedesk.service.TicketService;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketReository;

	@Transactional
	@Override
	public Ticket save(Ticket ticket) throws IllegalAccessException, InvocationTargetException {
		TicketDO ticketDO = new TicketDO();
		Ticket ticketInfo = new Ticket();
		ticket.setCreateDt(new Date());
		ticket.setUpdateDt(new Date());
		BeanUtils.copyProperties(ticketDO, ticket);
		TicketDO savedTicketDO=ticketReository.save(ticketDO);
		BeanUtils.copyProperties(ticketInfo, savedTicketDO);
		return ticketInfo;
	}

	@Transactional
	@Override
	public Ticket update(Ticket ticket) throws IllegalAccessException, InvocationTargetException {
		TicketDO ticketDO = new TicketDO();
		Ticket ticketInfo = new Ticket();
		BeanUtils.copyProperties(ticketDO, ticket);
		ticketReository.save(ticketDO);
		BeanUtils.copyProperties(ticketInfo, ticketDO);
		return ticketInfo;
	}

	@Override
	public Ticket findById(Long ticketId) throws IllegalAccessException, InvocationTargetException {
		Ticket ticketInfo = new Ticket();
		TicketDO ticketDO = ticketReository.findById(ticketId).get();
		BeanUtils.copyProperties(ticketInfo, ticketDO);
		return ticketInfo;
	}

	

	@Override
	public List<Ticket> findBySrcSysCode(String srcSysCd) throws IllegalAccessException, InvocationTargetException {
		List<TicketDO> ticketDos = ticketReository.findBySrcSystemCode(srcSysCd);
		List<Ticket> tickets = new ArrayList<>();
		for (TicketDO ticketDo : ticketDos) {
			Ticket ticketInfo = new Ticket();
			BeanUtils.copyProperties(ticketInfo, ticketDo);
			tickets.add(ticketInfo);
		}
		return tickets;
	}

	

}

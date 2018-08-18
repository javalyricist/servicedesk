package com.service.desk.servicedesk.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.desk.servicedesk.model.Ticket;

@Service
public interface TicketService {

	public Ticket save(Ticket ticket) throws IllegalAccessException, InvocationTargetException;

	public Ticket update(Ticket ticket) throws IllegalAccessException, InvocationTargetException;

	public Ticket findById(Long ticket) throws IllegalAccessException, InvocationTargetException;

	public List<Ticket> findBySrcSysCode(String srcSysCd) throws IllegalAccessException, InvocationTargetException;

}

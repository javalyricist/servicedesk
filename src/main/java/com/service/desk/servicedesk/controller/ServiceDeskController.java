package com.service.desk.servicedesk.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.desk.servicedesk.entity.UserDO;
import com.service.desk.servicedesk.exception.ServiceDeskError;
import com.service.desk.servicedesk.model.Ticket;
import com.service.desk.servicedesk.service.IServiceDesk;
import com.service.desk.servicedesk.service.TicketService;
import com.service.desk.servicedesk.service.UserAuthenticationService;
import com.service.desk.servicedesk.util.ServiceDeskConstant;
import com.service.desk.servicedesk.util.ServiceDeskUtil;

@RestController
public class ServiceDeskController {

	Logger logger = Logger.getLogger(ServiceDeskController.class);

	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@ResponseBody
	@RequestMapping(value = "/serviceDesk/saveTicket", method = RequestMethod.POST, produces = "application/json")
	public IServiceDesk saveTicket(@RequestBody Ticket ticket,
			@RequestHeader(value = "authorization", defaultValue = "NA") String authorizationHeader) {
		logger.debug(" Save Input -> " + ticket);
		Ticket ticketInfo = new Ticket();
		try {
			String[] decodedString = ServiceDeskUtil.decodeBase64(authorizationHeader).split(":");
			Boolean isAuthoriazation = userAuthenticationService
					.checkUserAvailable(new UserDO(decodedString[0], decodedString[1], null, null));
			if (authorizationHeader.equals("NA"))
				return new ServiceDeskError(HttpStatus.UNAUTHORIZED, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
						new Exception("Please provide credential"));
			if (!isAuthoriazation)
				return new ServiceDeskError(HttpStatus.UNAUTHORIZED, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
						new Exception(""));
			else {
				try {
					ticketInfo = ticketService.save(ticket);
				} catch (IllegalAccessException | InvocationTargetException e) {
					return new ServiceDeskError(HttpStatus.SERVICE_UNAVAILABLE,
							ServiceDeskConstant.LOGIN_UNAUTHORIZATION, e);
				}

				return ticketInfo;
			}
		} catch (IOException ex) {
			logger.debug(" exception  " + ex.getMessage());
			return new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
		}
	}

	@RequestMapping(value = "/serviceDesk/updateTicket", method = RequestMethod.POST, produces = "application/json")
	public IServiceDesk updateTicket(@RequestBody Ticket ticket,
			@RequestHeader(value = "authorization", defaultValue = "NA") String authorizationHeader) {
		logger.debug(" Update Input -> " + ticket);
		String[] decodedString;

		try {
			decodedString = ServiceDeskUtil.decodeBase64(authorizationHeader).split(":");
			Boolean isAuthoriazation = userAuthenticationService
					.checkUserAvailable(new UserDO(decodedString[0], decodedString[1], null, null));
			Ticket ticketInfo = new Ticket();
			if (!isAuthoriazation)
				return new ServiceDeskError(HttpStatus.UNAUTHORIZED, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
						new Exception(""));
			else {
				ticketInfo = ticketService.save(ticket);
				return ticketInfo;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return ticket;
	}
	@RequestMapping(value = "/serviceDesk/ticket/{ticketId}", method = RequestMethod.GET, produces = "application/json")
	public IServiceDesk findByTicketId(@PathVariable("ticketId") Long  ticketId,
			@RequestHeader(value = "authorization", defaultValue = "NA") String authorizationHeader) {
		logger.debug(" findById Input -> " + ticketId);
		String[] decodedString;
		try {
			decodedString = ServiceDeskUtil.decodeBase64(authorizationHeader).split(":");
			Boolean isAuthoriazation = userAuthenticationService
					.checkUserAvailable(new UserDO(decodedString[0], decodedString[1], null, null));
			
			if (!isAuthoriazation)
				return new ServiceDeskError(HttpStatus.UNAUTHORIZED, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
						new Exception(""));
			else {
				return  ticketService.findById(ticketId);
			}
		} catch (IOException ex) {
			return new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
					ex);
		} catch (IllegalAccessException ex) {
			return new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
					ex);
		} catch (InvocationTargetException ex) {
			return new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
					ex);
		}
	}
	@RequestMapping(value = "/serviceDesk/src/{srcSysCd}", method = RequestMethod.GET, produces = "application/json")
	public List<IServiceDesk> findBySrcSysId(@PathVariable("srcSysCd") String  srcSysCd,
			@RequestHeader(value = "authorization", defaultValue = "NA") String authorizationHeader) {
		logger.debug(" findById Input -> " + srcSysCd);
		String[] decodedString;
		List<IServiceDesk> serviceDeskResponse = new ArrayList<>();

		try {
			decodedString = ServiceDeskUtil.decodeBase64(authorizationHeader).split(":");
			Boolean isAuthoriazation = userAuthenticationService
					.checkUserAvailable(new UserDO(decodedString[0], decodedString[1], null, null));
			if (!isAuthoriazation) {
				serviceDeskResponse.add(new ServiceDeskError(HttpStatus.UNAUTHORIZED, ServiceDeskConstant.LOGIN_UNAUTHORIZATION,
						new Exception("")));
				return serviceDeskResponse;
			} else {
				serviceDeskResponse.addAll(ticketService.findBySrcSysCode(srcSysCd));
				return serviceDeskResponse;
			}
		} catch (IOException ex) {
			serviceDeskResponse.add(new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
		} catch (IllegalAccessException ex) {
			serviceDeskResponse.add(new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
		} catch (InvocationTargetException ex) {
			serviceDeskResponse.add(new ServiceDeskError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
		}
		return serviceDeskResponse;
	}
}

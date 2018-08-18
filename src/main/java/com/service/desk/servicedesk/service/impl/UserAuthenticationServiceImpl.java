package com.service.desk.servicedesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.desk.servicedesk.entity.UserDO;
import com.service.desk.servicedesk.repository.UserRepository;
import com.service.desk.servicedesk.service.UserAuthenticationService;

@Component
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDO save(UserDO userDO) {
		return userRepository.save(userDO);
	}

	@Override
	public Boolean checkUserAvailable(UserDO userDO) {

		if (userRepository.findById(userDO.getUser_ID()).get() != null)
			return true;
		
		return false;
	}

}

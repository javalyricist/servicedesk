package com.service.desk.servicedesk.service;

import com.service.desk.servicedesk.entity.UserDO;

public interface UserAuthenticationService {

	public UserDO save(UserDO userDO);
	
	public Boolean checkUserAvailable(UserDO userDO);
}

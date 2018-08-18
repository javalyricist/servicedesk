package com.service.desk.servicedesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.desk.servicedesk.entity.UserDO;

@Repository
public interface UserRepository extends JpaRepository<UserDO, String>{

}

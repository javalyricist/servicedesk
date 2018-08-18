package com.service.desk.servicedesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.desk.servicedesk.entity.TicketDO;

@Repository
public interface TicketRepository extends JpaRepository<TicketDO, Long>{

	public List<TicketDO> findBySrcSystemCode(String srcSystemId);
	public List<TicketDO> findByTechnicianIdAndSrcSystemCode(String technicianId,String srcSystemId);
	public List<TicketDO> findByRaisedByAndSrcSystemCode(String raisedBy,String srcSystemId);
	
	
}

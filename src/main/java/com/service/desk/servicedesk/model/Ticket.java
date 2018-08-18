package com.service.desk.servicedesk.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.service.desk.servicedesk.service.IServiceDesk;
import com.service.desk.servicedesk.util.ServiceTypeEnum;

@JsonPropertyOrder({ "ticketId", "raisedBy", "problemType", "createDt", "updateDt", "technicianId", "comment" })
public class Ticket implements IServiceDesk {

	private Long ticketId;
	private String raisedBy;
	private ServiceTypeEnum problemType;
	private Date createDt;
	private Date updateDt;
	private String technicianId;
	private String comment;
	private Boolean statusInd;
	private Long extenalId;
	private String srcSystemCode;

	public Ticket() {
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	public ServiceTypeEnum getProblemType() {
		return problemType;
	}

	public void setProblemType(ServiceTypeEnum problemType) {
		this.problemType = problemType;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getStatusInd() {
		return statusInd;
	}

	public void setStatusInd(Boolean statusInd) {
		this.statusInd = statusInd;
	}

	public Long getExtenalId() {
		return extenalId;
	}

	public void setExtenalId(Long extenalId) {
		this.extenalId = extenalId;
	}

	public String getSrcSystemCode() {
		return srcSystemCode;
	}

	public void setSrcSystemCode(String srcSystemCode) {
		this.srcSystemCode = srcSystemCode;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", raisedBy=" + raisedBy + ", problemType=" + problemType.name()
				+ ", createDt=" + createDt + ", updateDt=" + updateDt + ", technicianId=" + technicianId + ", comment="
				+ comment + ", statusInd=" + statusInd + ", extenalId=" + extenalId + ", srcSystemCode=" + srcSystemCode
				+ "]";
	}

   
	
}
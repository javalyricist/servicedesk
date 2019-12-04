package com.service.desk.servicedesk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.service.desk.servicedesk.util.ServiceTypeEnum;

@Entity
@Table(name = "TICKET_INFO")
public class TicketDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	@Column(name = "RAISED_BY")
	private String raisedBy;
	@Column(name = "PROBLEM_TYPE",length=20)
	@Enumerated(EnumType.STRING)
	private ServiceTypeEnum problemType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DT")
	private Date createDt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DT")
	private Date updateDt;
	@Column(name = "TECHNICIAN_ID")
	private String technicianId;
	@Column(name = "COMMENT")
	private String comment;
	@Column(name = "STATUS_IND")
	private Boolean statusInd;
	@Column(name = "EXTERNAL_ID")
	private String extenalId;
	@Column(name = "SRC_SYSTEM_CODE")
	private String srcSystemCode;

	public TicketDO() {
		super();
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

	public String getExtenalId() {
		return extenalId;
	}

	public void setExtenalId(String extenalId) {
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
		return "TicketDO [ticketId=" + ticketId + ", raisedBy=" + raisedBy + ", problemType=" + problemType.name()
				+ ", createDt=" + createDt + ", updateDt=" + updateDt + ", technicianId=" + technicianId + ", comment="
				+ comment + ", statusInd=" + statusInd + ", extenalId=" + extenalId + ", srcSystemCode=" + srcSystemCode
				+ "]";
	}

	
}

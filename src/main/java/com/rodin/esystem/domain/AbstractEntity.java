package com.rodin.esystem.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class AbstractEntity implements Persistence {
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	@GeneratedValue(generator = "generator")
	@Column(name = "Id", unique=true)
	private String id;

	@Column(name = "CreatedBy", nullable = false)
	private String createdBy;

	@Column(name = "CreatedDate", nullable = false)
	private Date createdDate;

	@Column(name = "ModifiedBy", nullable = false)
	private String modifiedBy;

	@Column(name = "ModifiedDate", nullable = false)
	private Date modifiedDate;

	@Column(name = "Status", nullable = false)
	private boolean status;

	public AbstractEntity() {
	}

	public AbstractEntity(String id, String createdBy, Date createdDate,
			String modifiedBy, Date modifiedDate, boolean status) {
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

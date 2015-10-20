package com.rodin.esystem.domain;

import java.util.Date;

public interface Persistence {
	public String getId();

	public void setId(String id);

	public String getCreatedBy();

	public void setCreatedBy(String createdBy);

	public Date getCreatedDate();

	public void setCreatedDate(Date createdDate);

	public String getModifiedBy();

	public void setModifiedBy(String createdBy);

	public Date getModifiedDate();

	public void setModifiedDate(Date createdDate);

	public boolean getStatus();

	public void setStatus(boolean status);
}

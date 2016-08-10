package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
public class Cast {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String castId;
	
	private String castName;
	
	private String castType;

	public String getCastId() {
		return castId;
	}

	public void setCastId(String castId) {
		this.castId = castId;
	}

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public String getCastType() {
		return castType;
	}

	public void setCastType(String castType) {
		this.castType = castType;
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", castNname=" + castName + ", castType=" + castType + "]";
	}

	

	
}

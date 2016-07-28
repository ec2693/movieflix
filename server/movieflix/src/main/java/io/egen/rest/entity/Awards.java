package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Awards {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String awardId;
	
	private String awardName;

	public String getAwardId() {
		return awardId;
	}

	public void setId(String awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	@Override
	public String toString() {
		return "Awards [id=" + awardId + ", award=" + awardName + "]";
	}
	  
	

}
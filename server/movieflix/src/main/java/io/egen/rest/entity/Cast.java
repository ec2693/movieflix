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
	private String id;
	
	private String name;
	
	private CastType type;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CastType getType() {
		return type;
	}

	public void setType(CastType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Cast [id=" + id + ", name=" + name + ", type=" + type + "]";
	}


}

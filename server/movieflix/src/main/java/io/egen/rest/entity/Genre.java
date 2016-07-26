package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Genre {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String id;
	private String genreType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenreType() {
		return genreType;
	}
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreType=" + genreType + "]";
	}
	
	

}

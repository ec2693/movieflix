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
	private String genreId;
	private String genreType;
	
	public String getGenreId() {
		return genreId;
	}
	public void setId(String genreId) {
		this.genreId = genreId;
	}
	public String getGenreType() {
		return genreType;
	}
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	@Override
	public String toString() {
		return "Genre [id=" + genreId + ", genreType=" + genreType + "]";
	}
	
	

}

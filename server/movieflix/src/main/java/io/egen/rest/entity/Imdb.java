package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Imdb {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String id;
	
	private String imdbId;
	private int imdbRating;
	private int imdbVotes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public int getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	@Override
	public String toString() {
		return "Imdb [id=" + id + ", imdbId=" + imdbId + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes
				+ "]";
	}
	
	
}

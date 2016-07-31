package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "MovieReview.findAll",query = "Select r FROM MovieReview r"),
	@NamedQuery(name = "MovieReview.findAllReviewForMovie",query = "SELECT r FROM MovieReview r WHERE r.movie =:pMovie"),
	@NamedQuery(name = "MovieReview.findAllReviewByUser",query = "SELECT r FROM MovieReview r WHERE r.user=:pUser"),
	@NamedQuery(name = "MovieReview.findAReviewForMovieByUser",query = "SELECT r FROM MovieReview r WHERE r.movie =:pMovie AND r.user=:pUser"),
	@NamedQuery(name = "MovieReview.getAverageRating",query = "SELECT r.ratings FROM MovieReview r WHERE r.movie = :pMovie")
})
public class MovieReview {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String id;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Movie movie;
	
	private String comments;
	private int ratings;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "MovieReview [id=" + id + ", user=" + user + ", movie=" + movie + ", comments=" + comments + ", ratings="
				+ ratings + "]";
	}
	

}

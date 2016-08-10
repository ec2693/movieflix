package io.egen.rest.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll",query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByTitle",query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
	@NamedQuery(name = "Movie.findAllByType",query = "SELECT m FROM Movie m WHERE m.type=:pType"),
	@NamedQuery(name = "Movie.findAllByYear",query = "SELECT m FROM Movie m WHERE m.year=:pYear"),
	@NamedQuery(name = "Movie.findAllByGenre",query = "SELECT m FROM Movie m WHERE m.genre=:pGenre"),
	@NamedQuery(name = "Movie.sortAllByYear",query = "SELECT m FROM Movie m ORDER BY m.year DESC")
})
public class Movie {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	private String id;
	
	@Column(unique = true)
	private String title;
	
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String plot;
	private String language;
	private String country;
	private String award;
	private String poster;
	private int metascore;
	private String type;
	
	@OneToOne
	private Imdb imdb;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private List<Cast> cast;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private List<Genre> genre;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Imdb getImdb() {
		return imdb;
	}

	public void setImdb(Imdb imdb) {
		this.imdb = imdb;
	}

	public List<Cast> getCast() {
		return cast;
	}

	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", poster=" + poster + ", metascore=" + metascore + ", type=" + type + ", imdb=" + imdb + ", cast="
				+ cast + ", genre=" + genre + ", awards=" + award + "]";
	}

	
	
}

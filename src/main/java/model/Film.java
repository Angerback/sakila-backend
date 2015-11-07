package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT a FROM Film a")

public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=255)
	private String title;

	@Column(name="description", nullable=true)
	private String description;

	@Column(name="release_year", nullable=true)
	private int releaseYear;
	
	@Column(name="language_id", nullable=false)
	private int languageId;
	
	@Column(name="original_language_id", nullable=true)
	private int originalLanguageId;
	
	@Column(name="rental_duration", nullable=false)
	private int rentalDuration;
	
	@Column(name="rental_rate", nullable=false)
	private float rentalRate;
	
	@Column(name="length", nullable=true)
	private int length;
	
	@Column(name="replacement_cost", nullable=false)
	private float replacementCost;
	
	@Enumerated(EnumType.STRING)
	@Column(name="rating", nullable=true)
	private Rating rating;
	
	@Column(name="special_features", nullable=true)
	private String specialFeatures;
	
	@OneToMany(mappedBy="film")
	private List<FilmActor> actors;

	
	List<FilmActor> getActors() {
		return actors;
	}
	
	public List<Actor> fetchActors() {
		List<Actor> as = new ArrayList<Actor>();
		
		for(FilmActor fActor : this.actors){
			as.add(fActor.getActor());
		}
	
		return as;
	}

	void setActors(List<FilmActor> actors) {
		this.actors = actors;
	}

	public void addActor(FilmActor actor) {
	  this.actors.add(actor);
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	public Film() {
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(int originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public float getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	
}

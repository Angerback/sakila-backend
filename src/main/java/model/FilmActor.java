package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="film_actor")
//En las querys, usar el nombre de la clase bajo esta estructura en particular.
@NamedQuery(name="FilmActor.findAll", query="SELECT a FROM FilmActor a")
@IdClass(FilmActorId.class)
public class FilmActor implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	

	@Id
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;
	
	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;
	
	@Column(name="last_update", unique=true, nullable=false)
	private Timestamp lastUpdate;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="actor_id", referencedColumnName="actor_id")
	private Actor actor;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="film_id", referencedColumnName="film_id")
	private Film film;
	
	public FilmActor(){	
	}

	public int getActorId() {
		return actorId;
	}


	public int getFilmId() {
		return filmId;
	}
	
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}


	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setFilmActorId(FilmActorId id) {
		this.actorId = id.getActorId();
		this.filmId = id.getFilmId();
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public void setActorAndFilm(Actor actor, Film film){
		if(this.actor == null && this.film==null){
			this.setFilm(film);
			this.setActor(actor);
			//Luego se actualiza las listas de los propios films y actores.
			this.getFilm().getActors().add(this);
			this.getActor().getFilms().add(this);
		}
		
	}
	
}

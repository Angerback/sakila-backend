package model;

import java.io.Serializable;

public class FilmActorId implements Serializable{
	private static final long serialVersionUID = 343L;
	
	private int actorId;
	private int filmId;
	
	public FilmActorId(){}
	
	public FilmActorId(int filmId, int actorId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

	public int getActorId() {
		return actorId;
	}

	public int getFilmId() {
		return filmId;
	}
	
	// Must have a hashCode method
    @Override
    public int hashCode() {
        return (int)(actorId + filmId);
    }
    
    // Must have an equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FilmActorId) {
            FilmActorId filmActorId = (FilmActorId) obj;
            return filmActorId.actorId == this.actorId && filmActorId.filmId == this.filmId;
        }
 
        return false;
    }
	
	
}

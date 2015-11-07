package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FilmActorFacade;
import model.Actor;
import model.Film;
import model.FilmActor;

@Stateless
public class FilmActorFacadeEJB extends AbstractFacade<FilmActor> implements FilmActorFacade  {
	
	@PersistenceContext(unitName = "sakilaPU")
	private EntityManager em;
	
	public FilmActorFacadeEJB() {
		super(FilmActor.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	@Override
	public void create(FilmActor entity) {
		Actor actor = getEntityManager().find(Actor.class, entity.getActorId());
		Film film = getEntityManager().find(Film.class, entity.getFilmId());
		
		entity.setActor(actor);
		entity.setFilm(film);
		
		actor.addFilm(entity);
		film.addActor(entity);
		
        getEntityManager().persist(entity);
    }
	
	@Override
	public void edit(FilmActor entity) {
		Actor actor = getEntityManager().find(Actor.class, entity.getActorId());
		Film film = getEntityManager().find(Film.class, entity.getFilmId());
		
		entity.setActor(actor);
		entity.setFilm(film);
		
		actor.addFilm(entity);
		film.addActor(entity);
		
        getEntityManager().merge(entity);
    }
	

}

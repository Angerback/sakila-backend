package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.FilmActorFacade;
import model.Actor;
import model.Film;
import model.FilmActor;
import model.FilmActorId;

@Path("/filmActors")
public class FilmActorService {
	@EJB 
	FilmActorFacade filmActorFacadeEJB;
	
	Logger logger = Logger.getLogger(ActorService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FilmActor> findAll(){
		return filmActorFacadeEJB.findAll();
	}
	
	@GET
    @Path("{actorId}/{filmId}")
    @Produces({"application/xml", "application/json"})
    public FilmActor find(@PathParam("filmId") Integer filmId,@PathParam("actorId") Integer actorId) {
        FilmActorId id = new FilmActorId(filmId.intValue(), actorId.intValue());
		return filmActorFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FilmActor entity) {
		filmActorFacadeEJB.create(entity);
    }

    @PUT
    @Path("{actorId}/{filmId}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("filmId") Integer filmId,@PathParam("actorId") Integer actorId, FilmActor entity) {
    	FilmActorId id = new FilmActorId(filmId.intValue(), actorId.intValue());
    	entity.setFilmActorId(id);
    	filmActorFacadeEJB.edit(entity);
    }
}

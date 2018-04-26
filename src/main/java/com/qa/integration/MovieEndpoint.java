package com.qa.integration;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.transaction.Transactional.TxType.REQUIRED;

import com.qa.business.service.IMovieService;

@Path("/movie")
public class MovieEndpoint {
	
	
		
		@Inject
		private IMovieService service;
		
		@GET
		@Path("/json")
		@Produces({"application/json"})
		
		public String getAllMovies() {
			return service.getAllMovies();
		}
		
		@GET
		@Path("/json/{id}")
		@Produces({"application/json"})
		
		public String getAMovies(@PathParam("id") Long id) {
			return service.getAMovie(id);
		}
		
		@POST
		@Path("/json")
		@Produces({"application/json"})
		@Consumes({"application/json"})
		public String createMovie(String jsonString) {
			
			return service.createMovie(jsonString);
		}
		
		@DELETE
		@Path("/json/{id}")
		@Transactional(REQUIRED)
		@Produces({"application/json"})
		
		public String removeMovie (@PathParam("id") Long id) {
			
			return service.removeMovie(id);
		}
	}


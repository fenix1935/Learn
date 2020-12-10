package com.learn.ws.rest.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.learn.ws.mod.dao.DAOLibro;
import com.learn.ws.rest.vo.VOLibro;



@Path("/Libro")
public class ServiceLibro {
	@GET
	@Path("/Libros")
	@Produces({MediaType.APPLICATION_JSON})
	public String Libros() throws SQLException{
		DAOLibro dao = new DAOLibro();
		String lista=dao.obtenerLibros();
		return lista;
	}
	
	@POST
	@Path("/BuscarLi")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public String Libro(String text) throws SQLException{
		DAOLibro dao = new DAOLibro();
		String lista=dao.obtenerLibro(text);
		return lista;
	}
	
	
}

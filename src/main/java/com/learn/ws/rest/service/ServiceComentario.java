package com.learn.ws.rest.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.learn.ws.mod.dao.DAOComentario;
import com.learn.ws.mod.dao.DAOLibro;
import com.learn.ws.rest.vo.VOComentario;
import com.learn.ws.rest.vo.VORespuesta;

@Path("/Comentario")
public class ServiceComentario {

	@POST
	@Path("/Comentar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response Comentar(VOComentario vo){
		 DAOComentario dao = new DAOComentario();        
	        try {	
				if(dao.comentar(vo)!=false) {
					return Response.status(Response.Status.CREATED).entity("{\"Status\": \"hecho\"}").build();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return Response.status(Response.Status.CREATED).entity("{\"Status\": \"Error\"}").build();
	}
	
	@POST
	@Path("/Responder")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response Responder(VORespuesta vo){
		 DAOComentario dao = new DAOComentario();        
	        try {	
				if(dao.Responder(vo)!=false) {
					return Response.status(Response.Status.CREATED).entity("{\"Status\": \"hecho\"}").build();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return Response.status(Response.Status.CREATED).entity("{\"Status\": \"Error\"}").build();
	}
	
	@POST
	@Path("/BuscarRe")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public String Libro(String text) throws SQLException{
		DAOComentario dao = new DAOComentario();
		String lista=dao.obtenerRespuesatas(Integer.parseInt(text));
		return lista;
	}
	
	@POST
	@Path("/BuscarCo")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public String TraerCo(String text) throws SQLException{
		DAOComentario dao = new DAOComentario();
		String lista=dao.obtenerComen(Integer.parseInt(text));
		return lista;
	}
	
	@GET
	@Path("/Comentarios")
	@Produces({MediaType.APPLICATION_JSON})
	public String Comentarios() throws SQLException{
		DAOComentario dao = new DAOComentario();
		String lista=dao.obtenerComentarios();
		return lista;
	}
}
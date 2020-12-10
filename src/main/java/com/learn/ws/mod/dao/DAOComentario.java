package com.learn.ws.mod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.learn.ws.mod.conexion.conexion;
import com.learn.ws.rest.vo.VOComentario;
import com.learn.ws.rest.vo.VOLibro;
import com.learn.ws.rest.vo.VORespuesta;

public class DAOComentario {
	
	
	private Connection con;
	private PreparedStatement statement;
	private boolean estadoOp;
	
	
	//Crear comentario
	public boolean comentar(VOComentario Vo) throws SQLException {
		String seleccio=null;
		estadoOp= false;
		con=obtenerConexion();
		
		try {
			con.setAutoCommit(false);
			seleccio = "INSERT INTO `Comentario` (`ClienteId`,`Titulo`,`Contenido`)VALUES (?,?,?)";
			statement = con.prepareStatement(seleccio);
			statement.setInt(1, Vo.getClienteId()); 
			statement.setString(2, Vo.getTitulo());
			statement.setString(3, Vo.getContenido());
			estadoOp=statement.executeUpdate()>0;
			con.commit();
			statement.close();
			con.close();
			
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		
		return estadoOp;
	}
	//traer toda la data
	public String obtenerComentarios() throws SQLException {
		Gson gson= new Gson();
		String h="";
		ResultSet resultSet = null;
		List<VOComentario> lista= new ArrayList<VOComentario>();

		String sql = null;
		estadoOp = false;
		con = obtenerConexion();

		try {
			sql = "SELECT * FROM `Comentario`";
			statement=con.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				VOComentario p=new VOComentario();
				p.setClienteId(resultSet.getInt(1));
				p.setTitulo(resultSet.getString(2));
				p.setContenido(resultSet.getString(3));
				lista.add(p);
				h= gson.toJson(lista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return h;
	}
	
	// Buscar por nombre

	public String obtenerComen(int idcomentario) throws SQLException {
		Gson gson= new Gson();
		String a="";
		List<VOComentario> lista= new ArrayList<VOComentario>();
		ResultSet resultSet = null;
		String sql = null;
		con = obtenerConexion();

		try {
			sql = "SELECT * FROM `Comentario` WHERE ClienteId = ?";
			statement=con.prepareStatement(sql);
			statement.setInt(1, idcomentario);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				VOComentario p=new VOComentario();
				p.setClienteId(resultSet.getInt(1));
				p.setTitulo(resultSet.getString(2));
				p.setContenido(resultSet.getString(3));
				lista.add(p);
				a= gson.toJson(lista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
	
	//Crear Respuesta
		public boolean Responder(VORespuesta Vo) throws SQLException {
			String seleccio=null;
			estadoOp= false;
			con=obtenerConexion();
			
			try {
				con.setAutoCommit(false);
				seleccio = "INSERT INTO `Respuesta` (`idComentario`, `Contenido`) VALUES (?,?)";
				statement = con.prepareStatement(seleccio);
				statement.setInt(1, Vo.getIdcomentario()); 
				statement.setString(2, Vo.getContenido());
				estadoOp=statement.executeUpdate()>0;
				con.commit();
				statement.close();
				con.close();
				
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
			
			return estadoOp;
		}
	//Traer respuestas
		public String obtenerRespuesatas(int idcomentario) throws SQLException {
			Gson gson= new Gson();
			String a="";
			List<VORespuesta> lista= new ArrayList<VORespuesta>();
			ResultSet resultSet = null;
			String sql = null;
			con = obtenerConexion();

			try {
				sql = "SELECT * FROM `Respuesta` WHERE idComentario = ?";
				statement=con.prepareStatement(sql);
				statement.setInt(1, idcomentario);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					VORespuesta p=new VORespuesta();
					p.setIdcomentario(resultSet.getInt(1));
					p.setContenido(resultSet.getString(2));
					lista.add(p);
					a= gson.toJson(lista);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return a;
		}
		
		
	//obtengo conexion
	private Connection obtenerConexion() throws SQLException{
		return conexion.getConnection();
	}
}

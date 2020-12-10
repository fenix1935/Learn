package com.learn.ws.mod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.learn.ws.mod.conexion.conexion;
import com.learn.ws.rest.vo.VOLibro;

public class DAOLibro {
	
	private Connection con;
	private PreparedStatement statement;
	
	//traer toda la data
	public String obtenerLibros() throws SQLException {
		Gson gson= new Gson();
		String h="";
		ResultSet resultSet = null;
		List<VOLibro> lista= new ArrayList<VOLibro>();

		String sql = null;
		con = obtenerConexion();

		try {
			sql = "SELECT * FROM `Libro`";
			statement=con.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				VOLibro p=new VOLibro();
				p.setId(resultSet.getInt(1));
				p.setImagen(resultSet.getString(2));
				p.setNombrelibro(resultSet.getString(3));
				p.setTipolibro(resultSet.getString(4));
				p.setEditorial(resultSet.getString(5));
				p.setFecha(resultSet.getString(6));
				p.setDescripcion(resultSet.getString(7));
				p.setDescarga(resultSet.getString(8));
				lista.add(p);
				h= gson.toJson(lista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return h;
	}
	
	
	// Buscar por nombre
	public String obtenerLibro(String Nombrelibro) throws SQLException {
		Gson gson= new Gson();
		String a="";
		List<VOLibro> lista= new ArrayList<VOLibro>();
		ResultSet resultSet = null;
		VOLibro p=new VOLibro();
		String sql = null;
		con = obtenerConexion();

		try {
			sql = "SELECT * FROM Libro WHERE Nombrelibro = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, Nombrelibro);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {				
				p.setId(resultSet.getInt(1));
				p.setImagen(resultSet.getString(2));
				p.setNombrelibro(resultSet.getString(3));
				p.setTipolibro(resultSet.getString(4));
				p.setEditorial(resultSet.getString(5));
				p.setFecha(resultSet.getString(6));
				p.setDescripcion(resultSet.getString(7));
				p.setDescarga(resultSet.getString(8));
				lista.add(p);
				a= gson.toJson(lista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
	//Buscar por letra
	public String obtenerLetra(String Nombrelibro) throws SQLException {
		Gson gson= new Gson();
		String a="";
		List<VOLibro> lista= new ArrayList<VOLibro>();
		ResultSet resultSet = null;
		VOLibro p=new VOLibro();
		String sql = null;
		con = obtenerConexion();

		try {
			sql = "SELECT * FROM Libro where NombreLibro like '?%' ";
			statement=con.prepareStatement(sql);
			statement.setString(1, Nombrelibro);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {				
				p.setId(resultSet.getInt(1));
				p.setImagen(resultSet.getString(2));
				p.setNombrelibro(resultSet.getString(3));
				p.setTipolibro(resultSet.getString(4));
				p.setEditorial(resultSet.getString(5));
				p.setFecha(resultSet.getString(6));
				p.setDescripcion(resultSet.getString(7));
				p.setDescarga(resultSet.getString(8));
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

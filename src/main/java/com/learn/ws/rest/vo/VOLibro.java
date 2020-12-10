package com.learn.ws.rest.vo;

public class VOLibro {
	int id;
	String imagen;
	String nombrelibro;
	String tipolibro;
	String editorial;
	String fecha;
	String descripcion;
	String descarga;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombrelibro() {
		return nombrelibro;
	}
	public void setNombrelibro(String nombrelibro) {
		this.nombrelibro = nombrelibro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescarga() {
		return descarga;
	}
	public void setDescarga(String descarga) {
		this.descarga = descarga;
	}
	public String getTipolibro() {
		return tipolibro;
	}
	public void setTipolibro(String tipolibro) {
		this.tipolibro = tipolibro;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public VOLibro() {
	}
	
}

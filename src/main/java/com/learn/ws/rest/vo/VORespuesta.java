package com.learn.ws.rest.vo;

public class VORespuesta {
	int idcomentario;
	String contenido;
	byte[] pdf;
	public int getIdcomentario() {
		return idcomentario;
	}
	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public VORespuesta() {
	}
	
}

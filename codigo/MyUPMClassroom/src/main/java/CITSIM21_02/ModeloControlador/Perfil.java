package CITSIM21_02.ModeloControlador;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ModeloControlador.Perfil.java
//  @ Date : 13/05/2022
//  @ Author : 
//
//




public class Perfil {
	private Foto foto;
	private String descripcion;
	private String genero;


	public Perfil(Foto foto, String descripcion, String genero) {
		this.foto = foto;
		this.descripcion = descripcion;
		this.genero = genero;
	}

	public Foto getFoto() {
		return foto;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
}

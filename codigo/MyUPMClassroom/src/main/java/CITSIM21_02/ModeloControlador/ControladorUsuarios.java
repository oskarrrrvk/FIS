package CITSIM21_02.ModeloControlador;//

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ModeloControlador.ControladorUsuarios.java
//  @ Date : 13/05/2022
//  @ Author : 
//
//

import java.util.ArrayList;
import java.util.Iterator;

import servidor.Autenticacion;
import servidor.Correo;
import servidor.UPMUsers;
import utilidades.Cifrado;
import servidor.ObtencionDeRol;


public class ControladorUsuarios implements IControladorUsuario {
	private ArrayList <Usuario> listaUsuarios;

	public ControladorUsuarios(){
		listaUsuarios = new ArrayList<>();
	}

	public UPMUsers AltaUsuario(String correo) {
		Autenticacion autenticacion= new Autenticacion();

		boolean ok=false;

		for (Usuario i: listaUsuarios) {
			if(i.getCorreo().equals(correo))
				ok=true;
		}

		if(!ok && autenticacion.existeCuentaUPM(correo))
			return ObtencionDeRol.get_UPM_AccountRol(correo);

		else
			return null;
	}

	public PAS crearPAS(String correo)
	{
		return new PAS(correo);
	}

	public Alumno crearAlumno(String correo)
	{
		return new Alumno(correo);
	}

	public PDI crearPDI(String correo)
	{
		return new PDI(correo);
	}

	public boolean loguearPAS(String correo, String ctr)
	{
		boolean res=false;
		PAS aux= this.getPAS(correo);

		if(correo.endsWith("pas@upm.es"))
			if(aux != null && aux.getContrasenya().equals(Cifrado.cifrar(ctr)))
				res=true;

		return res;
	}

	public PAS getPAS(String correo)
	{
		boolean existe=false;
		PAS Pas= null;

		Iterator<Usuario> i= listaUsuarios.iterator();

		while(i.hasNext() && !existe)
		{
			PAS aux= (PAS) i.next();
			if(aux.getCorreo().equals(correo))
			{
				existe=true;
				Pas= aux;
			}
		}
		return Pas;
	}

	public boolean agregarUsuario(Usuario usuario) {

		Autenticacion autenticacion= new Autenticacion();
		if(listaUsuarios.contains(usuario) || !autenticacion.existeCuentaUPM(usuario.getCorreo()))
		{
			return false;
		}
		else
		{
			usuario.setContrasenya(Cifrado.cifrar(usuario.getContrasenya()));
			listaUsuarios.add(usuario);
			return true;
		}
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
}
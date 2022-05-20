package CITSIM21_02.ModeloControlador;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ModeloControlador.Observador.java
//  @ Date : 13/05/2022
//  @ Author : 
//
//


import java.util.ArrayList;

public abstract class Observador extends Usuario implements IObservador {
	private ArrayList<Aula> aulas;

	public Observador()
	{
		aulas = new ArrayList<>();
	}

	public boolean suscribirse(Aula aula)
	{
		if(aulas.contains(aula))
		{
			System.out.println("ya esta suscrito al aula");
			return false;
		}
		else
		{
			this.aulas.add(aula);
			aula.addObservador(this);
			return true;
		}
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}
}

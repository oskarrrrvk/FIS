package CITSIM21_02;

import CITSIM21_02.Enumeradores.TAula;
import CITSIM21_02.Enumeradores.TCategoria;
import CITSIM21_02.ModeloControlador.*;


import servidor.*;

import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args)
    {
        System.out.println(ObtencionDeRol.get_UPM_AccountRol("pas@upm.es"));

        UPMUsers rol = ObtencionDeRol.get_UPM_AccountRol("pas@upm.es");

        if(rol==UPMUsers.PAS)
            System.out.println("a");
       Perfil perfil = new Perfil(new Foto("a"), "a", "a");
        PAS pas= new PAS(1111, 1920, "lola@gmail.com",
                "sisis", "Lola", "Los", "Palotes", "01234567L", perfil);
        Observador ob1= new Alumno("pepe@alumnos.upm.es", "123", "Pepito", "Los",
                "Palotes", "1", perfil, "223");
        Observador ob2= new PDI("juan@gmail.com", "sisis", "Juan", "Los",
                "Palotes", "01234567L", perfil, "111", TCategoria.CATEDRATICO);
        Aula aula= new Aula("Etsisi", "222", 5, TAula.MIXTA);
        Aula aul2= new Aula("Etsisi", "223", 5, TAula.MIXTA);
        pas.addAula(aula);
        pas.addAula(aul2);
        ob1.suscribirse(aula);
        ob1.suscribirse(aul2);
        ob2.suscribirse(aula);

        System.out.println(aula);

        for(Aula i:pas.getAulas())
            System.out.println(i.getIdentificadorInterno());

        for(Aula i: ob1.getAulas())
            System.out.println(i.getIdentificadorInterno());

        Autenticacion autenticacion= new Autenticacion();
        autenticacion.existeCuentaUPM("a");


        ob1.login("Pepito","sos","pepe@alumnos.upm.es");

    }

}

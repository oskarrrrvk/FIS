package CITSIM21_02.test.java;

import CITSIM21_02.Enumeradores.TAula;
import CITSIM21_02.ModeloControlador.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class PASTest extends TestCase { //MIRAR PORQUE POR ALGUN CASUAL SALTAN NULL.POINTER.EXCEPTION

    PAS pas1;
    PAS pas2;
    PAS pas3;

    Perfil perfil;

    Aula aula;
    Aula aula2;

    @Before

    public void setUp(){
        perfil = new Perfil(new Foto("a"), "a", "H");

        pas1 = new PAS(1111, 1920, "lola@gmail.com",
                "sisis", "Lola", "Los", "Palotes", "01234567L", perfil);
        pas2 = new PAS(1111, 1920, "lola@gmail.com",
                "sisis", "Lola", "Los", "Palotes", "01234567L", perfil);
        pas3 = new PAS(1111, 1920, "lola@gmail.com",
                "sisis", "Lola", "Los", "Palotes", "01234567L", perfil);

        aula = new Aula("Etsisi", "CIC2", 50, TAula.LABORATORIO);
        aula2 = new Aula("Etsisi", "CIC1", 50, TAula.MIXTA);

        pas2.addAula(aula);
        pas3.addAula(aula2);

    }

    @Test
    public void testAddAula() {
        assertEquals(true,pas1.addAula(aula));
    }

    public void testAddAula2() {
        assertEquals(false, pas2.addAula(aula));
    }


    public void testRemoveAula() {
        assertEquals(true,pas2.removeAula(aula));
    }

    public void testRemoveAula2() {
        assertEquals(false, pas1.removeAula(aula));
    }

    public void testRemoveAula3() {
        assertEquals(false, pas1.removeAula(aula));
    }

    public void testRemoveAula4() {
        assertEquals(false, pas3.removeAula(aula));
    }

}
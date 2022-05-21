package CITSIM21_02.test.java;

import CITSIM21_02.Enumeradores.TAula;
import CITSIM21_02.ModeloControlador.Alumno;
import CITSIM21_02.ModeloControlador.Aula;
import CITSIM21_02.ModeloControlador.Foto;
import CITSIM21_02.ModeloControlador.Perfil;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AlumnoTest extends TestCase {
    Alumno alumno;
    Alumno alumno2;
    Alumno alumno3;
    Perfil perfil;
    Aula aula;
    Aula aula2;

    @Before
    public void setUp(){
        perfil = new Perfil(new Foto("La vida"), "Pasan muchas cosas", "drama");

        alumno = new Alumno("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223");
        alumno2 = new Alumno("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223");
        alumno3 = new Alumno("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223");

        aula = new Aula("ETSISI","CIC1",50, TAula.MIXTA);
        aula2 = new Aula("ETSISI","CIC2",2, TAula.MIXTA);


        alumno2.suscribirse(aula);
        alumno.suscribirse(aula2);
        alumno2.suscribirse(aula2);
    }

    @Test
    public void testSuscribirse() {
        assertEquals(true,alumno.suscribirse(aula));
    }

    public void testSuscribirse2() {
        assertEquals(false,alumno2.suscribirse(aula));
    }

    public void testSuscribirse3() {
        assertEquals(false,alumno3.suscribirse(aula2));
    }
}
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
    Perfil perfil;
    Aula aula;

    @Before
    public void setUp(){
        perfil = new Perfil(new Foto("La vida"), "Pasan muchas cosas", "drama");

        alumno = new Alumno("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223");
        alumno2 = new Alumno("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223");

        aula = new Aula("ETSISI","br0299",50, TAula.MIXTA);

        alumno2.suscribirse(aula);
    }

    @Test
    public void testSuscribirse() {
        assertEquals(true,alumno.suscribirse(aula));
    }

    public void testSuscribirse2() {
        assertEquals(false,alumno2.suscribirse(aula));
    }
}
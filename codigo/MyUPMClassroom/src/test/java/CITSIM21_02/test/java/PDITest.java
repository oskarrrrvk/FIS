package CITSIM21_02.test.java;

import CITSIM21_02.Enumeradores.TAula;
import CITSIM21_02.Enumeradores.TCategoria;
import CITSIM21_02.ModeloControlador.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class PDITest extends TestCase {

    PDI pdi1;
    PDI pdi2;
    Perfil perfil;
    Aula aula;

    @Before
    public void setUp(){
        perfil = new Perfil(new Foto("La vida"), "Pasan muchas cosas", "drama");

        pdi1 = new PDI("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil,"244LX", TCategoria.PROFESOR_AYUDANTE_DOCTOR );
        pdi2 = new PDI("pepito@gmail.com", "sisis", "Pepito", "Los",
                "Palotes", "01234567L", perfil, "223",TCategoria.PROFESOR_CONTRATADO_DOCTOR);

        aula = new Aula("ETSISI","br0299",50, TAula.MIXTA);

        pdi2.suscribirse(aula);
    }

    @Test
    public void testSuscribirse() {
        assertEquals(true,pdi1.suscribirse(aula));
    }

    public void testSuscribirse2() {
        assertEquals(false,pdi2.suscribirse(aula));
    }

}
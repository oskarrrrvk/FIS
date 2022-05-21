package CITSIM21_02.test.java;

import CITSIM21_02.Enumeradores.TAula;
import CITSIM21_02.ModeloControlador.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class ContAulaTest extends TestCase {

    ContAula contAula;
    ContAula contAula2;
    ContAula contAula3;

    Aula aula;
    Aula aula2;

    @Before
    public void setUp() throws Exception {
        contAula = new ContAula();
        contAula2 = new ContAula();
        contAula3 = new ContAula();

        aula = new Aula("ETSISI","CIC1",50,TAula.MIXTA);
        aula2 = new Aula("ETSISI","CIC2",50,TAula.MIXTA);

        contAula2.agregarAula(aula);
        contAula3.agregarAula(aula2);

    }

    @Test
    public void testAgregarAula() {
        assertEquals(true, contAula.agregarAula(aula));
        /**
        * Se guarda el aula porque ese aula no existe
        * */
    }

    public void testAgregarAula2() {
        assertEquals(false, contAula2.agregarAula(aula));
        /**
         * No se guarda el aula porque ese aula ya existe
         * */
    }


    public void testExisteAula(){
        assertEquals(true, contAula2.existeAula("CIC1"));
        /**
         * Se puede encontrar ese aula porque esta incluida en la lista
         * */
    }

    public void testExisteAula2(){
        assertEquals(false, contAula2.existeAula("CIC2"));
        /**
         * No se puede encontrar ese aula porque no esta en la lista
         * */
    }
    public void testExisteAula3(){
        assertEquals(false, contAula.existeAula("3204"));
        /**
         * Como la lista esta vacia no existe ese un aula con esa id
         * */
    }
}
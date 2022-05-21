package CITSIM21_02.test.java;

import CITSIM21_02.Enumeradores.TCategoria;
import CITSIM21_02.ModeloControlador.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import servidor.UPMUsers;

public class ControladorUsuariosTest extends TestCase {

    ControladorUsuarios contUsu;
    ControladorUsuarios contUsu2;
    ControladorUsuarios contUsu3;

    Usuario usuario1;
    Usuario usuario2;
    Usuario usuario3;
    Usuario usuario4;
    Usuario usuario5;

    String correo1;
    String correo2;
    String correo3;
    String correo4;
    String correo5;

    Perfil perfil;
    @Before
    public void setUp(){
        contUsu = new ControladorUsuarios();
        contUsu2 = new ControladorUsuarios();
        contUsu3 = new ControladorUsuarios();

        perfil = new Perfil(new Foto("foto"),"descripcion","H");
        correo1 = "alumno@alumnos.upm.es";
        correo2 = "pdi@upm.es";
        correo3 = "pas@upm.es";
        correo4 = "NoUPM@gmail.com";
        correo5 = "SSpas@upm.es";

        usuario1 = new Alumno(correo1,"1234", "Paco","apellido1","apellido2",
                "1234567F",perfil,"nx2333");
        usuario2 = new PDI(correo2,"1234","Carlos","apellido1","apellido2",
                "9876543C",perfil,"8945SV", TCategoria.CATEDRATICO);
        usuario3 = new PAS(902,1930,correo3,"1234","Adolfo",
                "apellido1","apellido2","8945SS",perfil);
        usuario4 = new PAS(902,1930,correo4,"1234","Adolfo",
                "apellido1","apellido2","8945SS",perfil);
        usuario5 = new PAS(902,1930,correo5,"1234","Adolfo",
                "apellido1","apellido2","8945SS",perfil);

        contUsu.agregarUsuario(usuario1);
        contUsu2.agregarUsuario(usuario2);
        contUsu3.agregarUsuario(usuario3);
        contUsu3.agregarUsuario(usuario4);

    }

    public void testAgregarUsuario() {
        assertEquals(true,contUsu.agregarUsuario(usuario2));
        /**
         * Puede agregar el usuario porque pertenece a la UPM y no ha sido agregado anteriormente
         * */
    }

    public void testAgregarUsuario2() {
        assertEquals(false,contUsu.agregarUsuario(usuario1));
        /**
         * No puedo agregar el usuario porque el usuario ya ha sido agregado
         * */
    }

    public void testAgregarUsuario3() {
        assertEquals(false,contUsu.agregarUsuario(usuario4));
        /**
         * No puedo agregar el usuario porque el usuario no usa correo de la UPM
         * */
    }
    public void testAgregarUsuario4() {
        assertEquals(true,contUsu.agregarUsuario(usuario3));
        /**
         * Puede agregar el usuario porque pertenece a la UPM y no ha sido agregado anteriormente
         * */
    }

    @Test
    public void testAltaUsuario() {
        assertEquals(null,contUsu.AltaUsuario(correo1));
        /**
         * como el usuario estaba dado de alta no se puede dar de alta
         * */
    }

    public void testAltaUsuario2() {
        assertEquals(null,contUsu2.AltaUsuario(correo2));
        /**
         * como el usuario estaba dado de alta no se puede dar de alta
         * */
    }

    public void testAltaUsuario3() {
        assertEquals(null,contUsu3.AltaUsuario(correo3));
        /**
         * como el usuario estaba dado de alta no se puede dar de alta
         * */
    }

    public void testAltaUsuario4() {
        assertEquals(UPMUsers.PDI,contUsu.AltaUsuario(correo2));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario5() {
        assertEquals(UPMUsers.PAS,contUsu.AltaUsuario(correo3));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario6() {
        assertEquals(UPMUsers.ALUMNO,contUsu2.AltaUsuario(correo1));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario7() {
        assertEquals(UPMUsers.PAS,contUsu2.AltaUsuario(correo3));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario8() {
        assertEquals(UPMUsers.ALUMNO,contUsu3.AltaUsuario(correo1));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario9() {
        assertEquals(UPMUsers.PDI,contUsu3.AltaUsuario(correo2));
        /**
         * se puede dar de alta porque ese correo no existe
         * */
    }

    public void testAltaUsuario10() {
        assertEquals(null,contUsu.AltaUsuario(correo4));
        /**
         * No es un correo perteneciente a la UPM por lo que no se puede dar de alta
         * */
    }
    
    public void testLogearMenu(){
        assertEquals(true,contUsu.loguearMenu(correo1,"1234","@alumnos.upm.es"));
        /**
         * Se puede logear poque el correo la contrasenia y el tipo de usuario son acordes con el encontrado
         * */
    }
    public void testLogearMenu2(){
        assertEquals(true,contUsu2.loguearMenu(correo2,"1234","pdi@upm.es"));
        /**
         * Se puede logear poque el correo la contrasenia y el tipo de usuario son acordes con el encontrado
         * */
    }
    public void testLogearMenu3(){
        assertEquals(true,contUsu3.loguearMenu(correo3,"1234","pas@upm.es"));
        /**
         * Se puede logear porque el correo la contrasenia y el tipo de usuario son acordes con el encontrado
         * */
    }
    public void testLogearMenu4(){
        assertEquals(false,contUsu.loguearMenu(correo2,"1234","pdi@upm.es"));
        /**
         * No se puede logear porque el correo no se encuantra entre los usuarios
         * */
    }
    public void testLogearMenu5(){
        assertEquals(false,contUsu.loguearMenu(correo1,"1111","@alumnos.upm.es"));
        /**
         * No se puede logear porque la contrasenia es incorrecta
         * */
    }
    public void testLogearMenu6(){
        assertEquals(false,contUsu2.loguearMenu(correo2,"1234","@alumnos.upm.es"));
        /**
         * No se puede logear porque el correo es distinto al tipo
         * */
    }
    public void testLogearMenu7(){
        assertEquals(false,contUsu2.loguearMenu(correo1,"1234","pdi@upm.es"));
        /**
         * No se puede logear porque el correo es distinto al que esta registrado
         * */
    }

    public void testLogearMenu8(){
        assertEquals(false,contUsu2.loguearMenu(correo1,"1234","@alumnos.upm.es"));
        /**
         * No se puede logear porque el correo no se encuentra entre los guardados
         * */
    }

    public void testLogearMenu9(){
        assertEquals(false,contUsu2.loguearMenu(correo2,"1111","pdi@upm.es"));
        /**
         * No se puede logear porque la contrasenia es incorrecta
         * */
    }

    public void testLogearMenu10(){
        assertEquals(false,contUsu3.loguearMenu(correo2,"1234","pas@upm.es"));
        /**
         * No se puede logear porque el correo es distinto al tipo
         * */
    }
    public void testLogearMenu11(){
        assertEquals(false,contUsu3.loguearMenu(correo2,"1234","pdi@upm.es"));
        /**
         * No se puede logear porque el correo no se encuentra entre los guardados
         * */
    }
    public void testLogearMenu12(){
        assertEquals(false,contUsu3.loguearMenu(correo3,"1111","pas@upm.es"));
        /**
         * No se puede logear porque la contrasenia es incorrecta
         * */
    }

}
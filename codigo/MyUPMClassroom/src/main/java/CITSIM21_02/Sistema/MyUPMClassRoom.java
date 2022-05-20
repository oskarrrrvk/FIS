package CITSIM21_02.Sistema;

import java.util.ArrayList;

import CITSIM21_02.ModeloControlador.*;
import CITSIM21_02.ModeloControlador.ControladorUsuarios;
import CITSIM21_02.Vista.*;
import servidor.UPMUsers;

public class MyUPMClassRoom {
    //----------------------atributos----------------------//

    private ControladorUsuarios CUsuario;
    private GUIControladorUsuario GCUsuario;
    private GUIUsuario GUsuario;
    private GUIMenu GMenu;
    private GUIAulas GAulas;
    private ContAula contAula;
    private GUIControladorAula GCAulas;


    //---------------------Constructor---------------------//

    public MyUPMClassRoom() {
        this.CUsuario = new ControladorUsuarios();
        this.GCUsuario = new GUIControladorUsuario();
        this.GUsuario = new GUIUsuario();
        this.GMenu = new GUIMenu();
        this.GAulas = new GUIAulas();
        this.contAula = new ContAula();
        this.GCAulas = new GUIControladorAula();
    }

    //-----------------------Getters-----------------------//

    public ControladorUsuarios getCUsuario() {
        return this.CUsuario;
    }
    public GUIControladorUsuario getGCUsuario() { return this.GCUsuario; }
    public GUIUsuario getGUsuario() {
        return this.GUsuario;
    }
    public GUIMenu getGMenu() {
        return this.GMenu;
    }
    public GUIAulas getGAulas() {
        return this.GAulas;
    }
    public ContAula getContAula(){ return this.contAula; }
    public GUIControladorAula getGCAulas(){ return this.GCAulas; }

    //-----------------------Setters-----------------------//

    public void setGCUsuario(ControladorUsuarios CUsuario) {
        this.CUsuario = CUsuario;
    }
    public void setGCUsuario(GUIControladorUsuario GCUsuario) {
        this.GCUsuario = GCUsuario;
    }
    public void setGUsuario(GUIUsuario GUsuario) {
        this.GUsuario = GUsuario;
    }
    public void setGMenu(GUIMenu GMenu) {
        this.GMenu = GMenu;
    }
    public void setGAulas(GUIAulas GAulas) {
        this.GAulas = GAulas;
    }

    //------------------------Main------------------------//

    public static void main(String[] args)
    {

        MyUPMClassRoom app = new MyUPMClassRoom();
        int menu;
        do{
            menu = app.getGMenu().menu();
            switch (menu){
                case 1:{
                    String correo = app.getGCUsuario().introducirCorreo();
                        UPMUsers rol = app.getCUsuario().AltaUsuario(correo);
                    try{
                        switch(rol) {
                            case PAS: {
                                PAS pas = app.getCUsuario().crearPAS(correo);
                                app.getGUsuario().rellenarPAS(pas);
                                app.getCUsuario().agregarUsuario(pas);
                                break;
                            }
                            case PDI: {
                                PDI pdi = app.getCUsuario().crearPDI(correo);
                                app.getGUsuario().rellenarPDI(pdi);
                                app.getCUsuario().agregarUsuario(pdi);
                                break;
                            }
                            case ALUMNO: {
                                Alumno alumno = app.getCUsuario().crearAlumno(correo);
                                app.getGUsuario().rellenarAlumno(alumno);
                                app.getCUsuario().agregarUsuario(alumno);
                                break;
                            }
                        }
                    }catch (NullPointerException e){
                        System.out.println("   Error el correo que has introducido no es valido o ya existe");
                    }
                    break;
                }
                case 2:{
                    String correo= app.getGUsuario().pedirCorreo();
                    if(app.getCUsuario().loguearPAS(correo, app.GUsuario.pedirContraseniav2()))
                    {
                        String id = app.getGAulas().pedirIdAula();
                        if(app.getContAula().existeAula(id))
                            System.out.println("   Error: El aula que intenta agregar ya existe");
                        else {
                            PAS pas = app.getCUsuario().getPAS(correo);
                            Aula aula = pas.darAltaAula(id, pas);
                            app.getGAulas().rellenarAula(aula);
                            app.getContAula().agregarAula(aula);
                            pas.addAula(aula);
                        }
                    }
                    else
                        System.out.println("   Los parametros introducidos no son correctos");
                    break;
                }
                case 3:{
                    app.getGCAulas().show(app.getContAula());
                    break;
                }
                /*case 4:{
                    app.getGCAulas().show(app.getContAula());

                    break;
                }*/
            }
        } while(menu!=0);
    }
}

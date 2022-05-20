package CITSIM21_02.Vista;

import java.util.Scanner;

public class GUIMenu {
    public int menu() {
        Scanner scan = new Scanner(System.in);
        int op;
        System.out.println("   ┌───────────────────────────┐");
        System.out.println("   │   1. Dar Alta Usuario     │");
        System.out.println("   │   2. Dar de Alta Aula     │");
        System.out.println("   │   3. Suscribirse Alumno   │");
        System.out.println("   │   4. Suscribirse PDI      │");
        System.out.println("   │   0. Salir                │");
        System.out.println("   └───────────────────────────┘");

        do{
            System.out.println("\n   │Seleccione una opcion│-> ");
            op = scan.nextInt();
        }while(op>4 || op<0);
        return op;
    }
}

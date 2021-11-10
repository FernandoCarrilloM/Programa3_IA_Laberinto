
package Laberintos;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Escenarios ob = new Escenarios();
        Metodo metodo = new Metodo();
        Scanner lector = new Scanner(System.in);
        int opc;
        int mod = 0;
        do{
            System.out.println("1) Laberinto Profundidad");
            System.out.println("2) Laberinto Anchura");
            System.out.println("0)  Salir");
            System.out.print("opcion ->");
            opc = lector.nextInt();
            
            if (opc != 0) {
                System.out.println("2.- Empezar");
                mod = lector.nextInt();
            }
            switch (opc) {
                case 1:
                    if (mod == 2) {
                        metodo.Auto(ob.escenario(), ob.fila(ob.escenario()), ob.columna(ob.escenario()));
                    }
                    break;
                case 2:
                    if (mod == 2) {
                        metodo.Amplitud(ob.escenario(), ob.fila(ob.escenario()), ob.columna(ob.escenario()));
                    } 
                    break;
                default:
                    System.out.println("Opcion no valida");
                }
            } while (opc != 0);
        }

}
   


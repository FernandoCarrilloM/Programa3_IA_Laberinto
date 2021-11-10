
package Laberintos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodo {
    Scanner lector = new Scanner(System.in);
    boolean [][] visit = new boolean[100][100];
        
    public void Avanzar(String[][] matriz, int filas, int colum) {
        String labe = "x";
        int golpes = 0;
        Escenarios x = new Escenarios();
        int []arreglo = x.posX(matriz);
        while (golpes < 5) {
            if (matriz[filas][colum] == matriz[arreglo[0]][arreglo[1]]) {
                System.out.println("HAS GANADO !!");
                golpes += 5;
            } else {
                imprimirMatriz(matriz);
                System.out.print("Mover -> ");
                String cara = lector.next();
                //Derecha
                if (cara.equalsIgnoreCase("j")) {
                    if (!matriz[filas][colum + 1].equals("a") && !matriz[filas][colum + 1].equals("|") && !matriz[filas][colum +
                    1].equals("-")) {
                        matriz[filas][colum + 1] = "*";
                        matriz[filas][colum] = " ";
                        colum++;
                    } else {
                        golpes++;
                        System.out.println("Has golpeado " + golpes + " de 5 con la pared ");
                    }
                }
                //izquierda
                if (cara.equalsIgnoreCase("g")) {
                    if (!matriz[filas][colum - 1].equals("a") && !matriz[filas][colum - 1].equals("|") && !matriz[filas][colum -
                    1].equals("-")) {
                        matriz[filas][colum - 1] = "*";
                        matriz[filas][colum] = " ";
                        colum--;
                    } else {
                        golpes++;
                        System.out.println("Has golpeado " + golpes + " de 5 con la pared ");
                    }
                }
                //arriba
                if (cara.equalsIgnoreCase("y")) {
                    if (!matriz[filas - 1][colum].equals("a") && !matriz[filas - 1][colum].equals("|") && !matriz[filas -
                    1][colum].equals("-")) {
                        matriz[filas - 1][colum] = "*";
                        matriz[filas][colum] = " ";
                        filas--;
                    } else {
                        golpes++;
                        System.out.println("Has golpeado " + golpes + " de 5 con la pared ");
                    }
                }
                //abajo
                if (cara.equalsIgnoreCase("h")) {
                    if (!matriz[filas + 1][colum].equals("a") && !matriz[filas + 1][colum].equals("|") && !matriz[filas +
                    1][colum].equals("-")) {
                        matriz[filas + 1][colum] = "*";
                        matriz[filas][colum] = " ";
                        filas++;
                    } else {
                        golpes++;
                        System.out.println("Has golpeado " + golpes + " de 5 con la pared ");
                    }
                }
            }
        }
    }
    public void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void Auto(String[][] matriz, int filas, int colum) {
    String labe = "x";
    String direccion = "derecha";
    Escenarios x = new Escenarios();
    int []arreglo = x.posX(matriz);
    while (matriz[filas][colum] != matriz[arreglo[0]][arreglo[1]]) {

        imprimirMatriz(matriz);
        switch (direccion) {
            case "derecha"://DERECHA

                if (!matriz[filas - 1][colum].equals("0") && !matriz[filas - 1][colum].equals("|") && !matriz[filas-
                1][colum].equals("-")) {

                    matriz[filas - 1][colum] = "*";
                    matriz[filas][colum] = " ";
                    filas--;
                    direccion = "arriba";
                } else {
                    if (!matriz[filas][colum + 1].equals("0") && !matriz[filas][colum + 1].equals("|") && !matriz[filas][colum +
                    1].equals("-")) {
                        matriz[filas][colum + 1] = "*";
                        matriz[filas][colum] = " ";
                        colum++;
                    } else {
                        if (!matriz[filas + 1][colum].equals("0") && !matriz[filas + 1][colum].equals("|") &&
                        !matriz[filas+1][colum].equals("-")) {
                            matriz[filas + 1][colum] = "*";
                            matriz[filas][colum] = " ";
                            filas++;
                            direccion = "abajo";
                        } else {
                            matriz[filas][colum - 1] = "*";
                            matriz[filas][colum] = " ";
                            colum--;
                            direccion = "izquierda";
                        }
                    }
                }
                break;
            case "arriba"://ARRIBA
                if (!matriz[filas][colum - 1].equals("0") && !matriz[filas][colum - 1].equals("|") && !matriz[filas][colum -
                1].equals("-")) {
                    matriz[filas][colum - 1] = "*";
                    matriz[filas][colum] = " ";
                    colum--;
                    direccion = "izquierda";
                } else {
                    if (!matriz[filas - 1][colum].equals("0") && !matriz[filas - 1][colum].equals("|") && !matriz[filas-
                    1][colum].equals("-")) {
                        matriz[filas - 1][colum] = "*";
                        matriz[filas][colum] = " ";
                        filas--;
                    } else {
                        if (!matriz[filas][colum + 1].equals("0") && !matriz[filas][colum + 1].equals("|") && !matriz[filas][colum +
                        1].equals("-")) {
                            matriz[filas][colum + 1] = "*";
                            matriz[filas][colum] = " ";
                            colum++;
                            direccion = "derecha";
                        } else {
                            matriz[filas + 1][colum] = "*";
                            matriz[filas][colum] = " ";
                            filas++;
                            direccion = "abajo";
                        }
                    }
                }   
                break;
            case "izquierda":
                if (!matriz[filas + 1][colum].equals("0") && !matriz[filas + 1][colum].equals("|") &&
                !matriz[filas+1][colum].equals("-")) {
                    matriz[filas + 1][colum] = "*";
                    matriz[filas][colum] = " ";
                    filas++;
                    direccion = "abajo";
                } else {
                    if (!matriz[filas][colum - 1].equals("0") && !matriz[filas][colum - 1].equals("|") && !matriz[filas][colum -
                    1].equals("-")) {
                        matriz[filas][colum - 1] = "*";
                        matriz[filas][colum] = " ";
                        colum--;
                    } else {
                        if (!matriz[filas - 1][colum].equals("0") && !matriz[filas - 1][colum].equals("|") && !matriz[filas-
                        1][colum].equals("-")) {
                            matriz[filas - 1][colum] = "*";
                            matriz[filas][colum] = " ";
                            filas--;
                            direccion = "arriba";
                        } else {
                            matriz[filas][colum + 1] = "*";
                            matriz[filas][colum] = " ";
                            colum++;
                            direccion = "derecha";
                        }
                    }
                }
                break;
            case "abajo"://ARRIBA
                if (!matriz[filas][colum + 1].equals("0") && !matriz[filas][colum + 1].equals("|") && !matriz[filas][colum +
                1].equals("-")) {
                    matriz[filas][colum + 1] = "*";
                    matriz[filas][colum] = " ";
                    colum++;
                    direccion = "derecha";
                } else {
                    if (!matriz[filas + 1][colum].equals("0") && !matriz[filas + 1][colum].equals("|") &&
                    !matriz[filas+1][colum].equals("-")) {
                        matriz[filas + 1][colum] = "*";
                        matriz[filas][colum] = " ";
                        filas++;
                    } else {
                        if (!matriz[filas][colum - 1].equals("0") && !matriz[filas][colum - 1].equals("|") && !matriz[filas][colum -
                        1].equals("-")) {
                            matriz[filas][colum - 1] = "*";
                            matriz[filas][colum] = " ";
                            colum--;
                            direccion = "izquierda";
                        } else {
                            matriz[filas - 1][colum] = "*";
                            matriz[filas][colum] = " ";
                            filas--;
                            direccion = "arriba";
                        }
                    }
                }
                break;
            default:
                throw new AssertionError();
            }
            try {   
                Thread.sleep(250);
            }
            catch(InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
        imprimirMatriz(matriz);
        System.out.println("Termino!");
    }
    public void Amplitud(String[][] matriz, int filas, int colum){
        String labe = "x";
        String direccion = "derecha";
        Escenarios x = new Escenarios();
        int []arreglo = x.posX(matriz);
        DFS(matriz,filas,colum);
        imprimirMatriz(matriz);
        System.out.println("Termino!");
    }
    public void DFS(String[][] matriz, int filas, int colum){
        try {
            Escenarios x = new Escenarios();
            int []arreglo = x.posX(matriz);
            if(matriz[filas][colum].equals("0") || matriz[filas][colum].equals("|")
                    || matriz[filas][colum].equals("-") || visit[filas][colum]){
                return;
            }
            if( visit[filas][colum]==true){
                matriz[filas][colum] = " ";
            }
            if(matriz[filas][colum] == matriz[arreglo[0]][arreglo[1]]){
                return;
            }
            matriz[filas][colum] = "*";
            imprimirMatriz(matriz);
            Thread.sleep(160);
            visit[filas][colum] = true;
            DFS(matriz,filas+1,colum);
            DFS(matriz,filas,colum+1);
            DFS(matriz,filas-1,colum);
            DFS(matriz,filas,colum-1);
            
            visit[filas][colum] = false;
            return;
        } catch (InterruptedException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
}


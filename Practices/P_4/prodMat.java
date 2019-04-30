
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*2. Realice la misma tarea para el producto de matrices, utilizando esta vez
herencia de la clase Thread. Ficheros a generar: prodMat.java para la version
secuencial, prodMatConcurrente.java y UsaprodMatConcurrente.java*/

public class prodMat {
    public static void main(String []arg){
        Scanner entrada = new Scanner(System.in);
        int n, m, tamano, suma, op;
        System.out.println("Introduzca las dimensiones de la matriz: ");
        n = entrada.nextInt();
        m = entrada.nextInt();
        System.out.println("Introduzca el numero de columnas de la segunda matriz: ");
        tamano = entrada.nextInt();
        int A[][] = new int[n][m];
        int b[][] = new int[m][tamano];
        int sol[][] = new int[n][tamano];
         
        System.out.println("1.Introducir los datos manualmente");
        System.out.println("2.Introducir los datos aleatoriamente");
        op = entrada.nextInt();
        switch(op){
            case 1:
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        System.out.println("Introduzca el valor de la posicion de la matriz ["+i+"]["+j+"]: ");
                        A[i][j] = entrada.nextInt();
                    }
                     
                }
                for(int i=0;i<m;i++){
                    for(int j=0;j<tamano;j++){
                    System.out.println("Introduzca el valor de la posicion de la segunda matriz ["+i+"]["+j+"]");
                        b[i][j] = entrada.nextInt();
                    }
                     
                }
                break;
                
            case 2:
                Random aleatorio = new Random();
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        A[i][j] = aleatorio.nextInt();
                    }
                     
                }
                for(int i=0;i<m;i++){
                    for(int j=0;j<tamano;j++){
                        b[i][j] = aleatorio.nextInt();
                    }
                     
                }
                break;
     
     
        }
        for(int i=0;i<n;i++){
                    for(int j=0;j<tamano;j++){
                        sol[i][j]=0;
                    }
                     
        }

        Date d = new Date();
        long inicCronom = System.currentTimeMillis(); //Preparación del cronómetro
        d.setTime(inicCronom); //Activación del cronómetro
        for(int i = 0; i < n; i++){
            for(int j = 0; j < tamano; j++){
                suma = 0;
                for(int k = 0; k <tamano; k++){
                    suma += A[i][k] * b[k][j];
                }
                sol[i][j] = suma;
            }
        }
         
        long finCronom = System.currentTimeMillis(); //Pausa cronómetro
        d.setTime(finCronom);

        System.out.println("La matriz solucion es ");
        for(int k=0;k<n;k++){
            for(int i=0;i<tamano;i++){
            System.out.print("(" + sol[k][i]);
            System.out.print("  ");
            }
            System.out.print("\n");
             
        }
        System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
     
    }
}

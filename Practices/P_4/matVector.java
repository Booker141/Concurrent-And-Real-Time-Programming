
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

/*1. Se desea disponer de un programa que realice de forma paralela, supuesto
un procesador multi-core, el producto de una matriz densa por un vector.
Escriba primero un programa que solucione el problema de forma secuencial
mediante el algoritmo clasico de tiempo cubico, y llamelo matVector.java. Incorpore
un menu de usuario con dos opciones: una que permita introducir las
dimensiones, la matriz y el vector manualmente, y otra que lea las dimensiones
y rellene ambos objetos de forma aleatoria mediante una instancia de la
clase Random. Reescriba ahora su programa para realizar el producto de forma
paralela mediante concurrencia de hebras por implementacion de la interfaz
Runnable, utilizando tantos hilos como filas tenga la matriz. Guarde su trabajo
en matVectorConcurrente.java.
*/

public class matVector {
   public static void main(String []arg){
        Scanner entrada = new Scanner(System.in);
        int n, m, op;
        System.out.println("Introduzca las dimensiones de la matriz: ");
        n = entrada.nextInt();
        m = entrada.nextInt();
        int A[][] = new int[n][m];
        int b[] = new int[m];
        int sol[] = new int[n];
         
        System.out.println("1.Introducir datos manualmente");
        System.out.println("2.Introducir datos aleatoriamente");
        op = entrada.nextInt();
        switch(op){
            case 1:
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        System.out.println("Introduzca el valor de la posicion de la matriz ["+i+"]["+j+"]: ");
                        A[i][j] = entrada.nextInt();
                    }
                     
                }
                for(int k=0;k<m;k++){
                    System.out.println("Introduzca el  valor de la posicion "+k+" del vector: ");
                    b[k] = entrada.nextInt();
                }
                break;
                
            case 2:
                Random aleatorio=new Random();
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        A[i][j] = aleatorio.nextInt();
                    }
                     
                }
                for(int k=0;k<m;k++){
                    b[k] = aleatorio.nextInt();
                }
                break;
     
     
        }
        for(int k=0;k<n;k++){
        sol[k]=0;
        }
        Date d = new Date();
        long inicCronom = System.currentTimeMillis(); //Preparación del cronómetro
        d.setTime(inicCronom); //Activación del cronómetro
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            sol[i]=sol[i]+A[i][j]*b[j];
            } 
        }
        long finCronom = System.currentTimeMillis(); //Pausa cronómetro
        d.setTime(finCronom);
        System.out.println("Tiempo: "+ (finCronom - inicCronom) + " milisegundos");
        
        System.out.println("La matriz solucion es: ");
        for(int k=0;k<n;k++){
            System.out.println("(" + sol[k] + ")");
        }
        
    } 
}

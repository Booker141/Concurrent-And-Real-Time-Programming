
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

public class matVectorConcurrente implements Runnable {
    public  static int n, m, suma;
    public  int hilo;
    public  static int A[][];
    public  static int b[];
    public  static int sol[];
  
    public matVectorConcurrente(int tipohilo){
        hilo = tipohilo;
         
    }
    
    /**Función run
    *realiza las operaciones de multiplicar las filas de las que se encargan cada hilo por el vector
    */
    
    @Override
    public void run(){
    suma=0;
    for(int j=0;j<m;j++){
            suma=suma+A[hilo][j]*b[j];
            }
            sol[hilo]=suma;
    }
    
    /**Función main 
    Inicializa la matriz y el vector y crea un vector de hilos dependiendo del número de filas de la matriz
    *Muestra el tiempo que ha tardado en resolverlo en pantalla gracias al cronómetro implementado
    */
    public static void main(String []arg)throws Exception{
    Scanner entrada = new Scanner(System.in);
    int op;
    System.out.println("Introduzca las dimensiones de la matriz: ");
        n = entrada.nextInt();
        m = entrada.nextInt();
        A = new int[n][m];
        b = new int[m];
        sol = new int[n];
    System.out.println("1.Introducir datos manualmente");   /*El usuario deberá de meter los datos manualmente por teclado*/
    System.out.println("2.Introducir datos aleatoriamente"); /*El usuario no deberá meter los datos ya que se encarga de eso la clase Random*/
        op = entrada.nextInt();
        switch(op){
            case 1:  //Inicialización matriz
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        System.out.println("Introduzca el valor de la posicion de la matriz ["+i+"]["+j+"]: ");
                        A[i][j] = entrada.nextInt();
                    }
                     
                }
                for(int k=0;k<m;k++){ //Inicialización del vector a partir de la variable m introducida con anterioridad por el usuario
                    System.out.println("Introduzca el  valor de la posicion " + k + " del vector: ");
                    b[k] = entrada.nextInt();
                }
                break;
                
            case 2:   //Creación de objeto de la clase Random para crear valores aleatorios que ocuparán todas las posiciones de la matriz
                Random aleatorio = new Random();
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        A[i][j] = aleatorio.nextInt(); //Uso del objeto aleatorio para  lectura aleatoria
                    }
                     
                }
                for(int k=0;k<m;k++){
                    b[k] = aleatorio.nextInt();
                }
                break;
     
     
        }
         
        Date d = new Date();
        long inicCronom = System.currentTimeMillis(); //Preparación del cronómetro
        d.setTime(inicCronom); //Activación del cronómetro
        Thread h[] = new Thread[n];  //Creación del vector de hilos
        for(int i=0;i<n;i++){
            h[i] = new Thread(new matVectorConcurrente(i));
        }
        for(int i=0;i<n;i++){
        	h[i].start();
        }
        for(int i=0;i<n;i++){
            try{
            h[i].join();
            }catch(InterruptedException ie){}
        }
        long finCronom = System.currentTimeMillis(); //Pausa del cronómetro
        d.setTime(finCronom);
        System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
        System.out.println("La matriz solucion es: ");
        for(int k=0;k<n;k++){
            System.out.println("(" + sol[k] + ")");
        }
    }  
}

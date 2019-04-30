
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

public class UsaprodMatConcurrente {
   public static void main(String []arg)throws Exception{
        Scanner entrada = new Scanner(System.in);
        int n,m,tamano,suma, op;
        System.out.println("Introduzca las dimensiones de la matriz: ");
        n = entrada.nextInt();
        m = entrada.nextInt();
        System.out.println("Introduzca el numero de columnas de la segunda matriz: ");
        tamano = entrada.nextInt();
        int A[][] = new int[n][m];
        int b[][] = new int[m][tamano];
        int sol[][] = new int[tamano][n];
         
        System.out.print("1.Introducir los datos manualmente\n2.Introducir los datos de manera aleatoria\n");
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
        long inicCronom = System.currentTimeMillis(); //Preparacion cronometro
        d.setTime(inicCronom); //Activacion cronometro
        prodMatConcurrente Hilo[]=new prodMatConcurrente[n];
                for(int i=0;i<n;i++){
                    Hilo[i]=new prodMatConcurrente(A,b,n,m,tamano,i);
                    
                }
                for(int i=0;i<n;i++)Hilo[i].start();
                for(int i=0;i<n;i++){
                    try{
                    Hilo[i].join();
                    }catch(InterruptedException ie){}
                }
        long finCronom = System.currentTimeMillis(); //Pausa cronometro
        d.setTime(finCronom);
        System.out.println("Tiempo: "+ (finCronom - inicCronom) + " milisegundos");
    }
  
}

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

public class prodMatConcurrente extends Thread {
    public static int n, m, tamano;
    public  int tipohilo,suma;
    public static int A[][];
    public static int b[][];
    public static int sol[][];

    public prodMatConcurrente(int[][] A,int b[][],int n,int m,int tamano,int tipohilo){
    this.A = A;
    this.b = b;
    this.n = n;
    this.m = m;
    this.tamano = tamano;
    this.tipohilo=tipohilo;
    A = new int[n][m];
    b = new int[m][tamano];
    sol = new int[n][tamano];
    }
    
    @Override
    public void run( ){
    
    for(int j = 0; j < tamano; j++){
                suma = 0;
                for(int k = 0; k <m; k++){
                	
                    suma = suma + A[tipohilo][k] * b[k][j];
                	
                }
                
                sol[tipohilo][j] = suma;
            }
    
    }
     
 
}


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*3. Una solucion valida para el problema de la exclusion mutua con n procesos
es el algoritmo de la panaderia de Lamport. Escriba un programa algLamport.java que lo implemente para n procesos
utilizando objetos que implementen la interfaz Runnable y un ejecutor de tamao
fijo.*/

public class algLamport implements Runnable {
     private static volatile int rep = 10000;
    private static int[] v = new int[2];
    private static boolean[] vb = new boolean[2];
    private static volatile int n = 0;
    private int tipoHilo;
    
    public static void inicializar(){
    	for(int i=0;i<2;i++){
    		v[i]=0;
    		vb[i]=false;
    	}
    }
    /**
     * Constructor de la clase algoLamport
     * @param tipohilo sera 1 si el elemento comun se incrementa o 2 si el elemento comun se decrementa
     */
    public algLamport(int tipoHilo){
        this.tipoHilo = tipoHilo;
    }
    /**
     * Proceso del hilo
     */
     @Override
    public void run(){
    	for(int i=0;i<rep;i++){
    	vb[tipoHilo]=true;
    	v[tipoHilo]= 1+Math.max(v[0], v[1]);
    	vb[tipoHilo]=false;
    	for(int j=0;j<2;j++){
    		while(vb[j]);
    		while((v[j]!=0) && (v[j]<v[tipoHilo]));
    	}
        switch(tipoHilo){
            case 0:
                n++;
                break;
            case 1:
                n--;
                break;
        
    	}
        v[tipoHilo]=0;
    	}
    }
    /**
     * Funcion main que inicializa la clase y llama al ejecutor para iniciarla
     * @param arg
     * @throws Exception
     */
    public static void main(String []arg) throws Exception{
    	inicializar();
        ExecutorService exe= Executors.newCachedThreadPool();
        exe.execute(new algLamport(0));
        exe.execute(new algLamport(1));
        exe.shutdown();
         
        while(!exe.isTerminated()){}
        System.out.println(n);
    }
}

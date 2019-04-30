
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*2. Escriba un programa que implemente el Algoritmo de Eisenberg-McGuire
para dos procesos. Cree dos hilos (que deberan compartir las variables de control comunes y un re-
curso comun) por implementacion de la interfaz Runnable, y guarde su codigo
en algEisenbergMcGuire.java. Utilice un ejecutor de tamao fijo. Dedique un
apartado del documento analisis.pdf a este algoritmo que recoja el compor-
tamiento obtenido y su interpretacion del mismo*/

public class algEisenbergMcGuire implements Runnable {
    private static enum estados {Esperando,Ocioso,Activo};
	static estados est[] = new estados[2];
	private static volatile int rep = 100000;
	private static volatile int n = 0;
	private int tipoHilo;
	private static int turno = (int)Math.floor(Math.random()*(0-(+1))+(1));;
	private static volatile int i = 0;
	/**
	 * Constructor de la clase algEisenbergMcGuire
	 * @param tipohilo sera 1 si el elemento comun se incrementa o 2 si el elemento comun se decrementa
	 */
	public algEisenbergMcGuire(int tipohilo){
		this.tipoHilo = tipohilo;
	}
	/**
	 * Proceso del hilo
	 */
	public void run(){
		int index;
		do{
		est[tipoHilo]=estados.Esperando;
		index = turno;
		while(index != tipoHilo){
				if(est[index]!=estados.Ocioso)index=turno;
				else index=(index+1)%2;
		}
		
		est[tipoHilo] = estados.Activo;
		
		index = 0;
		while((index<2)&&((index==tipoHilo)||(est[index]!=estados.Activo)))index=index+1;
		}while((index<2)&&((turno==tipoHilo)||est[turno]==estados.Ocioso));
		turno = tipoHilo;
		switch(tipoHilo){
			case 0:
				n++;
			break;
			case 1:
				n--;
			break;
		}
		index = (turno+1)%2;
		while(est[index]==estados.Ocioso){
			index=(index+1)%2;
		}
		turno = index;
		est[tipoHilo] = estados.Ocioso;
	}
	/**
	 * Funcion main que inicializa los runnables y los ejecutas con el ejecutor
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String []arg) throws Exception{
		ExecutorService exe= Executors.newFixedThreadPool(2);
		exe.execute(new algEisenbergMcGuire(0));
		exe.execute(new algEisenbergMcGuire(1));
		exe.shutdown();
		
		while(!exe.isTerminated()){}
		System.out.println(n);
	}
}

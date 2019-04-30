
import java.util.concurrent.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

public class usalectorEscritor implements Runnable {
    
	private int tipohilo;
	static int n = 0;
	static lectorEscritor l = new lectorEscritor();
	public usalectorEscritor(int tipohilo){this.tipohilo = tipohilo;}
	public void run(){
		try{
		switch(tipohilo){
			case 0:
				for(int i=0;i<10;i++){
				l.leer_comienzo();
				System.out.println("Lector escribiendo n: " + n);
				l.leer_fin();
				}
				break;
			case 1:
				l.escribir_comienzo();
				n++;
				System.out.println("Escritor escribiendo n: " + n);
				l.escribir_fin();
				break;
		}
	}catch(Exception e){}

	}
	public static void main(String[] args)throws Exception {
		ExecutorService exe=Executors.newCachedThreadPool();	
		for(int i=0;i<10;i++){
			exe.execute(new usalectorEscritor(i%2));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);

	}
}

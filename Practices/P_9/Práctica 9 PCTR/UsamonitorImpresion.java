
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
public class UsamonitorImpresion implements Runnable {
    private final int numeroHilo;
 	private static final monitorImpresion monitor = new monitorImpresion();
 	public UsamonitorImpresion(int n){this.numeroHilo = n;}

    @Override
 	public void run(){
 		try{
 			int n;
 			n = monitor.take_print();
 			System.out.println("Imprimiendo el hilo " + numeroHilo + " en la impresora " + n);
 			monitor.drop_print(n);
 		}catch(Exception e){}
 	}
	/**
	*Metodo de Subramanian
	*@param Nn numero de nucleos 
	*@param Cb coeficiente de bloqueo
	*@return res numero de hilos a usar
	*/
	public static int Subramanian(int Nn,double Cb){
		double Nt;
		int res;
		Nt = (double)Nn/(1-Cb);
		System.out.println("Se ejecutaran " + Nt + " hilos");
		res = (int)Math.round(Nt);
		
		return res;
	}
        
 	public static void main(String[] args) throws Exception{
 	 int nhilos=Subramanian(Runtime.getRuntime().availableProcessors(),0.5);
 	 ExecutorService exe=Executors.newCachedThreadPool();
 	 for(int i=0;i<nhilos;i++){
 	 	exe.execute(new UsamonitorImpresion(i));
 	 }	
 	 exe.shutdown();
 	 exe.awaitTermination(1,TimeUnit.DAYS);
 	}

}

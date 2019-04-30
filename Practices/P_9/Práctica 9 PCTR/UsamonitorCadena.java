
import java.util.Random;
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

public class UsamonitorCadena implements Runnable {
        private double[][] Matriz = new double[10][10];
	private final Random random = new Random();
	static monitorCadena_1 buffer_1 = new monitorCadena_1(100);
	static monitorCadena_1 buffer_2 = new monitorCadena_1(50);
	private int tipoHilo;
	public UsamonitorCadena(int thilo){this.tipoHilo = tipoHilo;}

        @Override
	public void run(){
		double[][] auxiliar = new double[10][10];

		for(int z=0;z<150;z++){
		double solucion = 1;
		switch(tipoHilo){
			case 0:
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					Matriz[i][j]=(double)random.nextInt();

				}
			}
			buffer_1.insertar(Matriz);
			break;

			case 1:
			Matriz = buffer_1.extraer();
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					auxiliar[j][i] = Matriz[i][j];
				}
			}
			buffer_2.insertar(auxiliar);
			break;

			case 2:
			Matriz = buffer_2.extraer();
			for(int i=0;i<10;i++){
				solucion = solucion*Matriz[i][i];
			}
			System.out.println(solucion);
			break;
		}
	}
}
	public static void main(String[] args) throws Exception{
 	 ExecutorService exe=Executors.newFixedThreadPool(3);
 	 for(int i=0;i<3;i++){
 	 	exe.execute(new UsamonitorCadena(i));
 	 }	
 	 exe.shutdown();
 	 exe.awaitTermination(1,TimeUnit.DAYS);
 	}

}

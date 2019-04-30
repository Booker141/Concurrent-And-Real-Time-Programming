
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */
public class atomicServer implements Runnable {
    	AtomicInteger cont;
	static Date date = new Date();
	static long inicioCronom = System.currentTimeMillis();
        Socket enchufe;
 
    public atomicServer(Socket s){
    	enchufe = s; 	
    }

            @Override
    public void run()
    {
    try{
        
        BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
        String datos = entrada.readLine();
        int j;
        int i = Integer.valueOf(datos).intValue();
        cont.incrementAndGet();
        for(j=1; j<=20; j++){
        System.out.println("El hilo " + Thread.currentThread().getName() + " esta escribiendo el dato " + i);
         Thread.sleep(1000);
        }
        enchufe.close();
        System.out.println("El hilo " + Thread.currentThread().getName() + "cierra su conexion.");

		long finalCronom = System.currentTimeMillis(); //se para el cronometro
		date.setTime(finalCronom);
		System.out.println("Tiempo: " + (finalCronom - inicioCronom) + " milisegundos");
    } catch(Exception e) {System.out.println("Error...");}
    }

public static void main (String[] args)
{
    int i;
    int puerto = 2001;
        try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);
            ExecutorService exe = Executors.newCachedThreadPool();
            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                
                date.setTime(inicioCronom); //Activacion del cronometro
                System.out.println("Recibida solicitud de conexion.");
                exe.execute(new atomicServer(cable));
            }
        } catch (Exception e)
        {System.out.println("Error en sockets.");}
}

}

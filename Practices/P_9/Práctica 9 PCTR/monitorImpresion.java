/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */
public class monitorImpresion {
    	private static int impresoras, i;
 	private static boolean libre[] = new boolean[3];
        
 	public monitorImpresion(){
 		impresoras = 3;
 		for(int i=0;i<3;i++){
 			libre[i] = true;
 		}
 	}

 	synchronized int take_print()throws Exception{
 		int n;
 		while(impresoras == 0)wait();
 		impresoras--;
 		n = 0;
 		while(!libre[n])n++;
 		libre[n] = false;
 		return(n);
 	}

 	synchronized void drop_print(int n)throws Exception{
 		libre[n] = true;
 		impresoras++;
 		notifyAll();

 	}


}

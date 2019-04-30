
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

/*2. La tripulacion de un drakkar vikingo comparte una marmita con un almuerzo
a base de m anguilas cocinadas al eneldo. Cuando un vikingo quiere
comer, se sirve una anguila. Si ya no quedan, avisa al vikingo cocinero para
que proceda a llenar la marmita de nuevo, utilizando las inagotables provisiones
de anguilas disponibles. Desarrolle un programa en java que modele
esta curiosa situaci´on, y provea la sincronizacion necesaria utilizando metodos
synchronized y notificacion wait()-notifyAll(). Llame a su programa
drakkarVikingo.java.*/

public class drakkarVikingo implements Runnable{
    	private int tipohilo;
	static drakkar m = new drakkar();
	public drakkarVikingo(int n){this.tipohilo = n;}
	public void run(){
		try{
		switch(tipohilo){
			case 0:
				for(int i=0;i<10;i++){
					m.comer();
				}
			case 1:
				while(true){
					m.llenar();
				}
		}
	}catch(Exception e){}
}
        
	public static void main(String[] args) throws Exception{
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(new drakkarVikingo(1));//se llama al cocinero
		for(int i=0;i<10;i++){
			exe.execute(new drakkarVikingo(0));//se inician los vikingos
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);
	}
}
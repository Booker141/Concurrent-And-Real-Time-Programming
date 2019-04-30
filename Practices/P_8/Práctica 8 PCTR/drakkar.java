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
esta curiosa situaciÂ´on, y provea la sincronizacion necesaria utilizando metodos
synchronized y notificacion wait()-notifyAll(). Llame a su programa
drakkarVikingo.java.*/

public class drakkar {
    	static int marmita = 0;
	
	public drakkar(){
		marmita = 5;
	}

	public synchronized void comer()throws Exception{
		while(marmita==0){
			notifyAll();
			wait();
		}
		marmita--;
		System.out.println("¡Que rica la marmita" + marmita + "!");
	}

	public synchronized void llenar()throws Exception{
		while(marmita>0){
			wait();
		}
		marmita = 5;
		System.out.println("El cocinero rellena la olla");
		notifyAll();
	}
}

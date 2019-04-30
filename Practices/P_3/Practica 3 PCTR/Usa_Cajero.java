/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*5. Descargue ahora la clase Cuenta Banca2.java, disponible en la carpeta
de codigo Ejemplos de Clases en Java del Tema 2 del curso. Simule ahora
utilizando hilos mediante implementacion de la interfaz Runnable a una red de
cajeros automaticos, donde cada cajero realiza una operacion de ingreso o de
reintegro. Provoque ahora una condicion de concurso de los hilos contra una
instancia de la clase anterior, de forma que la suma neta de las operaciones
de todos ellos sea igual a 0. En esta situacion, el saldo inicial de la cuenta
deberıa haber permanecido constante. Compruebe que no tiene por que ser ası.
Llame a su clase Cajero.java y escriba una clase que simule la ejecucion de
los cajeros Usa_Cajero.java.*/

public class Usa_Cajero {
    /**Funcion main 
*inicia las hebras y al final imprime el saldo
     * @param arg
     * @throws java.lang.Exception
*/
public static void main(String []arg)throws Exception{
    Cajero a1=new Cajero(4530,1000,"Sergio",100,0);
    Cajero a2;
    a2 = new Cajero(4530,1000,"Sergio",100,1);
     
    new Thread((Runnable) a1).start();
    new Thread((Runnable) a2).start();
    new Thread((Runnable) a1).join();
    new Thread((Runnable) a2).join();
    System.out.println(a2.Saldo() );
     
}
}

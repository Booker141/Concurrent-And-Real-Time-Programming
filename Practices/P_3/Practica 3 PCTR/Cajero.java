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

public class Cajero implements Runnable {
    protected int CodigoCuenta;   //Codigo Cuenta Cliente
    protected String Titular;      //Titular de la Cuenta
    private double SaldoCuenta;   //Saldo Actual
    private final int tipohilo;
    private final double Cantidad;
    /**Creador de la clase Cajero
    *@param id numero de la cuenta
    *@param disponible saldo de la cuenta disponible
    *@param propietario Nombre de la persona propietaria de la cuenta
    *@param Cantidad Cantidad con la que va a operar para sumar o restar a su cuenta
    *@param tipohilo Tipo de hilo que si es 0 sumara la cantidad a su saldo, si es 1 restara la cantidad a su cuenta
    */
    public Cajero(int id, double disponible, String propietario, double Cantidad, int tipohilo)
    { CodigoCuenta=id;
      SaldoCuenta=disponible;
      Titular=propietario;
      this.tipohilo=tipohilo;
      this.Cantidad=Cantidad;
    }
    @Override
    public void run(){
    switch(tipohilo){
    case 0:
        SaldoCuenta=SaldoCuenta+Cantidad;
        break;
    case 1:
        if ((Cantidad >0)||(Cantidad<=SaldoCuenta))SaldoCuenta=SaldoCuenta-Cantidad;
        break;
     
    }
     
    }
    /**metodo observador Saldo
    *@return Saldo_Cuenta
    */
    public double  Saldo()
    {return (SaldoCuenta);}
    /**metodo observador Codigo
    *@return Codigo_Cuenta
    */
    public int Codigo ()
    {return (CodigoCuenta);}
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Se desea disponer de un sistema remoto para jugar a la BonoLoto.
El servidor genera aleatoriamente seis números entre 1 y 49 que deberán
ser acertados. Los clientes envían una apuesta al servidor con un array que
incluye los seis números que definen la apuesta. El servidor contesta al clien-
te si acertó o no con su apuesta. Implemente una arquitectura RMI que
permita jugar a la BonoLoto en red para estas especificaciones. Guarde su
interfaz en iBonoLoto.java y su servidor y cliente en cBonoLoto.java y
sBonoLoto.java.*/

import java.rmi.*;
public interface iBonoLoto
  extends Remote
{
  public void resetServidor() throws RemoteException;
  public boolean compApuesta(int[] apuesta)  throws RemoteException;

}
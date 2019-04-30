/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;

/**
 *
 * @author SERGIO
 */

/*3. Se desea efectuar el cálculo remoto de la aproximación a pi mediante
el ya conocido método de Monte-Carlo. Para desarrollar esta aproximación
distribuida, un cliente RMI enviará una petición remota al servidor que efec-
túa el cálculo, indicándole con cuántos puntos contribuye al mismo. Diferen-
tes cliente podrán, mediante sus respectivas llamadas al servidor, contribuir
a mejorar la aproximación remota, que sera única y de precisión crecien-
te. El servidor deberá ofrecer también un método de reset(), que cual-
quier cliente podrá invocar para reiniar el cálculo. Escriba una arquitetura
RMI completa con ficheros. iPiMonteCarlo.java, CPiMonteCarlo.java y
SPiMonteCarlo.java.*/

public interface iPiMonteCarlo extends Remote
{
  public void reset() throws RemoteException;
  public void masPuntos(int nPuntos) throws RemoteException;

}

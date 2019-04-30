
import java.io.*;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */
public class clienteMultiple {
        public static void main (String[] args)
    {	int j=0;
    	while(j<Integer.valueOf(args[0]).intValue()){
        int i = (int)(Math.random()*10);
        int puerto = 2001;
        try{
            System.out.println("Realizando conexion...");
            Socket cable = new Socket("localhost", 2001);
            System.out.println("Realizada conexion a " +  cable);
            PrintWriter salida = new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
            cable.getOutputStream())));
            salida.println(i);
            salida.flush();
            System.out.println("Cerrando conexion...");
            cable.close();

            }
                catch (Exception e)
        {System.out.println("Error en sockets...");}
        j++;
        }
    }
}

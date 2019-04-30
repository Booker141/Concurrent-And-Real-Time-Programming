
import java.util.Scanner;
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

/*1. Una base de datos de la DGT puede abstraerse de forma elegante mediante
un array de objetos de clase Conductor.java. Desarrolle una clase Conductores.java.
Como toda base de datos, sus elementos deben estar protegidos frente a transacciones
concurrentes sobre los mismos. Para lograr esto, determine un API de
la clase anterior cuyos metodos esten sincronizados y sus datos sean privados.
Escriba ahora un diseno de hilos que haga uso de la base de dato anterior en
usaConductores.java.*/

public class usaConductores implements Runnable {
    
	private int tipohilo;
	private static Conductores c = new Conductores();
	
	public usaConductores(int n){
            this.tipohilo = n;
        }

	public void run(){
		int opcion = 0;
		String nombre, dni, direccion, fechaNacimiento, compania;
		int tel;
		Scanner entrada = new Scanner(System.in);
		switch(tipohilo){

			case 0:
				System.out.println("Introduzca nombre: ");
				nombre = entrada.nextLine();
				System.out.println("Introduzca dni: ");
				dni = entrada.nextLine();
				System.out.println("Introduzca direccion: ");
				direccion = entrada.nextLine();
				System.out.println("Introduzca fecha de nacimiento: ");
				fechaNacimiento = entrada.nextLine();
				System.out.println("Introduzca compania: ");
				compania = entrada.nextLine();
				System.out.println("Introduzca telefono: ");
				tel = entrada.nextInt();
				Conductor p=new Conductor(nombre,dni,direccion,compania,fechaNacimiento,tel);
				c.introducirConductor(p);
			break;

			case 1:
				System.out.println("Introduzca DNI del conductor para borrarlo: ");
				dni = entrada.nextLine();
				c.borrarConductor(dni);
			break;

			case 2:
				System.out.println("1.-Buscar por dni");
                                System.out.println("2.-Buscar por nombre");
				opcion = entrada.nextInt();
				entrada.nextLine();
				switch(opcion){
					case 1:	System.out.println("Introduzca DNI: ");
						dni = entrada.nextLine();
						c.buscarConductor(dni,opcion);
						break;
					case 2: System.out.println("Introduzca nombre: ");
						nombre = entrada.nextLine();
						c.buscarConductor(nombre,opcion);
						break;
				}
			break;
		}

	}

	public static void main(String[] args)throws Exception {
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<3;i++){
			exe.execute(new usaConductores(i));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);
	}
}

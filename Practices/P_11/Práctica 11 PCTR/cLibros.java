
import java.rmi.Naming;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*2. Un servidor remoto de base de datos bibliotecarios se puede abstraer
razonablemente bien mediante un array de objetos de clase Libro.java en
combinación con la tecnología RMI. Escriba esa clase e implante su B.D.
con un array de objetos de la misma. Escriba ahora un servidor RMI en
java que permita a los clientes insertar y extraer información de la B.D. de
referencias bibliográficas. En concreto, los clientes deberían poder insertar,
extraer y consultar datos. Escriba una arquitectura RMI completa para re-
solver el problema. Guarde sus ficheros en iLibros.java, cLibros.java y
sLibros.java.*/

public class cLibros {
    
	public static void main(String []arg)throws Exception{
	
		Scanner teclado = new Scanner(System.in);
		iLibros RefORemoto = (iLibros)Naming.lookup("//localhost/servidor");
		int opcion = 10;
		
		while(opcion!=0){
			System.out.print("Menu\n1.Insertar libro\n2.Extraer libro\n3.Consultar datos\n0.Salir\n");
			opcion = teclado.nextInt();
			switch(opcion){
			case 1:
				String[] datos = new String[3];
				long isbn;
				System.out.println("Introduzca el nombre del libro: ");
				datos[0] = teclado.nextLine();
				datos[0] = teclado.nextLine();
				System.out.println("Introduzca el autor del libro: ");
				datos[1] = teclado.nextLine();
				System.out.println("Introduzca la editorial del libro: ");
				datos[2] = teclado.nextLine();
				System.out.println("Introduzca el isbn:");
				isbn = teclado.nextLong();
				RefORemoto.insertar(datos,isbn);
				
				break;
			case 2:
				
				String nombre;
				System.out.println("Introduzca el nombre del libro a extraer: ");
				nombre = teclado.nextLine();
				nombre = teclado.nextLine();
				RefORemoto.borrar(nombre);
				
				
				break;
			case 3:
                                String parametro;
				System.out.println("Introduzca un parametro para buscar en el libro");
				parametro = teclado.nextLine();
				parametro = teclado.nextLine();
				System.out.println(RefORemoto.consultar(parametro));
				break;
			}
		}
		
	}
}

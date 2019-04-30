
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.ReentrantLock;

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

public class sLibros extends iLibros {
    
	private final Libro[] BD = new Libro[100];
	private final ReentrantLock cerrojo = new ReentrantLock();
	public sLibros() throws RemoteException{}
	
        @Override
	public void insertar(String[] datos,long isbn)throws RemoteException{
		cerrojo.lock();
		try{
                    int i=0;
                while(BD[i]!=null){
		i++;
		}
		BD[i] = new Libro(datos[0],datos[1],datos[2],datos[3],isbn);
		System.out.println("Libro: " + BD[i].get_nombre() + " insertado");
		
		}finally{cerrojo.unlock();}
	}
	
	public String consultar(String parametro) throws RemoteException{
		
		
			
			int i=0;
			String datos="";
			try{
                            while(!(parametro.equals(BD[i].get_nombre())) && !(parametro.equals(BD[i].get_autor())) && !(parametro.equals(BD[i].get_editorial())) && !(parametro.equals(Long.toString(BD[i].get_isbn()))) && BD[i]!=null){
                                i++;
			}
			System.out.println("Se ha consultado el libro: " + BD[i].get_nombre());
			datos = "El titulo es: " + BD[i].get_nombre() + "\nEl autor es: " + BD[i].get_autor() + "\nLa editorial es: " + BD[i].get_editorial() + "\nISBN: " + Long.toString(BD[i].get_isbn()) + "\n";
			}catch(java.lang.NullPointerException e){
			datos="Error Libro no encontrado";
			return datos;
			
			return datos;
			
		
	
	}

        @Override
	void borrar() throws RemoteException{
		cerrojo.lock();
			int i=0;
			try{
			while(!(nombre.equals(BD[i].get_nombre()))){
				i++;
			}
			System.out.println("Se ha extraido el libro: " + BD[i].get_nombre());
			BD[i].set_nombre(null);
			BD[i].set_autor(null);
			BD[i].set_editorial(null);
			BD[i].set_isbn(0);
			}catch(java.lang.NullPointerException e){System.out.println("Han intentado borrar un libro que no existe");}
			finally{cerrojo.unlock();}
		
	}
	public static void main(String []arg)throws Exception{

		iLibros ORemoto = new sLibros();
		Naming.bind("servidor",ORemoto);
		System.out.println("Servidor remoto listo...");
		
		
	}
	
	
}

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

public class Libro {
    
    	public String nombre, autor, editorial;
	public int isbn;
	
	public Libro(String nombre,String autor,String editorial,int isbn){
		this.nombre = nombre;
		this.autor = autor;
                this.editorial = editorial;
		this.isbn = isbn;
	}
	

}

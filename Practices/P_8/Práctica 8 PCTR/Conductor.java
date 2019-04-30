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

public class Conductor {
    	private String nombre, dni, direccion, compania,fechaNacimiento;
	private int telefono;
        
	//Constructores
        
	public Conductor(){}
	public Conductor(String nombre,String dni,String direccion,String compania,String fnac,int tel){
		this.nombre=nombre;
		this.dni=dni;
		this.direccion=direccion;
		this.compania=compania;
		this.fechaNacimiento=fechaNacimiento;
		this.telefono = telefono;
	}
        
	//Observadores
        
	public String getnombre(){return nombre;}
	public String getdni(){return dni;}
	public String getdireccion(){return direccion;}
	public String getcompania(){return compania;}
	public String getfnac(){return fechaNacimiento;}
	public int gettelefono(){return telefono;}
	
        //Modificadores

	public void setdireccion(String direccion){this.direccion = direccion;}
	public void setcompania(String compania){this.compania = compania;}
	public void settelefono(int tel){this.telefono = tel;}
	
	public String toString(){
		return "Nombre: " + nombre + "\nDni: " + dni + "  Fecha de nacimiento: " + fechaNacimiento + "\nDireccion: " + direccion + "\nCompania: " + compania + "\nTel: " + telefono + "\n";
	}
	
	
	
}

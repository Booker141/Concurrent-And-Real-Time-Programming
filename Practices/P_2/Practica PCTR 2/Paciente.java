/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Escriba una clase en java para modelar la entidad Paciente (de una consulta
medica), y que considere al menos los atributos siguientes: nombre, dni, direcci
on, telefono y compania de seguros. Guarde su trabajo en Paciente.java. Modele
ahora una consulta abstrayendola como una coleccion de paciente. Disene
un menu de usuario que permite insertar, borrar y consultar pacientes utilizando
diferentes parametros de busqueda. Guarde su trabajo en Biblioteca.java*/

public class Paciente {
    
    private String nombre,dni,direccion,compania,fnac;
	private int tel;
	//Constructores
	
	public Paciente(String nombre,String dni,String direccion,String compania,String fnac,int tel){
		this.nombre=nombre;
		this.dni=dni;
		this.direccion=direccion;
		this.compania=compania;
		this.fnac=fnac;
		this.tel=tel;
	}
	//Observadores
	public String getnombre(){return nombre;}
	public String getdni(){return dni;}
	public String getdireccion(){return direccion;}
	public String getcompania(){return compania;}
	public String getfnac(){return fnac;}
	public int gettelefono(){return tel;}
	//modificadores

	public void setdireccion(String direccion){this.direccion=direccion;}
	public void setcompania(String compania){this.compania=compania;}
	public void settelefono(int tel){this.tel=tel;}
	
	public String toString(){
		return "Nombre: " + nombre + "\nDni: " + dni + "  Fecha de nacimiento: " + fnac + "\nDireccion: " + direccion + "\nCompania: " + compania + "\nTel: " + tel + "\n";
	}
}

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

public class resImagen {
    static int tamano = 20000;
	static int imagen[][]=new int[tamano][tamano];
	public static void operar(){
		int ianterior,janterior;
		for(int i=0;i<tamano;i++){
			for(int j=0;j<tamano;j++){
				ianterior=i-1;
				janterior=j-1;
				if(janterior<0)janterior = tamano-1;
				if(ianterior<0)ianterior = tamano-1;
				imagen[i][j]=(4*imagen[i][j]-imagen[(i+1)%tamano][j]-imagen[i][(j+1)%tamano]-imagen[ianterior][j]-imagen[i][janterior])/8;
			}
		}
	}
        
	public static void iniciarImagen(){
		Random aleatorio = new Random();
		for(int i=0;i<tamano;i++){
			for(int j=0;j<tamano;j++){
				imagen[i][j]=aleatorio.nextInt(20);
			}
		}
	}
        
	public static void imprimir(){
		for(int i=0;i<tamano;i++){
			for(int j=0;j<tamano;j++){
				System.out.print(" " + imagen[i][j] + " ");
			}
			System.out.println();
		}
	}
        
	public static void main(String[] args) {
		iniciarImagen();
		System.out.println("Imagen inicial: ");
		imprimir();
		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); //Preparacion del cronometro
		d.setTime(inicCronom); //Activacion del cronometro
		operar();
		long finCronom = System.currentTimeMillis(); //Pausa del cronometro
		d.setTime(finCronom);
		System.out.println("Imagen modificada: ");
		imprimir();
		System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
	}

}

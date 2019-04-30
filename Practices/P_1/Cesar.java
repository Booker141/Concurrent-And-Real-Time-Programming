/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author SERGIO
 */

/*5. El cifrado de Cesar es una tecnica elemental de ocultamiento de la informacion
que matematicamente se describe de forma simple utilizando la siguiente
ecuacion:

E(x) = x + n mod 27

donde x es la letra que queremos cifrar (representada por su codigo ASCII o
por cualquier otra ordenacion valida) y n es un numero que se suma a ese
codigo. Escriba un programa Cesar.java que lea el valor de n, una cadena
de texto cualquiera, y muestre en pantalla su representacion cifrada. Escriba
otro programa llamado desCesar.java que efectue el descifrado de acuerdo a
la siguiente ecuacion:

D(k) = k - n mod 27*/   

public class Cesar {
    
	public static String cifrar(String c,int n){
            
		char aux[]=new char[c.length()];
		int letra;
		for(int i=0;i<c.length();i++){
			letra = c.codePointAt(i);
			if(letra!=32)
			if(letra>90){
				letra =(((letra-97)+n)%26)+97;
			}
			else{
                            letra =(((letra-65)+n)%26)+65;
			}
			aux[i]=(char)letra;
			
		}
			
		String fin = new String(aux);
		return fin;
	}
        
	public static void main(String[] args) {
            
		String cadena;
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca la cadena a cifrar: ");
		cadena = scan.nextLine();
		
		System.out.println("Introduzca un valor n para el cifrado cesar: ");
		n = scan.nextInt();
	
		System.out.println("Cadena cifrada: " + cifrar(cadena,n) );
	}

}
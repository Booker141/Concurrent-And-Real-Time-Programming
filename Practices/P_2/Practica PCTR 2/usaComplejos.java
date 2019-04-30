
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
public class usaComplejos {
    /**Funcion principal
* Recibe por taclado los numeros complejos y llama a las funciones de los complejos
     * @param args
*/
 
public static void main(String args[]){
    
Scanner entrada = new Scanner(System.in);
int op;
double numeroreal,numeroImaginario;
Complejos num1,num2;
System.out.print("Menu\n1.Suma de Complejos\n2.Resta de Complejos\n3.Modulo del complejo\n4.Producto de complejo\n5.Cociente de complejo\n");
System.out.println("Introduce el numero de la operacion: ");
op=entrada.nextInt();

switch(op){
    case 1:
        System.out.println("introduzca el numero real del primer complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del primer complejo: ");
        numeroImaginario=entrada.nextDouble();
        num1=new Complejos(numeroreal,numeroImaginario);
        System.out.println("introduzca el numero real del segundo complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del segundo complejo: ");
        numeroImaginario=entrada.nextDouble();
        num2=new Complejos(numeroreal,numeroImaginario);
        System.out.println(num1.suma(num2));
    break;
 
    case 2:
        System.out.println("introduzca el numero real del primer complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del primer complejo: ");
        numeroImaginario=entrada.nextDouble();
        num1=new Complejos(numeroreal,numeroImaginario);
        System.out.println("introduzca el numero real del segundo complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del segundo complejo: ");
        numeroImaginario=entrada.nextDouble();
        num2=new Complejos(numeroreal,numeroImaginario);
        System.out.println(num1.resta(num2));
    break;
 
    case 3:
        System.out.println("introduzca el numero real del  complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del complejo: ");
        numeroImaginario=entrada.nextDouble();
        num1=new Complejos(numeroreal,numeroImaginario);
        System.out.println("El modulo es: "+num1.modulo());
    break;
 
    case 4:
        System.out.println("introduzca el numero real del  complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del complejo: ");
        numeroImaginario=entrada.nextDouble();
        num1=new Complejos(numeroreal,numeroImaginario);
        System.out.println("Introduzca el valor por el que multiplicar: ");
        numeroreal=entrada.nextDouble();
        System.out.println(num1.producto(numeroreal));
    break;
 
    case 5:
 
        System.out.println("introduzca el numero real del  complejo: ");
        numeroreal=entrada.nextDouble();
        System.out.println("introduzca el numero imaginario del complejo: ");
        numeroImaginario=entrada.nextDouble();
        num1=new Complejos(numeroreal,numeroImaginario);
        System.out.println("Introduzca el valor por el que dividir: ");
        numeroreal=entrada.nextDouble();
        System.out.println(num1.cociente(numeroreal));
    break;
 
 
}
 
}
}

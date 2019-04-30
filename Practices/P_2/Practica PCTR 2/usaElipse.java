
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

/*5. Elabore una clase para abstraer el concepto matematico de elipse llamada
Elipse.java. Ademas de los modificadores y observadores habituales, dotela
de metodos para saber si un punto pertenece o no a una elipse dada. Escriba un
programa llamada usaElipse.java que cree y utilice algunas instancias de la
clase. Elabores tambien un pequeno documento (recuerde que debe desarro-
llar el document con WriteLatex) llamado elipse.pdf, que debera incluir
una descripcion de la ecuacion que define a este conica, una descripcion textual,
y una imagen de ejemplo.*/

public class usaElipse {
    /**Funcion principal que utiliza el objeto Elipse y calcula si un punto esta dentro o no
     * @param arg
*/
public static void main(String []arg){
         
double f1,f2,longitud,altura,l1,l2;
Scanner S=new Scanner(System.in);
System.out.println("Introduzca la longitud y la altura de la elipse: ");
longitud=S.nextDouble();
altura=S.nextDouble();
Elipse E;
E = new Elipse(longitud,altura);
l1=E.get_longx();
l2=E.get_longy();
f1=E.get_x()-E.focos(l1,l2);
f2=E.get_x()+E.focos(l1,l2);
System.out.println("Introduzca las dos coordenadas del punto:");
longitud=S.nextDouble();
altura=S.nextDouble();
if(E.comprobar(f1,f2,longitud,altura)==2*E.get_longx()){
System.out.println("El punto se encuentra en la elipse");
}
else {System.out.println("El punto no pertenece a la elipse");}
}
}

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

public class Elipse {
         
private static double x=0,y=0,longx,longy;
     
public Elipse(){}
public Elipse(double longx, double longy){
Elipse.longx=longx;
Elipse.longy=longy;
}
/**Funcion observadora cordenada x del centro de la elipse
*@return double
*/
public double get_x(){
return x;
}
/**Funcion observadora cordenada y del centro de la elipse
*@return double
*/
public double get_y(){
return y;
}
public double get_longx(){
return longx;
}
public void set_longx(double longx){
Elipse.longx=longx;
}
public double get_longy(){
return longy;
}
public void set_longy(double longy){
Elipse.longy=longy;
}
 
/** Calcula el foco de la Elipse
*@param longx Double
*@param longy Double
*@return double
*/
public  double focos(double longx,double longy){
double foco,lx,ly;
lx=Math.pow(longx,2);
ly=Math.pow(longy,2);
foco=(Math.sqrt(lx-ly));
return foco;
}
/** comprueba si el punto esta dentro de la elipse
*@param f1 foco 1 de la elipse
*@param f2 foco 2 de la elipse
*@param n1 coordenada x del punto
*@param n2 coordenada y del punto
*@return double
*/
public double comprobar(double f1, double f2, double n1, double n2){
double modulo1,modulo2,modulo;
modulo1=Math.sqrt(Math.pow((n1-f1),2)+Math.pow(n2,2));
modulo2=Math.sqrt(Math.pow((n1-f2),2)+Math.pow(n2,2));
modulo=modulo1+modulo2;
return modulo;
}
   
}

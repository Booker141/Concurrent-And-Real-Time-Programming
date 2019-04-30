/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Utilice la clase Punto.java que tiene disponible en la carpeta de la practica
para escribir una clase Poligono.java.*/

public class Punto {
  double x, y; // Variables de instancia

  public Punto(double x, double y) { // Constructor
    this.x= x; this.y= y;
  }
  public void moverEn(double dx, double dy) { 
    this.x+= dx; this.y+= dy;
  }
  public String toString() { 
    return "("+this.x+","+this.y+")";
  }
}

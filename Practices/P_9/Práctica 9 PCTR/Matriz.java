/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*Implementacion Matriz*/

class Matriz {
    
	public double[][] matriz = new double[10][10];
	public Matriz(double[][] mat){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				matriz[i][j]=mat[i][j];
			}
		}
	
	}
}

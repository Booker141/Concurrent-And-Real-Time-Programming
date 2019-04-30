
import java.util.*;
import java.util.concurrent.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

public class matVectSubramanian implements Runnable {
    public  static int n, m, suma;
	private  int hilo;
	public	static int A[][];
	public 	static int b[];
	public  static int sol[];
	/**Constructor de la clase runnable
	*@param tipohilo contiene la fila que multiplicara ese hilo 
	*/
	public matVectSubramanian(int tipohilo){
		hilo = tipohilo;
		
	}
	/**Funcion run
	*realiza las operacio de multiplicar las filas de los hilos por la matriz columna
	*/
    @Override
	public void run(){
	suma = 0;
	for(int j=0;j<m;j++){
			suma = suma+A[hilo][j]*b[j];
			}
			sol[hilo] = suma;
	}
	
	public static int Subramanian(int Nn, double cb){
		double Nt;
		int res;
		Nt=(double)Nn/(1-cb);
		System.out.println("se ejecutaran " + Nt + " Hilos");
		res = (int)Math.round(Nt);
		
		return res;
	}
        
	/**Funcion main 
	 Inicializa la matriz y el vector y crea un vector de hilos dependiendo del nÃºmero de filas de la matriz
         Muestra el tiempo que ha tardado en resolverlo en pantalla gracias al cronÃ³metro implementado*/
        
	public static void main(String []arg)throws Exception{
	Scanner entrada = new Scanner(System.in);
	int op;
	int Nt;
	
	System.out.println("Introduzca las dimensiones de la matriz: ");
		n = entrada.nextInt();
		m = entrada.nextInt();
		A = new int[n][m];
		b = new int[m];
		sol = new int[m];
		int nProc = Runtime.getRuntime().availableProcessors();
		Nt = Subramanian(nProc, 0.5);
                System.out.println("1.Introducir datos manualmente");   /*El usuario deberÃ¡ meter los datos manualmente por teclado*/
                System.out.println("2.Introducir datos aleatoriamente"); /*El usuario no deberÃ¡ meter los datos ya que se encarga de eso la clase Random*/
		op = entrada.nextInt();
		switch(op){
			case 1: //InicializaciÃ³n matriz
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						System.out.println("Introduzca el valor de la posicion de la matriz ["+i+"]["+j+"]: ");
						A[i][j] = entrada.nextInt();
					}
					
				}
				for(int k=0;k<m;k++){   //InicializaciÃ³n del vector a partir de la variable m introducida con anterioridad por el usuario
					System.out.println("Introduzca el  valor de la posicion " + k + " del vector: ");
					b[k] = entrada.nextInt();
				}
				break;
			case 2: //CreaciÃ³n de objeto de la clase Random para crear valores aleatorios que ocuparÃ¡n todas las posiciones de la matriz
				Random aleatorio=new Random();
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						A[i][j] = aleatorio.nextInt();    //Uso del objeto aleatorio para  lectura aleatoria
					}
					
				}
				for(int k=0;k<m;k++){
					b[k] = aleatorio.nextInt();
				}
				break;
	
	
		}
		
		
		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); //Preparacion del cronometro
		d.setTime(inicCronom); //Activacion del cronometro
		ExecutorService exe= Executors.newFixedThreadPool(Nt);
		for(int i=0;i<n;i++){
			exe.execute(new matVectSubramanian(i));
			
		}
		exe.shutdown();
		while(!exe.isTerminated()){}
		long finCronom = System.currentTimeMillis(); //Pausa del cronometro
		d.setTime(finCronom);
		System.out.println("Tiempo: "+ (finCronom - inicCronom) + " milisegundos");
		System.out.println("La matriz solucion es: ");
		for(int k=0;k<n;k++){
			System.out.println("(" + sol[k] + ")");
		}
	
	}
}


package algoritmo_burbuja;

import java.util.Random;

class burbuja {

	int [] randomarray = null;
	int pos1;
	int pos2;
	boolean ascendente;


	public static void main (String args []) {
		long inicio = System.nanoTime();
		burbuja abc = new burbuja();
		abc.crearArray();
		abc.mostrar();
		long fin = System.nanoTime();
		double dif = (double)(fin - inicio)*1.0e-9;
		System.out.println("el programa dura"+ dif +"s");
		
	}
	
	public burbuja() {
	}
	
	
	public void crearArray() {
		int numeros=10000;
		
		randomarray = new int [20];
		for (int i=0; i<randomarray.length ; i++) {
			Random rando = new Random();
			int numerosrandom = rando.nextInt(numeros +1);
			randomarray[i]= numerosrandom;
		}
	}
	private void intercambiarPosiciones(int pos1, int pos2) {
		int aux;
		aux= randomarray[pos2];
		randomarray[pos2]=randomarray[pos2 +1];
		randomarray[pos2 +1]= aux;
	}
	
	
	public void ordenador(boolean ascendente) {
		if (ascendente == true) {
			for(pos2 = 0; pos2<randomarray.length - pos1; pos2 ++) {
				if (randomarray[pos2]<randomarray[pos2+1]) {
					intercambiarPosiciones(pos1, pos2);
				}
			}
		}else
			for(pos2 = 0; pos2<randomarray.length - pos1; pos2 ++) {
				if (randomarray[pos2]>randomarray[pos2+1]) {
					intercambiarPosiciones(pos1, pos2);
				}
			}
			
	}
	public void mostrar() {
		int i;
		System.out.println("Array desordenado: \t");
		for(i=0; i<randomarray.length ; i++) {
			System.out.println(randomarray[i] + ",");
		}
		System.out.println("\nArray ordenado de menor a mayor\t");
		for (pos1 = 1; pos1< randomarray.length+1; pos1++) {
			ordenador(true);
			System.out.println(randomarray[pos2]+",");
		}
		System.out.println("\nArray ordenado de mayor a menor\t");
		for (pos1 = 1; pos1< randomarray.length+1; pos1++) {
			ordenador(false);
			System.out.println(randomarray[pos2]+",");
		}
	}
}

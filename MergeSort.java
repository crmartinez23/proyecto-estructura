import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	static long inicio = System.nanoTime();
	 public static void main(String args[]){
       int x=1000;
		 int vec[]=new int [x];
        for (int i=0;i<x;i++) {
        	vec[i]=(int)(Math.random()*10000000+5);
        	
        }
        long fin = System.nanoTime();
		double dif = (double)(fin - inicio)*1.0e-9;
		System.out.println("el programa dura"+ dif +"s");
         System.out.println("\nVector original\t");
        // imprimirVector(vec);
         System.out.println("\nVector ordenado\t");
         ordenacionMergeSort(vec);
         //imprimirVector(vec);
 }
 
 public static void ordenacionMergeSort(int vec[]){
         if(vec.length<=1) return;
         int mitad= vec.length/2;
         int izq[]=Arrays.copyOfRange(vec, 0, mitad);
         int der[]=Arrays.copyOfRange(vec, mitad, vec.length);
         ordenacionMergeSort(izq);
         ordenacionMergeSort(der);       
         combinarVector(vec, izq, der);
 }
 
 public static void combinarVector(int v[], int izq[],int der[]){
         int i=0;
         int j=0;
         for(int k=0;k<v.length;k++){
                 if(i>=izq.length){
                         v[k]=der[j];
                         j++;
                         continue;
                 }
                 if(j>=der.length){
                         v[k]=izq[i];
                         i++;
                         continue;
                 }
                 if(izq[i]<der[j]){
                         v[k]=izq[i];
                         i++;
                 }else{
                         v[k]=der[j];
                         j++;
                 }
         }
 }
 
 public static void imprimirVector(int vec[]){
         for(int i=0;i<vec.length;i++){
                 System.out.print(vec[i]+" ");
         }
         
 }
 
	
}

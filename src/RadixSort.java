/**
 * Importaciones
 */
import java.util.*;
/**
 * Clase para el ordenamiento de los documentos por tamaño.
 * @author Mario
 *
 */
public class RadixSort {
	/**
	 * Método para obtener el máximo valor del array.
	 * @param arr
	 * @param n
	 * @return
	 */
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    /**
     * Método para harcer el ordenamiento de acuerdo con el digito representado por el exponente.
     * @param arr
     * @param n
     * @param exp
     */
    static void countSort(int arr[], int n, int exp){
    	/**
    	 * Array de salida.
    	 */
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
        /**
         * almacenar la cuenta de ocurrencias en count[].
         */
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
        /**
         * Cambiar el count[i] para que el count[i]
         * ahora contenga la posición real de este dígito en output[]
         */
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        /**
         * Creaión del array de salida.
         */
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        /**
         * Copiar el array output en arr[] de modo que arr[]
         * ahora contenga los numeros ordenados de acuerdo al digito actual.
         */
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    /**
     * Método principal para ordenar el array de tamaño n.
     * @param arr
     * @param n
     */
    static void radixsort(int arr[], int n){
    	/**
    	 * encontrar el máximo número para saber el numero de digitos
    	 */
        int m = getMax(arr, n);
        /**
         * Hacer un conteo por cada dígito.
         */
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    /**
     * Método para imprimir el array.
     * @param arr
     * @param n
     */
    static void print(int arr[], int n)
    {
    	System.out.print("[");
        for (int i=0; i<n; i++) {
            System.out.print(arr[i]+", ");
        }System.out.print("]");
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
    //////////////////////////////////////////////////////////////////////////////////////////
}
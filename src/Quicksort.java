/**
 * Clase para el ordenamiento de los archivos de la biblioteca por nombre de forma alfabética.
 * @author Mario
 */
public class Quicksort{
    private String[] nombres;
    private int number;
    /**
     * Método para ordenar por nombres los archivo de la biblioteca.
     * @param nombres // lista de nombres de los archivos de la biblioteca.
     * @return // retorna el array ordenado.
     */
    public String[] ordenar(String[] nombres) {
        /**
         * Verifica si el array esta vacío.
         */
        if (nombres == null || nombres.length==0){
            return nombres;
        }
        this.nombres = nombres; // nombres es la lista
        /**
         * Sacamos longitud de lista.
         */
        number = nombres.length; 
        /**
         * Llamar metodo para ordenar.
         */
        quicksort(0, number - 1); 
	return nombres;
    }
    
    private void quicksort(int low, int high) {
        int i = low, j = high;
        String pivot = nombres[low + (high-low)/2];        
        while (i <= j) {
            /**
             * Se compara cada string dentro de la lista de nobres con el pivote que tambien es string.
             * Si el resultado es -1 entonces es menor que el pivote.
             */
            while (nombres[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            /**
             * Si el resultado es 1 entonces es mayor qu el pivote.
             */
            while (nombres[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            /**
             * Este if se corre cuando las 2 anteriores no se cumplan.
             */
            if (i <= j) { 
                /**
                 * Llama amétodo cambiar.
                 */
                cambio(i, j);
                i++; // aumentamos el valor de i
                j--; // aumentamos el valor de j
            }
        }
        /**
         * estos if se corre cuando i>j.
         */
        if (low < j) {
            /**
             * Se llama a quick sort de nuevo para ordenar la parte izquierda de la lista.
             */
            quicksort(low, j);
        }
        if (i < high) {
            /**
             * Se llama a quick sort de nuevo para ordenar la parte derecha de la lista.
             */
            quicksort(i, high);
        }
    }
    /**
     * Método realiza el cambio de los valores.
     * @param i // posición a cambiar.
     * @param j // posición a cambiar.
     */
    private void cambio(int i, int j) {
        String temp = nombres[i];
        nombres[i] = nombres[j];
        nombres[j] = temp;
    }    
}
/**
 * Clase para el ordenamiento de los documentos por nombre.
 * @author Mario
 *
 */
public class Quicksort{
	
    private String[] nombres;
    private int number;
    /**
     * M�todo para verificar si una palabra es mayor o menor que el pivote.
     * @param nombres // Array con lo nombres del archivo.
     * @return // Retorna el array ordenado alfab�ticamente.
     */
    public String[] ordenar(String[] nombres) {
    	/**
    	 * Se verifica is el array est� vac�o.
    	 */
        if (nombres == null || nombres.length==0){
            return nombres;
        }
        this.nombres = nombres;
        /**
         * Obtenemos la longitud de la lista.
         */
        number = nombres.length;
        /**
         * Llamamos el m�todo para ordenar el array.
         */
        quicksort(0, number - 1); // llamar metodo
		return nombres;
    }
    /**
     * M�todo que ordena el array con los nombres de los documentos
     * @param low // Es el valor m�nimo del array.
     * @param high // Es el m�ximo valor del array.
     */
    private void quicksort(int low, int high) {
        int i = low, j = high;
        /**
         * Se establece el valor del pivote para hacer las comparaciones.
         */
        String pivot = nombres[low + (high-low)/2]; 
        /**
         * Ciclo se encarga de validar si la posici�n i es menor que el pivote o la posici�n j es mayor que el pivote,
         * si no es as�, se procede a hacer el intercambio.
         */
        while (i <= j) {
        	/**
        	 * Se compara cada string dentro de la lista de nobres con el pivote.
        	 * Si el resultado es -1 entonces es menor que el pivote.
        	 */
            while (nombres[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            /**
             * Si el resultado es 1 entonces es mayor que el pivote.
             */
            while (nombres[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            /**
             * Esta condici�n se ejecuta cuando las 2 anteriores no se cumplan, y llama al m�todo cambiar
             */
            if (i <= j) {
                cambio(i, j);
                i++;
                j--;
            }
        }
        /**
         * Estas condiciones se ejecutan cuando i>j
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
     * M�todo se encarga de hacer el intercambio de valores de la lista.
     * @param i
     * @param j
     */
    private void cambio(int i, int j) {
        String temp = nombres[i];
        nombres[i] = nombres[j];
        nombres[j] = temp;
    }    
}


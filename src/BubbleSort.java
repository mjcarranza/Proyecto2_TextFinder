/**
 * Clase para el ordenamiento de los archivos de la biblioteca por fecha de manera
 * que se muestren primero los archivos recientemente creados.
 * @author Mario
 */
public class BubbleSort {
    /**
     * Método para relizar el ordenamiento de los archivos por fechas.
     * @param array // lista de fechas.
     * @return // retorna la lista ordenada.
     */
    public static String[] bubble_srt(String array[]) {
        int n = array.length;
        int k;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].compareToIgnoreCase(array[k]) < 0) {
                    String temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        /**
         * Se retorna el array ordenado.
         */
        return array;
    }
}
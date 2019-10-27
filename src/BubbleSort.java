/**
 * Clase para el ordenamiento de los documentos por fecha de modificación.
 * @author Mario
 *
 */
public class BubbleSort {
	/**
	 * Método para el ordenamiento del array.
	 * @param array
	 */
    public static void bubble_srt(String array[]) {
        int n = array.length;
        int k;
        /**
         * Ciclo for para comparar n veces
         */
        for (int m = 0; m < n; m++) {
        	/**
        	 * Cilclo for para comparar 2 datos dentro del array
        	 */
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                /**
                 * Si array[i] es menor que array[j], se hace el cambio,
                 * si no lo es, continúa con las comparaciones
                 */
                if (array[i].compareToIgnoreCase(array[k]) < 0) {
                    String temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
            
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        printStr(array);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    } // dejar este de cierre
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void printStr(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        String[] input = { "2008-10-04", "2008-10-04", "2016-06-19", "2019-12-19" }; // formato necesario para la fecha: YYYY/MM/DD
        bubble_srt(input);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
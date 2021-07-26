package MinHeap;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestCostoMinimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        
        Se tiene n cuerdas de diferentes longitudes y se pide unirlas en una sola con el costo minimo.
        El costo de unir dos cuerdas es igual a la suma de sus longitudes.

        Por ejemplo, si nos dan 4 cuerdas de longitud 4, 3, 2 y 6. Podemos unir las cuerdas de la siguiente manera.
        1) Primero, unir las cuerdas de longitud 2 y 3. Ahora se tiene tres cuerdas de longitud 4, 6 y 5.
        2) Luego unir las cuerdas de longitud 4 y 5. Ahora se tiene dos cuerdas de longitud 6 y 9.
        3) Finalmente, unir las dos cuerdas faltantes.
        
        El costo total para conectar todas las cuerdas es 5 + 9 + 15 = 29
        
        Otra forma de unir las cuerdas siempre tendría el mismo costo o superior.
        Por ejemplo, si se une primero 4 y 6 (se obtienen tres cuerdas de 3, 2 y 10),
        luego unir 10 y 3 (se obtiene dos cuerdas de 13 y 2).
        Finalmente se une 13 y 2.
        El costo total de esta manera es 10 + 13 + 15 = 38.
        
        Considere obligatoriamente para su solución el uso de un Heap (de Mínimos o Máximos)
        el tamaño de n (la cantidad de cuerdas) es siempre mayor o igual a 2
        
        */
        
        //Conectar las cuerdas con un costo minimo
        int arr[] = {4, 3, 2, 6};
        System.out.println("El costo minimo es: " + costoMinimo(arr));
    }
    
    public static int costoMinimo(int cuerdas[]){
        int costo = 0;
 
        MinHeap minHeap = new MinHeap(cuerdas.length);
        for(int i=0; i<cuerdas.length; i++) {
            minHeap.insert(cuerdas[i]);
        }

        while (minHeap.size() > 1) {
            int minimo     = minHeap.extractMin();
            int segundoMenor = minHeap.extractMin();

            costo += (minimo + segundoMenor);

            minHeap.insert(minimo+segundoMenor);
        }

        // Retorna el costo total
        return costo;
    }
    
}

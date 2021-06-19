package MaxHeap;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        //Set de datos
        int[] arrElementos = {30, 48, 15, 67, 24, 17, 5, 38, 53, 70};

        /*
        Cuando el Heap se encuentra vacio y se van agregando los elementos uno a uno.
        Notar que el Heap se va nivelando inmediatamente a medida que se insertan.
        */
        //Se crea el heap del tamaño del set de datos
        MaxHeap maxHeap = new MaxHeap(arrElementos.length);
        //Se insertan los puntos
        for(int i=0; i<arrElementos.length; i++) {
            maxHeap.insert(arrElementos[i]);
        }
        
        System.out.println("El Max-Heap es (version arbol): ");
        maxHeap.print();
        
        System.out.println("\nEl Max-Heap es (version arreglo): ");
        maxHeap.showArray();
        
        //Un MaxHeap puede aprovecharse para ordenar los elementos de menor a mayor
        // en O(n log n). Notar que al aplicar el HeapSort, la estructura(el arreglo)
        // deja de poseer la calidad de MaxHeap y la unica forma para volver a
        // es calidad es reconstruyendose de nuevo.
        System.out.println("\nEl Heap de menor a mayor es: ");
        //Se aplica Heap sort para ordenar los elementos del arreglo
        maxHeap.heapSort();
        maxHeap.showArray();
    }
}

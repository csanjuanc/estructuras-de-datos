package MinHeap;

/**
 *
 * @author csanjuan
 */
public class TestMinHeap {
    public static void main(String[] args) {
        
        //Caso 1:
        //Cuando el Heap se encuentra vacio y se van agregando los elementos uno a uno.
        //El Heap se va nivelando inmediatamente a medida que se insertan.
        /*MinHeap minHeap = new MinHeap(7);
        
        minHeap.insert(30);
        minHeap.insert(48);
        minHeap.insert(15);
        minHeap.insert(67);
        minHeap.insert(24);
        minHeap.insert(17);
        minHeap.insert(5);
        
        minHeap.printTree();
        minHeap.showArray();*/
        
        
        //Caso 2: 
        //Cuando el arreglo ya esta lleno y se arma el Heap
        int arr[] = {30, 48, 15, 67, 24, 17, 5};
        MinHeap minHeap2 = new MinHeap(arr);
        minHeap2.printTree();
        minHeap2.showArray();
        
        System.out.println("\nAplicando Heap Sort");
        minHeap2.heapSort();
        minHeap2.showArray();
    }
}

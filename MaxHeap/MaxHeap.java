package MaxHeap;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize];
    }
    
    public MaxHeap(int[] arr) {
        this.size = arr.length;
        //Se recibe el arreglo y se asigna al heap
        heap = arr;
        
        //Se construye el heap
        BuildHeap();
    }

    public void insert(int dato) {
        if(size == heap.length) {
            throw new IllegalStateException("Min-Heap lleno");
        }else {
            int posActual = size;
            //Se inserta el elemento en el arreglo
            heap[posActual] = dato;
            //Incrementa el contador
            size++;

            while (heap[posActual] > heap[parent(posActual)]) {
                Intercambia(posActual, parent(posActual));
                posActual = parent(posActual);
            }
        }
    }

    public void BuildHeap() {
        for (int i = size/2; i >= 0; i--) {
            Heapify(i, size - 1);
        }
    }
    
    public void heapSort() {
        for (int i = heap.length - 1; i >= 0; i--) {
            Intercambia(0, i);
            Heapify(0, i - 1);
        }
    }

    public void print() {
        for (int i = 0; i < size/2; i++) {
            try{
                System.out.print(" PADRE : " + heap[i]);
            }catch(Exception e) {
                System.out.println("");
            }
            
            try{
                System.out.print(" HIJO IZQ : " + heap[leftChild(i)]);
            }catch(Exception e) {
                System.out.println("");
            }
            
            try{
                System.out.print(" HIJO DER :" + heap[rightChild(i)]);
            }catch(Exception e) {
                System.out.println("");
            }
            System.out.println();    
        }
    }
    
    public void showArray() {
        System.out.println("--Inicio--");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + "|");
        }
        System.out.println();
        System.out.println("--Fin--");
    }
    
    private void Heapify(int i, int j) {
        if ((leftChild(i)) <= j) {
            //k almacena la posicion
            int k;
            if ((rightChild(i)) <= j) {
                k = (heap[rightChild(i)] >= heap[leftChild(i)]) ? rightChild(i) : leftChild(i);
            } else {
                k = leftChild(i);
            }
            if (heap[i] < heap[k]) {
                Intercambia(i, k);
                Heapify(k, j);
            }
        }
    }
    
    private void Intercambia(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int pos) {
        return ((pos - 1) / 2);
    }

    private int leftChild(int pos) {
        return ((2 * pos) + 1);
    }

    private int rightChild(int pos) {
        return ((2 * pos) + 2);
    }
}

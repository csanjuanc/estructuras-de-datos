/**
 *
 * @author csanjuan
 */
public class MinHeap {
    private int[] heap;
    private int size;//Cantidad de elementos del Heap

    //Constructor para crear Heap vacio
    public MinHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize];
    }
    
    //Constructor para crear Heap a partir de un arreglo de numeros
    public MinHeap(int[] arr) {
        this.size = arr.length;
        //Se recibe el arreglo y se asigna al heap
        heap = arr;
        
        //Se construye el heap
        buildHeap();
    }
    
    //Retorna la cantidad de elementos que tiene el Min-Heap
    public int size(){
        return size;
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

            while (heap[posActual] < heap[parent(posActual)]) {         //        30
                Intercambia(posActual, parent(posActual));              //      /    \
                posActual = parent(posActual);                          //     48     15
            }
        }
    }

    public void buildHeap() {
        for (int i = size/2; i >= 0; i--) {
            Heapify(i, size - 1);
        }
    }
    
    private void Heapify(int i, int j) {
        //Comprueba que el hijo izq de la posicion i sea un valor menor o igual a j
        if ((leftChild(i)) <= j) {
            //k almacena la posicion del valor que tiene que subir
            int k;
            //Si el hijo der de i es menor q j significa que tiene que elegir el mayor de los dos hijos
            if ((rightChild(i)) <= j) {
                //Se elige la pos que tiene el valor mayor
                if(heap[rightChild(i)] <= heap[leftChild(i)]) {
                    k = rightChild(i);
                }else {
                    k = leftChild(i);
                }
            } else {//Significa que solo tiene hijo izquierdo
                k = leftChild(i);
            }
            //Revisa si es mayor, se hace el intercambio para armar nuevamente el min-heap
            if (heap[i] > heap[k]) {
                Intercambia(i, k);
                Heapify(k, j);
            }
        }
    }
    
    //Retorna el menor valor del Min-Heap asumiendo que existe
    public int getMin() {
        return heap[0];
    }
    
    //Extrae el menor elemento del Min-Heap y lo retorna
    public int extractMin() {
        if (heap.length == 0) {
            throw new IllegalStateException("MinHeap vacio");
        } else if (heap.length == 1) {
            int min = heap[0];
            heap[0] = 0;//Se borra el elemento con un cero
            size--;//Se decrementa el tamanyo del heap
            return min;
        }
        
        int min = heap[0];//Se guarda el minimo en una variable
        heap[0] = heap[size-1];//Se intercambia el ultimo por el primer elemento
        heap[size-1] = 0;//Se borra el ultimo elemento del heap con un cero
        size--;//Se decrementa el tamanyo del heap

        //Se rearma el heap
        Heapify(0, size - 1);

        // return min key
        return min;
    }
    
    //Cambia el valor de la posicion i del arreglo, por la de j
    private void Intercambia(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //Dada la posicion de un nodo, devuelve la posicion de su nodo padre
    private int parent(int pos) {
        return ((pos - 1) / 2);
    }

    //Dada la posicion de un nodo, devuelve la posicion de su hijo izquierdo
    private int leftChild(int pos) {
        return ((2 * pos) + 1);
    }

    //Dada la posicion de un nodo, devuelve la posicion de su hijo derecho
    private int rightChild(int pos) {
        return ((2 * pos) + 2);
    }
    
    public void showArray() {
        System.out.println("--Inicio--");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + "|");
        }
        System.out.println();
        System.out.println("--Fin--");
    }

    public void printTree() {
        for (int i = 0; i < Math.ceil(size/2); i++) {
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
    
    //Desarma el heap para dejar el arreglo ordenado de mayor a menor
    public void heapSort() {
        for (int i = heap.length - 1; i > 0; i--) {
            Intercambia(0, i);
            Heapify(0, i - 1);
        }
    }
}

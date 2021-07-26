package MaxHeap;

/*
Definicion del problema

Dado un arreglo de numeros enteros, se necesita revisar si estos representan
(por su orden en el arreglo) un MaxHeap.
Una solucion simple es revisar si la raiz es mayor que todos sus hijos. Luego,
revisar que los hijos de la raiz sea mayor a todos sus decendientes y repetir el proceso.
La complejidad temporal de esta solución es O(n^2)

Para este ejercicio se pide realizar una solucion recursiva que permita responder en O(n).
Para ello, solo compare la raiz con su hijo izquierdo y derecho (no todos los hijos descendientes),
si la raiz es mayor que ambos hijos y lo mismo es cierto para todos los nodos de forma
recursiva, entonces el arbol es un MaxHeap.

PD: Los tildes se han quitado a proposito para evitar errores de compilacion.
*/

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestIsMaxHeap {
    public static void main(String[] args) {
        /*************************** IMPORTANTE *******************************/
        /************************** NO MODIFICAR ******************************/
        int arr[] = {17, 67, 48, 30, 70, 53, 15, 24, 38, 5};
        
        //Revisa si el arreglo es un MaxHeap. Debe mostrar que no lo es
        isHeapRecursivo(arr);
        //Lo comprueba con la version iterativa
        isHeapIterativo(arr);
        
        //Transforma el arreglo a un MaxHeap
        MaxHeap heap = new MaxHeap(arr);
        heap.showArray();
        arr = heap.getHeap();
        
        //Revisa si el arreglo es un MaxHeap. Ahora debe mostrar que si lo es
        isHeapRecursivo(arr);
        //Lo comprueba con la version iterativa
        isHeapIterativo(arr);
    }
    
    public static void isHeapRecursivo(int arr[]) {
        if (isHeap(arr, 0, (arr.length-1))) { 
            System.out.println("Es un MaxHeap"); 
        }else { 
            System.out.println("No es un MaxHeap"); 
        }
    }
    
    //Parametros
    //int arr[]: el arreglo de numeros
    //int i: valor del indice inicial a evaluar
    //int n: valor del indice final a evaluar
    private static boolean isHeap(int arr[], int i, int n) {
        // Si es un nodo hoja  
        if (i > (n - 2) / 2) { 
            return true; 
        }
        
        // Si es un nodo interno y es mas grande que sus hijos (y recursivamente para sus hijos)
        return (arr[i] >= arr[leftChild(i)]
                && arr[i] >= arr[rightChild(i)]
                && isHeap(arr, leftChild(i), n)
                && isHeap(arr, rightChild(i), n)); 
    }
    
    public static void isHeapIterativo(int arr[]) {
        if (isHeap(arr, 0)) { 
            System.out.println("Es un MaxHeap (Iterativo)"); 
        }else { 
            System.out.println("No es un MaxHeap (Iterativo)"); 
        }
    }
    
    //Metodo iterativo para determinar si es un MaxHeap
    private static boolean isHeap(int arr[], int n) { 
        //Empieza en la la raiz y va revisando todos sus hijos 
        for (int i = 0; i <= (n) / 2; i++) { 
            // Retorna falso si el hijo izquierdo es mayor a su padre
            if (arr[leftChild(i)] > arr[i]) { 
                return false; 
            } 
   
            // Retorna falso si el hijo derecho es mayor a su padre
            if (rightChild(i) < n && arr[rightChild(i)] > arr[i]) { 
                return false; 
            } 
        } 
        return true; 
    }
    
    private static int leftChild(int pos) {
        return ((2 * pos) + 1);
    }

    private static int rightChild(int pos) {
        return ((2 * pos) + 2);
    }
}

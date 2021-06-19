package ABB_con_peso;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class ABB {

    NodoABB root;

    /***************************************************************************/
    /******************************* INSERTAR **********************************/
    public void insertar(int key) {
        root = insertarR(key, root);
    }

    // Metodo privado que inserta de forma recursiva los nodos en el arbol
    // Notar que no se pueden ingresar claves duplicadas
    private NodoABB insertarR(int key, NodoABB nodo) {
        if (nodo == null) {
            return new NodoABB(key);
        }

        //Navega por el arbol dependiendo del valor de key
        if (key < nodo.key) {
            nodo.leftChild = insertarR(key, nodo.leftChild);
        } else if (key > nodo.key) {
            nodo.rightChild = insertarR(key, nodo.rightChild);
        }
        
        //Actualizacion del peso
        nodo.peso = 1 + obtienePeso(nodo.leftChild) + obtienePeso(nodo.rightChild);

        return nodo;
    }
    
    private int obtienePeso(NodoABB nodo) {
        if (nodo == null)
            return 0;
 
        return nodo.peso;
    }

    public void kesimo(int k) {
        int kesimo = buscarKesimo(root, k);
        if(kesimo != -1) {
            System.out.println("El K-esimo " + k + " es: " + kesimo);
        }else {
            System.out.println("K-esimo no encontrado");
        }
    }
    
    private int buscarKesimo(NodoABB nodoActual, int k) {
        int resultado = -1;//Por defecto entrega -1 si no tiene k-esimo
 
        //Itera mientras el nodo exista
        while(nodoActual != null) {
            if( calcularPosicion(nodoActual) == k ) {
                //K-esimo encontrado
                resultado = nodoActual.key;
                break;
            }else if( k > calcularPosicion(nodoActual) ) {
                //Actualiza el kesimo descartando las posiciones del nodo actual
                k = k - calcularPosicion(nodoActual);
                //El kesimo esta en el subarbol derecho
                nodoActual = nodoActual.rightChild;
            }else {
                //El kesimo esta en el subarbol izquierdo
                nodoActual = nodoActual.leftChild;
            }
        }

        return resultado;
    }
    
    private int calcularPosicion(NodoABB nodoActual) {
        if(nodoActual.leftChild != null) {
            //Ya que tiene hijo izquierdo, se obtiene su peso y se agrega uno
            return nodoActual.leftChild.peso + 1;
        }else if(nodoActual.rightChild != null){
            //Ya que tiene hijo derecho, se debe calcular la diferencia
            return (nodoActual.peso - nodoActual.rightChild.peso);
        }else {
            //Es una hoja
            return nodoActual.peso;
        }
    }

    /***************************************************************************/
    /************************** MOSTRAR ARBOL **********************************/
    // Note que el arbol impreso esta girando en -90 grados, es decir,
    // la raiz sera el primera elemento mas a la izquierda de la consola, siendo su
    // hijo izquierdo el valor de abajo y el derecho el valor superior del siguiente tab
    public void imprimirArbol() {
        imprimir(root, 0);
    }
    
    private void imprimir(NodoABB nodo, int depth) {
        if (nodo.rightChild != null) {
            imprimir(nodo.rightChild, depth+1);
        }
        for (int i = 0; i < depth; i++) {
                System.out.print("    ");
        }
        System.out.println("("+nodo.key+")");

        if (nodo.leftChild != null) {
            imprimir(nodo.leftChild, depth+1);
        }
    }
}

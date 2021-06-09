package ABB;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class ABB {
    private NodoABB root;

    /***************************************************************************/
    /******************************* INSERTAR **********************************/
    public void insertar(int key) {
        root = insertarR(key, root);
    }

    // Metodo privado que inserta de forma recursiva los nodos en el arbol
    private NodoABB insertarR(int key, NodoABB nodo) {
        if (nodo == null) {
            return new NodoABB(key);
        }

        //Navega por el arbol dependiendo del valor de key
        if (key < nodo.key) {
            nodo.leftChild = insertarR(key, nodo.leftChild);
        } else if(key > nodo.key){
            nodo.rightChild = insertarR(key, nodo.rightChild);
        }
        
        return nodo;
    }
    
    /***************************************************************************/
    /******************************* ELIMINAR **********************************/
    public void eliminar(int key) {
        root = borrar(root, key);
    }
 
    private NodoABB borrar(NodoABB nodo, int key) {
        if (nodo == null){
            return nodo;
        }
 
        if (key < nodo.key){
            nodo.leftChild = borrar(nodo.leftChild, key);
        }else if (key > nodo.key){
            nodo.rightChild = borrar(nodo.rightChild, key);
        }else {
            //Caso cuando hijo izq no existe, se devuelve el hijo der
            if (nodo.leftChild == null){
                return nodo.rightChild;
            //Caso cuando hijo der no existe, se devuelve el hijo izq
            } else if (nodo.rightChild == null){
                return nodo.leftChild;
            }
            
            nodo.key = buscarMin(nodo.rightChild);
            nodo.rightChild = borrar(nodo.rightChild, nodo.key);
        }
 
        return nodo;
    }
    
    /***************************************************************************/
    /************************** MOSTRAR POR NIVEL ******************************/
    public void imprimirPorNivel() {
        NodoABB Nodo = root;
        Cola cola = new Cola(); // Se declara una variable "cola" de tipo "Cola" y se crea la instancia por default.
        NodoABB tmp = null; // Se declara una variable "tmp" (temporal) de tipo "Nodo" con valor inicial de "null".

        if (Nodo != null) {
            cola.encolar(Nodo); // Se hace una llamada al método "InsertarFinal" pasando como parámetro, el parámetro "Nodo"(RAIZ), como primer nodo en la cola.
            while (!(cola.estaVacia())) {
                tmp = cola.desencolar(); // Se le asigna a "tmp" el elemento extraído de la cola.
                System.out.print(tmp.key + " "); // Se imprime en pantalla.

                if (tmp.leftChild != null) {
                    cola.encolar(tmp.leftChild);
                }
                if (tmp.rightChild != null) {
                    cola.encolar(tmp.rightChild);
                }
            }
        }
    }

    /***************************************************************************/
    /******************************* IN ORDER **********************************/
    public void imprimirInOrder() {
        inOrder(root);
    }
    
    private void inOrder(NodoABB focusNode) {
        if (focusNode != null) {
            inOrder(focusNode.leftChild);
            System.out.print(focusNode);
            inOrder(focusNode.rightChild);
        }
    }

    /***************************************************************************/
    /******************************* PRE ORDER *********************************/
    public void imprimirPreOrder() {
        preOrder(root);
    }
    
    private void preOrder(NodoABB focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode);
            preOrder(focusNode.leftChild);
            preOrder(focusNode.rightChild);
        }
    }

    /***************************************************************************/
    /******************************* POST ORDER ********************************/
    public void imprimirPostOrder() {
        postOrder(root);
    }
    
    private void postOrder(NodoABB focusNode) {
        if (focusNode != null) {
            postOrder(focusNode.leftChild);
            postOrder(focusNode.rightChild);
            System.out.print(focusNode);
        }
    }

    /***************************************************************************/
    /******************************* BUSCAR ************************************/
    public NodoABB buscarElemento(int key) {
        NodoABB nodoActual = root;

        while (nodoActual.key != key) {
            if (key < nodoActual.key) {
                nodoActual = nodoActual.leftChild;
            } else {
                nodoActual = nodoActual.rightChild;
            }

            if (nodoActual == null) {
                return null;
            }
        }
        
        return nodoActual;
    }
    
    /***************************************************************************/
    /******************************* BUSCAR MIN ********************************/
    //Busca el valor minimo del arbol
    public int buscarMin() {
        return buscarMin(root);
    }
    
    //Busca el valor minimo dado un nodo
    private int buscarMin(NodoABB nodoActual) {
        while (nodoActual.leftChild != null) {
            nodoActual = nodoActual.leftChild;
        }

        return nodoActual.key;
    }

    /***************************************************************************/
    /******************************* BUSCAR MAX ********************************/
    public int buscarMax() {
        return buscarMax(this.root);
    }
    
    private int buscarMax(NodoABB nodoActual) {
        while (nodoActual.rightChild != null) {
            nodoActual = nodoActual.rightChild;
        }

        return nodoActual.key;
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
        //System.out.println();
        if (nodo.leftChild != null) {
            imprimir(nodo.leftChild, depth+1);
        }
    }
}

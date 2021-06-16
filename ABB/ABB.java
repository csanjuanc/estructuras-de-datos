package ABB;

import java.util.Stack;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class ABB {
    private NodoABB root;
    
    public boolean isEmpty() {
        return (root == null);
    }
    
    public void insertarIterativo(int key) {
        NodoABB nodo = new NodoABB(key);

        if (isEmpty()) {
            root = nodo;
        } else {
            NodoABB nodoActual = root;
            NodoABB nodoPadre;

            while(true) {
                nodoPadre = nodoActual;

                if (key < nodoActual.key) {
                    nodoActual = nodoActual.leftChild;

                    if (nodoActual == null) {
                        nodoPadre.leftChild = nodo;
                        return;
                    }
                } else {
                    nodoActual = nodoActual.rightChild;

                    if (nodoActual == null) {
                        nodoPadre.rightChild = nodo;
                        return;
                    }
                }
            }
        }
    }

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
    
    public void preOrderIterativo() {
        // Base Case
        if (root == null) {
            return;
        }

        //Se crea una pila (Clase Stack) como estructura auxiliar
        Stack<NodoABB> pila = new Stack<NodoABB>();
        pila.push(root);

        while (!pila.empty()) {
            NodoABB nodoActual = pila.pop();
            System.out.print(nodoActual.key + ", ");

            if (nodoActual.rightChild != null) {
                pila.push(nodoActual.rightChild);
            }
            if (nodoActual.leftChild != null) {
                pila.push(nodoActual.leftChild);
            }
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
    /****************************** PREDECESOR *********************************/
    public void predecesor(int numero) {
        NodoABB nodoActual = buscarElemento(numero);

        if (nodoActual.leftChild != null) {
            System.out.println("El predecesor de " + numero + " es: " + buscarMax(nodoActual.leftChild));
        }
        // INCOMPLETO !!!
        //Falta hacer el caso el nodo no tiene hijos, por lo tanto el antecesor es el padre del nodo
    }
    
    /***************************************************************************/
    /********************************* SUCESOR *********************************/

    public void sucesor(int numero) {
        NodoABB nodoActual = buscarElemento(numero);

        if (nodoActual.rightChild != null) {
            //Se busca el menor del hijo derecho
            System.out.println("El sucesor de " + numero + " es: " + buscarMin(nodoActual.rightChild));
        } else {
            //se busca el padre o la raiz dependiendo el nodo hoja (izq o der)
            System.out.println("El sucesor de " + numero + " es: " + buscaSucesorPadre(numero));
        }
    }

    public int buscaSucesorPadre(int key) {
        NodoABB actual = root;
        NodoABB elPadre = null;

        if (actual.key == key) {
            //No tiene padre
            elPadre = null;
        } else {
            //Se busca en el arbol el padre
            while (actual.key != key) {
                if (key < actual.key) {
                    elPadre = actual;
                    actual = actual.leftChild;
                } else {
                    elPadre = actual;
                    actual = actual.rightChild;
                }

                if (actual == null) {
                    elPadre = null;
                }
            }
        }

        //Revisa si es el hijo izquierdo
        if (elPadre.leftChild.key == key) {
            //Es el hijo izquierdo, el padre es el sucesor
            return elPadre.key;
        } else {
            return root.key;
        }
    }
    
    /***************************************************************************/
    /*********************** ANCESTRO COMUN MAS BAJO ***************************/
    public void ancestro(int n1, int n2){
        NodoABB ancestro = ancestroCMB(root, n1, n2);
        
        if(ancestro == null) {
            System.out.println("No existe el ancestro comun mas bajo");
        }else {
            System.out.println("El ancestro comun mas bajo es: " + ancestro.key);
        }
    }
    
    private NodoABB ancestroCMB(NodoABB node, int n1, int n2) { 
        if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.key > n1 && node.key > n2) 
            return ancestroCMB(node.leftChild, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.key < n1 && node.key < n2)  
            return ancestroCMB(node.rightChild, n1, n2); 
   
        return node; 
    }
    
    /***************************************************************************/
    /**************************** BUSCAR MAS CERCANO ***************************/
    public int buscarCercano(int target) {
        // Initialize minimum difference
        int min_diff = Integer.MAX_VALUE;
        int min_diff_key = -1;

        return buscarMasCercano(root, target, min_diff, min_diff_key);
    }
    
    private int buscarMasCercano(NodoABB nodo, int objetivo, int diferenciaActual, int menorValor) {
        if (nodo == null) {
            return menorValor;
        }

        if (nodo.key == objetivo) {
            return objetivo;
        }

        if (Math.abs(nodo.key - objetivo) < diferenciaActual) {
            diferenciaActual = Math.abs(nodo.key - objetivo);
            menorValor = nodo.key;
        }

        if (objetivo < nodo.key) {
            return buscarMasCercano(nodo.leftChild, objetivo, diferenciaActual, menorValor);
        }else {
            return buscarMasCercano(nodo.rightChild, objetivo, diferenciaActual, menorValor);
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
        //System.out.println();
        if (nodo.leftChild != null) {
            imprimir(nodo.leftChild, depth+1);
        }
    }
}

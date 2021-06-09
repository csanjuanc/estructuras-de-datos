package ArbolGeneral;

import java.util.StringTokenizer;

public class ArbolNario {

    private NodoArbol root;

    public ArbolNario() {
        root = null;
    }
    
    public boolean Agregar(String elPath, String elDato) {
        // Si root es null, entonces esta vacio
        if (root == null) {
            // Constructor pide solo el dato. El hijo y el hermano quedan en null
            root = new NodoArbol(elDato);
            return true;
        } else { // Busco el nodo segun la ruta dada
            // buscaNodo encuentra el nodo donde se debe agregar el nuevo dato
            NodoArbol tmp = buscaNodo(elPath);
            if (tmp == null) {// Si no encuentra la ruta especificada (tmp = null) entonces no se agrega
                return false;
            } else {// Significa que se ha encontrado el nodo, entonces se agrega
                return AgregaHijo(tmp, elDato);
            }
        }
    }
    
    private NodoArbol buscaNodo(String elPath) {
        NodoArbol tmp1 = root;
        NodoArbol tmp2 = tmp1;
        // Separa la ruta en tokens
        StringTokenizer path = new StringTokenizer(elPath, "/");
        String token;
        // Busca cada nodo por token existente
        while (path.hasMoreTokens()) {
            token = path.nextToken();
            // Se buscan coincidencias con los hermanos
            while (tmp1 != null) {
                if (token.equalsIgnoreCase((String) tmp1.getDato())) {
                    // Si el token coincide con el nodo, ha sido encontrado
                    break;
                } else {
                    tmp1 = tmp1.getHermano();
                    tmp2 = tmp1;
                }
            }
            if (tmp1 == null) {
                // No hay coincidencias, se retorna null
                return tmp1;
            }else {
                // Sigue buscando por los hijos
                tmp2 = tmp1;
                tmp1 = tmp1.getHijo();
            }
        }
        return tmp2;
    }
    
    private boolean AgregaHijo(NodoArbol elPadre, String elDato) {
        // Se obtiene el hijo del nodo recibido (elPadre)
        NodoArbol tmp = elPadre.getHijo();
        
        // Si tmp (hijo) = null, entonces no existe un hijo y se agrega directamente
        if (tmp == null) {
            elPadre.setHijo(new NodoArbol(elDato, null, null));
            return true;
        }else {// Existe un hijo, se debe agregar como hermano
            // Se pregunta por el hermano de tmp, si es nulo entonces
            // no tiene hermanos, se agrega directamente
            if(tmp.getHermano() == null){
                tmp.setHermano(new NodoArbol(elDato, null, null));
            }else {// Ya tiene hermanos
                NodoArbol hermanoTmp = tmp.getHermano();
                // Se avanza hasta encontrar el ultimo hermano
                while(hermanoTmp.getHermano() != null){
                    hermanoTmp = hermanoTmp.getHermano();
                }
                hermanoTmp.setHermano(new NodoArbol(elDato, null, null));
            }
            
            return true;
        }
    }
    
    public void Imprimir() {
        imprime(root, " ");
    }
    
    private void imprime(NodoArbol r, String tab) {
        if (r != null) {
            System.out.println(tab + r.getDato());
            imprime(r.getHijo(), tab + "   ");
            imprime(r.getHermano(), tab);
        }
    }
    
    public int totalNodos() {
        // Utiliza el metodo cuentanodos y le envia la raiz
        // asi cuenta todos los nodos existentes en el arbol
        return cuentanodos(root);
    }
    
    //Cuenta los nodos del sub-arbol recibido
    private int cuentanodos(NodoArbol n) {
        if (n != null) {
            return 1 + cuentanodos(n.getHijo()) + cuentanodos(n.getHermano());
        } else {
            return 0;
        }
    }
    
    public int cuentaHojas() {
        return cuentaHojasRecursivo(root);
    }
    
    private int cuentaHojasRecursivo(NodoArbol n) {
        if (n == null) {
            return 0;
        } else if (n.getHijo() == null) {
            return 1 + cuentaHojasRecursivo(n.getHermano());
        } else {
            return (cuentaHojasRecursivo(n.getHijo()) + cuentaHojasRecursivo(n.getHermano()));
        }
    }
    
    public void mostrarPreorder() {
        preorderRecursivo(root);
    }
    
    public void mostrarInorder() {
        inorder(root);
    }
    
    public void mostrarPostorder() {
        postorder(root);
    }
    
    private void preorderRecursivo(NodoArbol n) {
        if (n != null) {
            System.out.print(" - " + n.getDato());
            preorderRecursivo(n.getHijo());
            preorderRecursivo(n.getHermano());
        }
    }
    
    private void postorder(NodoArbol n) {
        if (n != null) {
            for (NodoArbol t = n.getHijo(); t != null; t = t.getHermano()) {
                postorder(t);
            }
            System.out.print("-" + n.getDato());
        }
    }

    private void inorder(NodoArbol n) {
        if (n != null) {
            inorder(n.getHijo());
            System.out.print("-" + n.getDato());
            NodoArbol t = n.getHijo();
            while (t != null) {
                t = t.getHermano();
                inorder(t);
            }
        }
    }
    
    int numeroApariciones(String s) {
        return cuentaApariciones(root, s);
    }

    private int cuentaApariciones(NodoArbol n, String s) {
        if (n != null) {
            int c = 0;
            if (s.equals(n.getDato())) {
                c++;
            }
            return c + cuentaApariciones(n.getHijo(), s) + cuentaApariciones(n.getHermano(), s);
        } else {
            return 0;
        }
    }
    
    //Un arbol trinario es cuando cada nodo tiene a lo mas 3 hijos
    public boolean esTernario() {
        return ternario(root);
    }

    private boolean ternario(NodoArbol n) {
        if (n == null) {
            return true;
        } else {
            NodoArbol t = n.getHijo();
            int h = 0;
            while (t != null) {
                t = t.getHermano();
                if (++h > 3) {
                    return false;
                }
            }
            return ternario(n.getHermano()) && ternario(n.getHijo());
        }
    }
}

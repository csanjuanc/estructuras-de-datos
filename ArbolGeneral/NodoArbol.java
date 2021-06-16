package ArbolGeneral;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class NodoArbol {
    //De tipo Object para poder almacenar cualquier informacion
    private Object dato;
    private NodoArbol hijo;
    private NodoArbol hermano;
    
    // Constructor basico de un Nodo sin hijos ni hermanos (pero con el dato)
    public NodoArbol(Object elDato) {
        dato = elDato;
        hijo = null;
        hermano = null;
    }

    // Constructor con los 3 parametros
    public NodoArbol(Object elDato, NodoArbol elHijo, NodoArbol elHermano) {
        dato = elDato;
        hijo = elHijo;
        hermano = elHermano;
    }
    
    public Object getDato() {
        return dato;
    }
    
    public void setDato(Object elDato) {
        dato = elDato;
    }
    
    public NodoArbol getHijo() {
        return hijo;
    }
    
    public void setHijo(NodoArbol elHijo) {
        hijo = elHijo;
    }
    
    public NodoArbol getHermano() {
        return hermano;
    }
    
    public void setHermano(NodoArbol elHermano) {
        hermano = elHermano;
    }
}

package HashTable_SeparateChaining;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class NodoLista {
    NodoLista siguiente;
    int data;

    /* Constructor */
    public NodoLista(int x) {
        data = x;
        siguiente = null;
    }
}

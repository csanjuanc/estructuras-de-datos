package ABB_con_peso;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class NodoABB {

    NodoABB leftChild;
    int key;
    NodoABB rightChild;
    int peso;

    public NodoABB(int key) {
        this.key = key;
        this.peso = 1;
    }
}

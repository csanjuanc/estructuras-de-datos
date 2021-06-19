package ABB_regular;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class NodoABB {

    NodoABB leftChild;
    int key;
    NodoABB rightChild;

    public NodoABB(int key) {
        this.key = key;
    }
    
    @Override
    public String toString() {
        return key + ", ";
    }

}

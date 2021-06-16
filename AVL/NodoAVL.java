package AVL;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class NodoAVL {
    int altura;
    int key;
    NodoAVL left;
    NodoAVL right;
 
    NodoAVL(int d) {
        key = d;
        altura = 1;
    }
}

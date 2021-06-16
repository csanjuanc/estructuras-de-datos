/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
package ColaBinomial;

//============================
//Nodo árbol/cola binomial
//============================

public class NodoCB {

    NodoCB parent; // El padre
    NodoCB sibling; // el hermano
    NodoCB child;  // el hijo
    Integer key;  // la clave
    Short degree; // el grado.

    //============================
    //Constructor 
    //============================
    NodoCB(NodoCB parent, NodoCB sibling, NodoCB child, Integer key, Short degree) {
        this.parent = parent;
        this.sibling = sibling;
        this.child = child;
        this.key = key;
        this.degree = degree;
    }

    //===============================
    //Une dos arboles binomiales B_k 
    //===============================
    void BinomialLink(NodoCB z) {
        parent = z;
        sibling = z.child;
        z.child = this;
        z.degree++;
    }

    public int compareTo(NodoCB other) {
        return this.key.compareTo(other.key);
    }
    
    public int getSize() {
        return (1 + ((child == null) ? 0 : child.getSize()) + ((sibling == null) ? 0 : sibling.getSize()));
    }
    
    public void print(int level) {
        NodoCB curr = this;
        while (curr != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("   ");
            }
            sb.append(curr.key.toString());
            System.out.println(sb.toString());
            if (curr.child != null) {
                curr.child.print(level + 1);
            }
            curr = curr.sibling;
        }
    }
}

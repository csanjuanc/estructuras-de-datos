package ColaBinomial;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
import java.util.ArrayList;
import java.util.List;

public class ColaBinomial {
    // Puntero al primer árbol binomial de la cola
    NodoCB head;

    // Constructor
    public ColaBinomial() {
        head = null;
    } 

    public ColaBinomial(NodoCB head) {
        this.head = head;
    }
    
    // Inserta un elemento en la cola binomial
    public void insertar(int a) {
        ColaBinomial temp = new ColaBinomial();
        temp.head = new NodoCB(null, null, null, a, (short) 0);
        head = BinomialHeapUnion(temp);
    }

    // Obtiene el arbol de la cola binomial con el mayor
    // numero de elementos y retorna su valor
    public int maxBinomialTree() {
        if (head == null) {
            return -1;
        } else {
            NodoCB current = head;
            int max = current.degree;
            while (current != null) {
                if (current.degree > max) {
                    max = current.degree;
                }
                current = current.sibling;
            }
            return (int) Math.pow(2, max);
        }
    }

    // Obtiene la cantidad de claves de la cola binomial
    // mayores o iguales que x
    public int count(Integer valor) {
        int cont = 0;
        
        List<NodoCB> nodes = new ArrayList<NodoCB>();
        nodes.add(head);
        while (!nodes.isEmpty()) {
            NodoCB curr = nodes.get(0);
            nodes.remove(0);
            
            if (curr.sibling != null) {
                nodes.add(curr.sibling);
            }
            if (curr.child != null) {
                nodes.add(curr.child);
            }
            
            if (valor <= curr.key) {
                cont++;
            }
        }
        
        return cont;
    }

    // Elimina el minimo de la cola binomial y lo retorna
    public int extractMin() {
        if (head == null) {
            return -1;
        }

        NodoCB min = head;
        NodoCB minPrev = null;
        NodoCB next = min.sibling;
        NodoCB nextPrev = min;

        while (next != null) {
            if (next.compareTo(min) < 0) {
                min = next;
                minPrev = nextPrev;
            }
            nextPrev = next;
            next = next.sibling;
        }

        removeTreeRoot(min, minPrev);
        return min.key;
    }

    // Retorna el menor elemento existente en la cola binomial
    // Se asume que la cola no esta vacia
    public Integer BinomialHeapMinimum() {
        if (head == null) {
            return -1;
        } else {
            NodoCB current = head;
            int min = current.key;
            while (current != null) {
                if (current.key < min) {
                    min = current.key;
                }
                current = current.sibling;
            }
            return min;
        }
    }
    
    public void exists(int key) {
        NodoCB resultado = search(key);
        
        if(resultado == null) {
            System.out.println("El valor "+key+" no existe en la cola binomial");
        }else {
            System.out.println("El valor "+key+" existe en la cola binomial");
        }
    }
    
    //Retorna el nodo que contiene el valor ingresado
    private NodoCB search(int key) {
        List<NodoCB> nodes = new ArrayList<NodoCB>();
        nodes.add(head);
        while (!nodes.isEmpty()) {
            NodoCB curr = nodes.get(0);
            nodes.remove(0);
            if (curr.key == key) {
                return curr;
            }
            if (curr.sibling != null) {
                nodes.add(curr.sibling);
            }
            if (curr.child != null) {
                nodes.add(curr.child);
            }
        }
        return null;
    }
    
    public void print() {
        System.out.println("Cola Binomial:");
        if (head != null) {
            head.print(0);
        }
    }

    // Union (fusion de dos colas binomiales)
    private NodoCB BinomialHeapUnion(ColaBinomial H2) {
        ColaBinomial H = BinomialHeapMerge(this, H2);
        if (H.head == null) {
            return null;
        }
        
        NodoCB anterior = null;
        NodoCB actual = H.head;
        NodoCB siguiente = actual.sibling;
        while (siguiente != null) {
            if ((actual.degree != siguiente.degree) || 
                    (siguiente.sibling != null && siguiente.sibling.degree == actual.degree)) {
                //Si los grados son distintos se avanza
                anterior = actual;
                actual = siguiente;
            } else if (actual.key <= siguiente.key) {//el valor de actual es menor al siguiente
                //enlaza los hermanos para no perderlos
                actual.sibling = siguiente.sibling;
                //actual se une con el siguiente
                siguiente.BinomialLink(actual);
            } else {//El valor de siguiente es menor que actual
                //enlaza los hermanos para no perderlos
                if (anterior == null) {
                    H.head = siguiente;
                } else {
                    anterior.sibling = siguiente;
                }
                //siguiente se une con actual
                actual.BinomialLink(siguiente);
                //el actual ahora es el siguiente (evita duplicidad)
                actual = siguiente;
            }
            siguiente = actual.sibling;
        }
        return H.head;
    }

    // Mezcla de dos colas Binomiales. A partir de dos colas 
    // se obtiene una tercera que contiene los árboles binomiales
    // de las dos colas ordenados por k
    private ColaBinomial BinomialHeapMerge(ColaBinomial H1, ColaBinomial H2) {
        NodoCB h1 = H1.head;
        NodoCB h2 = H2.head;
        if (h1 == null) {
            return H2;
        }
        if (h2 == null) {
            return H1;
        }
        
        ColaBinomial H = new ColaBinomial();
        NodoCB ini = null;
        NodoCB fin = null;
        while (h1 != null && h2 != null) {
            if (h1.degree <= h2.degree) {
                if (ini == null) {
                    ini = fin = h1;
                } else {
                    fin.sibling = h1;
                    fin = h1;
                }
                h1 = h1.sibling;
            } else {
                if (ini == null) {
                    ini = fin = h2;
                } else {
                    fin.sibling = h2;
                    fin = h2;
                }
                h2 = h2.sibling;
            }
        }

        //Si alguna de las dos colas se termina, se agrega la contraria como hermano
        if (h1 == null) {
            fin.sibling = h2;
        }

        if (h2 == null) {
            fin.sibling = h1;
        }

        H.head = ini;
        return H;
    }
    
    private void removeTreeRoot(NodoCB root, NodoCB prev) {
        // Remove root from the heap
        if (root == head) {
            head = root.sibling;
        } else {
            prev.sibling = root.sibling;
        }

        // Reverse the order of root's children and make a new heap
        NodoCB newHead = null;
        NodoCB child = root.child;
        while (child != null) {
            NodoCB next = child.sibling;
            child.sibling = newHead;
            child.parent = null;
            newHead = child;
            child = next;
        }
        ColaBinomial newHeap = new ColaBinomial(newHead);

        // Union the heaps and set its head as this.head
        head = BinomialHeapUnion(newHeap);
    }
    
    //Metodos auxiliares
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }
}

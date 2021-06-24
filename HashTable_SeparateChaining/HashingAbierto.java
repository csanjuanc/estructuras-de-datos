package HashTable_SeparateChaining;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class HashingAbierto {
    private NodoLista[] tabla;
    private int cantidad;

    // Constructor
    public HashingAbierto(int tableSize) {
        tabla = new NodoLista[siguientePrimo(tableSize)];
        cantidad = 0;
    }

    // Verifica si la tabla hash esta vacia
    public boolean estaVacio() {
        return cantidad == 0;
    }

    // Vacia la tabla Hash
    public void vaciarTabla() {
        int l = tabla.length;
        tabla = new NodoLista[l];
        cantidad = 0;
    }

    // Retorna la cantidad de elementos almacenados en la tabla hash
    public int getCantidad() {
        return cantidad;
    }

    // Inserta un elemento
    public void insertar(int val) {
        int pos = funcionHash(val);
        NodoLista temp = new NodoLista(val);
        if (tabla[pos] == null) {
            tabla[pos] = temp;
        } else {
            temp.siguiente = tabla[pos];
            tabla[pos] = temp;
        }
        cantidad++;
    }

    // Elimina un elemento
    public void eliminar(int val) {
        int pos = funcionHash(val);
        NodoLista inicio = tabla[pos];
        NodoLista fin = inicio;
        if (inicio.data == val) {
            cantidad--;
            tabla[pos] = inicio.siguiente;
            return;
        }

        while (fin.siguiente != null && fin.siguiente.data != val) {
            fin = fin.siguiente;
        }

        if (fin.siguiente == null) {
            System.out.println("\nElemento no encontrado\n");
            return;
        }

        cantidad--;

        //Revisa si el nodo encontrado es el ultimo
        if (fin.siguiente.siguiente == null) {
            fin.siguiente = null;
            return;
        }

        //El siguiente será el sub-siguiente del nodo
        fin.siguiente = fin.siguiente.siguiente;
        tabla[pos] = inicio;
    }

    // La funcion hash
    private int funcionHash(Integer x) {
        int valorHash = x % tabla.length;

        if (valorHash < 0) {
            valorHash += tabla.length;
        }

        return valorHash;
    }

    //Genera el siguiente numero primo dado un numero recibido
    private int siguientePrimo(int n) {
        if (n % 2 == 0) {
            n++;
        }

        for (; !esPrimo(n); n += 2);

        return n;
    }

    // Verifica que el numero recibido es primo
    private boolean esPrimo(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    //Muestra la tabla por pantalla
    public void mostrarTablaHash() {
        System.out.println();

        for (int i = 0; i < tabla.length; i++) {
            System.out.print("\t"+ i + (i < 10 ? " " : "") +"|__| -> ");
            NodoLista start = tabla[i];

            while (start != null) {
                System.out.print(start.data);
                if(start.siguiente == null) {
                    System.out.print(" -> NULL");
                }else {
                    System.out.print(" -> ");
                }
                
                start = start.siguiente;
            }

            System.out.println();
        }
    }
    
    //Devuelve verdadero si existe el elemento en la tabla hash
    public boolean buscar(int valor) {
        int pos = funcionHash(valor);
        NodoLista temp = tabla[pos];

        //Se revisa si existen mas objetos en la lista enlazada
        while (temp != null) {
            if(temp.data == valor) {
                return true;
            }
            temp = temp.siguiente;
        }
        
        return false;
    }
}

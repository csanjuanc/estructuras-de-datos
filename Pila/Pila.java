package Pila;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class Pila {
    //Atributos
    private Nodo top;
    //Se agrega un atributo para almacenar el numero de elementos contenidos
    // en la pila, de tal forma podemos recuperar el tamanio en O(1), si no
    // lo tuvieramos, se debe recorrer y contar nodo por nodo siendo O(n)
    private int tamanio;
    
    //Constructor
    public Pila() {
        top = null;
        tamanio = 0;
    }

    //Operacion para insertar un elemento en la pila
    public void push(Object datoIngresado) {
        Nodo nuevo = new Nodo(datoIngresado);
        // Consulta si la pila esta vacia.
        if (isEmpty()) {
            top = nuevo;
        }else {
            nuevo.setSiguiente(top);
            top = nuevo;
        }
        // Incrementa el contador del tamaño.
        tamanio++;
    };

    //Operacion para extraer el elemento del top
    public Object pop() {
        if (top == null){
            return null;
        }

        Object numeroTop = top.getDato();
        top = top.getSiguiente();
        tamanio--;

        return numeroTop;
    }

    //Indica si la pila esta vacia
    public boolean isEmpty() {
        return top == null;
    }

    //Devuelve el tamanio de la pila
    public int tamanio() {
        return tamanio;
    }

    //Devuelve el valor del top de la pila sin extraerlo
    public Object top() {
        if (top == null){
            return null;
        } else{
            return top.getDato();
        }
    }
    
    //Muestra la pila
    public void muestraPila() {
        Nodo aux = top;
        
        while(aux != null){
            System.out.println("|\t" + aux.getDato()+ "\t|");
            System.out.println("-----------------");
            aux = aux.getSiguiente();
        }
    }
}

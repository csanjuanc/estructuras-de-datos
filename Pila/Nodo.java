package Pila;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class Nodo {
    //Atributos
    private Object dato;//De tipo Object para que soporte numeros o texto
    private Nodo siguiente;

    //Constructores
    public Nodo() {
      this.dato = null;
      this.siguiente = null;
    }
    
    public Nodo(Object dato) {
      this.dato = dato;
      this.siguiente = null;
    }
    
    public Nodo(Object dato, Nodo nodo) {
      this.dato = dato;
      this.siguiente = nodo;
    }
    
    //Operaciones
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        String cadena = " "+dato+" ";
        return cadena;
    }
}

package Pila;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestPila {
    public static void main(String[] args) {
        //Se crea la pila
        Pila miPila = new Pila();
        
        //Se pregunta si la pila esta vacia
        if(miPila.isEmpty()) {
            System.out.println("La pila esta vacia.");
        }
        
        //Se insertan datos a la pila
        miPila.push(13);
        miPila.push(13);
        miPila.push(13);
        //Muestra el elemento que esta en el top
        System.out.println("El numero del top es " + miPila.top());
        miPila.push(84);
        miPila.push(7);
        miPila.push(308);
        //Muestra el elemento que esta en el top
        System.out.println("El numero del top es " + miPila.top());
        miPila.push(65);
        miPila.push(32);
        miPila.push(74);
        
        //Se muestra el tamanio de la pila
        System.out.println("La pila tiene " + miPila.tamanio()+ " elementos.");
        
        //Muestra todos los elementos de la pila
        miPila.muestraPila();
    }
    
    
}

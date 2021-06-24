package HashTable_SeparateChaining;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */

/*
La tabla hash con encadenamiento puede ser construida a partir de un arreglo
estatico, donde cada casilla correspondera a la cabeza de una lista enlazada,
de tal forma, si se produce una colision bastaria con agregarla a la lista.

*/
public class HashingAbiertoTest {
    public static void main(String[] args) {
        //Se crea la tabla hash
        HashingAbierto tablaHash = new HashingAbierto(20);
        //Se insertan elementos en la tabla hash
        tablaHash.insertar(2);
        tablaHash.insertar(8);
        tablaHash.insertar(3);
        tablaHash.insertar(11);
        tablaHash.insertar(46);
        tablaHash.insertar(18);
        tablaHash.insertar(6);
        tablaHash.insertar(34);
        tablaHash.insertar(26);
        tablaHash.insertar(16);
        tablaHash.insertar(42);
        tablaHash.insertar(30);
        
        //Muestra el numero de elementos que contiene la tabla hash
        System.out.println("Total actual de elementos: " + tablaHash.getCantidad());
        
        //Muestra el contenido de la tabla hash
        tablaHash.mostrarTablaHash();
        
        //Eliminando elementos de la tabla hash
        tablaHash.eliminar(8);
        tablaHash.eliminar(3);
        
        //Muestra el numero de elementos que contiene la tabla hash
        System.out.println("Total actual de elementos: " + tablaHash.getCantidad());
        
        //Buscando un elemento de la tabla hash
        int key = 8;
        System.out.println("Existe el valor "+key+": " + tablaHash.buscar(key));

        //Limpia la tabla hash
        System.out.println("\nLimpiando tabla Hash ... ... ...");
        tablaHash.vaciarTabla();
        
        //Muestra el numero de elementos que contiene la tabla hash
        System.out.println("Total actual de elementos: " + tablaHash.getCantidad());
    }
}

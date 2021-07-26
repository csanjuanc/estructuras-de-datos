package HashTable_Lineal;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class main {
    public static void main(String[] args) {
        //Determins el tamanio de la tabla y luego la crea
        int tamanio = 10;
        TablaHash tablaHash = new TablaHash(tamanio);
        
        //Se insertan valores a la tabla
        tablaHash.insertar(new Elemento(8));
        tablaHash.insertar(new Elemento(25));
        tablaHash.insertar(new Elemento(13));
        tablaHash.insertar(new Elemento(6));
        tablaHash.insertar(new Elemento(16));
        tablaHash.insertar(new Elemento(11));
        tablaHash.insertar(new Elemento(27));
        tablaHash.insertar(new Elemento(9));
        
        //Se muestra la tabla
        tablaHash.mostrarTablaHash();
        
        //Se elimina un elemento
        System.out.println("Eliminar 16");
        tablaHash.borrar(16);
        
        //Se muestra la tabla
        tablaHash.mostrarTablaHash();
        
        System.out.println("Insertar 15");
        tablaHash.insertar(new Elemento(15));
        //Se muestra la tabla
        tablaHash.mostrarTablaHash();
        
        //Recupera el objeto si es que existe
        int valorBuscado = 13;
        Elemento elemento = tablaHash.buscar(valorBuscado);
        
        if (elemento != null) {
            System.out.println("Existe " + valorBuscado);
        } else {
            System.out.println("No se encuentra el valor " + valorBuscado);
        }
    }
    
}

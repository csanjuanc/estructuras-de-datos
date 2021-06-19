package ABB_regular;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestABB {

    public static void main(String[] args) {
        //Se crea el ABB
        ABB arbolBinario = new ABB();
        
        //Se insertan valores aleatorios al arbol
        arbolBinario.insertarIterativo(30);
        arbolBinario.insertar(20);
        arbolBinario.insertar(40);
        arbolBinario.insertar(10);
        arbolBinario.insertar(25);
        arbolBinario.insertar(38);
        arbolBinario.insertar(50);
        arbolBinario.insertar(23);
        arbolBinario.insertar(28);
        arbolBinario.insertar(44);
        arbolBinario.insertar(26);
        
        System.out.println("\nArbol Binario de Busqueda");
        arbolBinario.imprimirArbol();
        
        //Se muestran los diferentes recorridos
        System.out.println("\nNodos Por Nivel:");
        arbolBinario.imprimirPorNivel();
        System.out.println("\nArbol InOrden:");
        arbolBinario.imprimirInOrder();
        System.out.println("\nArbol PreOrden:");
        arbolBinario.imprimirPreOrder();
        System.out.println("\nArbol PreOrden (iterativo):");
        arbolBinario.preOrderIterativo();
        System.out.println("\nArbol PostOrden:");
        arbolBinario.imprimirPostOrder();
        
        //Busca el menor elemento almacenado en el arbol
        System.out.println("\n\nEl elemento menor es: " + arbolBinario.buscarMin());
        
        //Busca el mayor elemento almacenado en el arbol
        System.out.println("\nEl elemento mayor es: " + arbolBinario.buscarMax());
        
        arbolBinario.eliminar(20);
        System.out.println("\n");
        //Note que al realizarce la eliminacion de 20, es reemplazado por su sucesor
        arbolBinario.imprimirArbol();
        
        int objetivo = 7;
        System.out.println("El valor mas cercano a " + objetivo + " es: " + arbolBinario.buscarCercano(objetivo));
        arbolBinario.sucesor(10);
        
        //Muestra el ancestro comun mas bajo en O(h), con h la altura del arbol
        arbolBinario.ancestro(26, 44);
    }
}

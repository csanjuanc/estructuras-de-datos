package ABB_con_peso;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class main {
    
    //Buscar el K-esimo elemento (ordenado de menor a mayor) es posible en un ABB
    //realizando una modificacion a su Nodo, en particuluar, se necesita almacenar
    //en una nueva variable el peso de este. La gracia de esta modificacion en la
    //estructura tiene por objetivo calcular el K-esimo en O(h), siendo h la altura
    //del arbol. De no poseer el peso, para responder esa consulta seria necesario
    //recorrer el arbol en inorden para ir contando los elementos y lograr encontrar
    //el K-esimo, siendo el peor caso O(n).

    public static void main(String[] args) {
        //Se crea el ABB
        ABB arbolBinario = new ABB();
        
        //Se insertan valores aleatorios en el arbol
        arbolBinario.insertar(78);
        arbolBinario.insertar(46);
        arbolBinario.insertar(90);
        arbolBinario.insertar(17);
        arbolBinario.insertar(63);
        arbolBinario.insertar(82);
        arbolBinario.insertar(98);
        arbolBinario.insertar(19);
        arbolBinario.insertar(81);
        arbolBinario.insertar(87);
        arbolBinario.insertar(84);
        
        System.out.println("\n");
        arbolBinario.imprimirArbol();
        
        //Valores de menor a mayor
        //    17 - 19 - 46 - 63 - 78 - 81 - 82 - 84 - 87 - 90 - 98
        // k=  1    2    3    4    5    6    7    8    9   10   11
        
        arbolBinario.kesimo(1);
        arbolBinario.kesimo(2);
        arbolBinario.kesimo(5);
    }
}

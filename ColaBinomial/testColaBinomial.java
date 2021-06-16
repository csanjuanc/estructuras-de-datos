package ColaBinomial;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class testColaBinomial {

    public static void main(String[] args) {
        ColaBinomial b = new ColaBinomial();
        //Inserta valores
        b.insertar(2);
        b.insertar(17);
        b.insertar(12);
        b.insertar(4);
        b.insertar(7);
        b.insertar(1);
        b.insertar(10);
        b.insertar(18);
        b.insertar(21);
        b.insertar(6);
        b.insertar(15);
        
        //Muestra la cola binomial por pantalla
        b.print();
        
        System.out.println("El menor valor de la cola binomial es: " + b.BinomialHeapMinimum());//Debe mostrar 1
        
        System.out.println("La cantidad de nodos del arbol mas grande es: " + b.maxBinomialTree());//Debe mostrar 8
        
        //Existe el valor 6 en la cola binomial?
        b.exists(6);//Debe mostrar que si
        
        //Muestra la cantidad de claves mayores a 8
        System.out.println("Los nodos con valor mayor o igual a 8 son: " + b.count(8));//Debe mostrar 6
        
        System.out.println("Se extrae el menor valor: "+b.extractMin());
        System.out.println("Nueva Cola Binomial");
        b.print();
    }
}

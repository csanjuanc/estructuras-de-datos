package AVL;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TestAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        
        //Rotacion Simple a la derecha
        /*
                20 (2)
              /
            12 (1)
          /
        5 (0)
        */
        System.out.println("ROTACION SIMPLE DERECHA - EJEMPLO 1");
        arbol.insertar(20);
        arbol.insertar(12);
        arbol.insertar(5);
        arbol.mostrarArbolAVL();
        
        System.out.println("\nROTACION SIMPLE DERECHA - EJEMPLO 2");
        arbol.clearAll();
        /*
                    20 (2)
                  /       \
                15 (1)     25 (0)
              /       \
            10 (1)    18 (0)
           /
          5 (0)
        */
        arbol.insertar(20);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(10);
        arbol.insertar(18);
        arbol.insertar(5);
        arbol.mostrarArbolAVL();
        
        //Separador
        System.out.println("\n***********************************************************************");
        System.out.println("***********************************************************************");
        
        //Rotacion Simple a la izquierda
        System.out.println("\nROTACION SIMPLE IZQUIERDA - EJEMPLO 1");
        /*
        5 (-2)
          \
           12 (-1)
              \
               20 (0)
        */
        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(20);
        arbol.mostrarArbolAVL();
        
        //Rotacion Simple izquierda
        System.out.println("\nROTACION SIMPLE IZQUIERDA - EJEMPLO 2");
        /*
                 10 (-2)
             /           \
            5 (0)       18 (-1)
                     /          \
                  15 (0)      20 (-1)
                                 \
                                25 (0)
        */
        arbol.clearAll();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(18);
        arbol.insertar(15);
        arbol.insertar(20);
        arbol.insertar(25);
        arbol.mostrarArbolAVL();
        
        //Separador
        System.out.println("\n***********************************************************************");
        System.out.println("***********************************************************************");
        
        //Rotacion Doble derecha-izquierda
        System.out.println("\nROTACION DOBLE DERECHA-IZQUIERDA - EJEMPLO 1");
        /*
        5 (-2)
          \
           12 (1)
          /
         8 (0)
        */
        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(8);
        arbol.mostrarArbolAVL();
        
        System.out.println("\nROTACION DOBLE DERECHA-IZQUIERDA - EJEMPLO 2");
        /*
             5 (-2)
         /           \
        2 (0)       12 (1)
                  /        \
                8 (1)       14 (0)
              /
            7 (0)
        */
        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(2);
        arbol.insertar(12);
        arbol.insertar(8);
        arbol.insertar(14);
        arbol.insertar(7);
        arbol.mostrarArbolAVL();
        
        //Separador
        System.out.println("\n***********************************************************************");
        System.out.println("***********************************************************************");
        
        //Rotacion Doble izquierda-derecha
        System.out.println("\nROTACION DOBLE IZQUIERDA-DERECHA - EJEMPLO 1");
        /*
               12 (2)
              /
            5 (-1)
              \
               8 (0)
        */
        arbol.clearAll();
        arbol.insertar(12);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.mostrarArbolAVL();
        
        System.out.println("\nROTACION DOBLE IZQUIERDA-DERECHA - EJEMPLO 2");
        /*
                    15 (2)
                /          \
               4 (-1)       20 (0)
             /      \
          2 (0)      8 (-1)
                      \
                       10 (0)
        */
        arbol.clearAll();
        arbol.insertar(15);
        arbol.insertar(4);
        arbol.insertar(20);
        arbol.insertar(2);
        arbol.insertar(8);
        arbol.insertar(10);
        arbol.mostrarArbolAVL();
    }
    
}

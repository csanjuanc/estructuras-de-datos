package ArbolGeneral;


class testArbolNario {
    
    /*
    Imaginemos que tenemos un directorio en Windows, tal directorio puede tener
    varios archivos y carpetas que a su vez, estos tambien pueden tener archivos
    y carpetas.
    Para representar lo anterior, es posible utilizar los arboles generales :)
    Cada nodo posee un dato que correspondera a la carpeta/archivo almacenado y
    para acceder a el, debemos conocer la ruta (path) de acceso.
    
    En el siguiente ejemplo, emularemos el directorio de un alumno que guarda
    sus archivos pdf correspondiente a ejercicios de diferentes asignaturas.
    Por ejemplo:
    "/" -> La raiz de nuestro disco
    "ICI" -> Carpeta Ingenieria Civil Informatica
    "IP" -> Carpeta Introduccion a la Programacion
    "EDD" -> Carpeta Estructuras de Dato
    */

    public static void main(String[] args) {
        ArbolNario arbol = new ArbolNario();
        arbol.Agregar("/", "ICI");
        arbol.Agregar("/ICI", "IP");
        arbol.Agregar("/ICI", "EDD");
        arbol.Agregar("/ICI/IP", "Variables.pdf");
        arbol.Agregar("/ICI/IP", "Funciones.pdf");
        arbol.Agregar("/ICI/IP", "Tipo_Dato");
        arbol.Agregar("/ICI/EDD", "Variables.pdf");
        arbol.Agregar("/ICI/EDD", "Estructuras");
        arbol.Agregar("/ICI/IP/Tipo_Dato", "Integer.pdf");
        arbol.Agregar("/ICI/IP/Tipo_Dato", "Double.pdf");
        arbol.Agregar("/ICI/IP/Tipo_Dato", "String.pdf");
        arbol.Agregar("/ICI/EDD/Estructuras", "Bits.pdf");
        arbol.Agregar("/ICI/EDD/Estructuras", "Pila.pdf");
        arbol.Agregar("/ICI/EDD/Estructuras", "Fila.pdf");
        arbol.Agregar("/ICI/EDD/Estructuras", "Arbol.pdf");
        
        //Muestra el arbol
        System.out.println("El Arbol N-ario creado es: ");
        arbol.Imprimir();
        
        //Muestra el arbol en preorder
        System.out.println("");
        System.out.print("Arbol N-ario en Preorder: ");
        arbol.mostrarPreorder();
        System.out.println("");
        
        System.out.print("Arbol N-ario en Inorder: ");
        arbol.mostrarInorder();
        System.out.println("");
        
        System.out.print("Arbol N-ario en Postorder: ");
        arbol.mostrarPostorder();
        
        System.out.println("\nTotal nodos: " + arbol.totalNodos());
        
        System.out.println("Total hojas: " + arbol.cuentaHojas());
        
        String buscar = "Variables.pdf";
        System.out.print("Numero de veces que aparece el nombre \""+buscar+"\": " + arbol.numeroApariciones(buscar));
        System.out.println("");
        
        // Aqui el arbol de ejemplo no es ternario, para que sea ternario
        // basta con quitar un nodo desde "/ICI/EDD/Estructuras"
        System.out.println("El arbol es trinario?: " + arbol.esTernario());
    }
}

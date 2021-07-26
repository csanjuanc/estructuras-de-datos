package HashTable_Lineal;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class TablaHash {

    private Elemento[] arregloHash;
    private int size;
    private int maxSize;
    private Elemento marcadorDelete = new Elemento(-1); //marcador para elementos eliminados

    public TablaHash(int tamanio) {
        maxSize = tamanio;
        arregloHash = new Elemento[maxSize];
    }

    public int funcionHash(int key) {
        return key % maxSize;
    }

    public void insertar(Elemento obj) {
        int pos = funcionHash(obj.getKey());
        int i = 0;
        //si esta ocupado (igual a nulo), busca la posicion siguiente
        while(arregloHash[pos] != null && arregloHash[pos] != marcadorDelete){
            pos++;
            pos = funcionHash(pos);
            //pos = (pos + 1) % maxSize;
            if(i == maxSize){
                System.out.println("Tabla Hash llena");
            }
            i++;
        }
        //Si llega hasta aqui es porque encontro un espacio donde insertarse
        arregloHash[pos] = obj;
    }

    public Elemento borrar(int key) {//REVISAR
        int pos = funcionHash(key);

        while (arregloHash[pos] != null) {
            //Verifica que el valor sea el mismo al buscado
            if (arregloHash[pos].getKey() == key) {
                Elemento temp = arregloHash[pos];
                //Se inserta marcador eliminado
                arregloHash[pos] = marcadorDelete;
                //retorna el valor eliminado
                return temp;
            }
            //Si no es el valor buscado, busca la nueva posicion
            ++pos;
            pos = funcionHash(pos);
        }
        //No lo ha encontrado, retorna null
        return null;
    }

    public Elemento buscar(int key) {//REVISAR
        int pos = funcionHash(key);

        while (arregloHash[pos] != null) {
            if (arregloHash[pos].getKey() == key) {
                return arregloHash[pos];
            }
            //Si no es el valor buscado, busca la nueva posicion
            ++pos;
            pos = funcionHash(pos);
        }
        //No lo ha encontrado, retorna null
        return null;
    }

    public void mostrarTablaHash() {//REVISAR
        System.out.print("Tabla Hash (Lineal): ");
        for (int i = 0; i < maxSize; i++) {
            if (arregloHash[i] != null) {
                if(arregloHash[i] != marcadorDelete) {
                    System.out.print(" "+arregloHash[i].getKey() + " |");
                }else {
                    System.out.print(" DEL |");
                }
            } else {
                System.out.print(" {} |");
            }
        }
        System.out.println("");
    }
}
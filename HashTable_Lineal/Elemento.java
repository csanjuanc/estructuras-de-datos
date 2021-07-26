package HashTable_Lineal;

/**
 *
 * @author Carlos San Juan <carlossanjuanc@gmail.com>
 */
public class Elemento {
    private Object item;

    public Elemento(int item) {
        this.item = item;
    }

    public int getKey() {
        return (int) item;
    }
}

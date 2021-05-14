import java.util.Iterator;

public  interface Iterator_ahmet<E> extends Iterator<E> {
    /**
     * Iterator class by adding a method to set the value (value passed as parameter)
     * @param item
     * @return
     */
    public E set(E item);
}

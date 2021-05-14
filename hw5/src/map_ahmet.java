import java.util.HashMap;
import java.util.Iterator;
@SuppressWarnings("unchecked")
public class map_ahmet<K,V> extends HashMap<K, V> {
    private class MapIterator<K> implements Iterator_map<K> {
        private Iterator<K> it;
        private int index = 0;
        public MapIterator()
        {
            it = (Iterator<K>) keySet().iterator();
        }
        public MapIterator(K key)
        {
            it = (Iterator<K>) keySet().iterator();
            Iterator<K> it2=(Iterator<K>) keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equals(key)) {
                    it=it2;
                    return;
                }
                index++;
                it2.next();
            }

        }

        /**
         * Returns the next key in the map and advances the cursor position.
         * @return
         */
        public K next()
        {
            ++index;
            return (K) it.next();
        }

        /**
         * Returns the previous key in the map and moves the cursor position backwards.
         * @return
         */
        public K prev()
        {
            it = (Iterator<K>) keySet().iterator();
            for (int i = 0; i < index-1; i++)
                it.next();
                --index;
                return (K) it.next();
        }

        /**
         * Returns true if this  iterator has more elements when traversing the map in the forward direction.
         * @return
         */
        public boolean hasNext()
        {
                return it.hasNext();
        }

        /**
         *Returns true if this map iterator has more elements when traversing the map in the reverse direction.
         * @return
         */
        public boolean hasPrev(){
            return index>0;
        }
    }

    /**
     * Returns an iterator over elements of type K.
     * @param key
     * @return
     */
    public Iterator_map<K> iterator(K key)
        {
            return new MapIterator<K>(key);
        }

}

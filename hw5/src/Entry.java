
public class Entry <K,V> implements Comparable<Entry<K, V>> {
    /** Contains key‐value pairs for a hash table. */
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key‐value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
        public String toString(){
            return String.format("key="+key+" value="+value);
        }

    @Override
    /**
     * compare Key hash code
     */
    public int compareTo(Entry<K, V> o) {
        if(getKey().hashCode()>o.getKey().hashCode()){
            return 1;
        }
        else if(getKey().hashCode()==o.getKey().hashCode())
            return 0;
        return -1;
    }
}

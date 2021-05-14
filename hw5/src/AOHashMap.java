public interface AOHashMap <K,V>{
    /**
     * Returns the value associated with the specified key. Returns null if the key is not present
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * Returns true if this table contains no key‐value mappings
     * @return
     */

    boolean isEmpty();

    /**
     * Associates the specified value with the specified key. Returns the previous value
     * associated with the specified key, or null if there was no mapping for the key
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value);

    /**
     * Removes the mapping for this key from this table if it is present (optional
     * operation). Returns the previous value associated with the specified key, or null if
     * there was no mapping
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * Returns the size of the table
     * @return
     */
    int size();
}


@SuppressWarnings("unchecked")
public class AOHashMapOpenQuadratic<K,V> implements AOHashMap<K,V> {
    private Entry<K, V>[] table;

    private int numKeys;

    private double LOAD_THRESHOLD = 0.75;

    private static final int START_CAPACITY = 10;
    // Constructor
    public AOHashMapOpenQuadratic() {
        table = new Entry[START_CAPACITY];
    }
    /** Finds either the target key or the first empty slot in the
     search chain using quadratic probing.
     @pre The table is not full.
     @param key The key of the target object
     @return The position of the target or the first empty slot if
     the target is not in the table.
     */
    private int find(K key){
        int i=0;
        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;
        int index2=index;
        while ((table[index] != null) && (!key.equals(table[index].getKey()))) {
            index=index2;
            i++;
            index = (index + (i*i)) % 10;
            if (index >= table.length)
                index = 0;
        }

        return index;
    }
    /** Method put for class HashtableOpen.
     @post This key‐value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed. If the LOAD_THRESHOLD
     is exceeded, the table is expanded.
     @param key The key of item being inserted
     @param value The value for this key
     @return Old value associated with this key if found;
     otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = find(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            numKeys++;
            double loadFactor = (double) (numKeys) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }
        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     @post The size of the table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[2 * oldTable.length + 1];
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null)) {
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    /** Method get for class HashtableOpen.
     @param key The key being sought
     @return the value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(K key) {
        int index = find(key);
        if (table[index] != null)
            return table[index].getValue();
        else
            return null; // key not found.
    }
    /**
     * Returns true if this table contains no key‐value mappings
     * @return
     */
    @Override
    public boolean isEmpty() {
        return numKeys<1;
    }

    /**
     * Moves the element to be deleted to the last point it can go and returns the new index of the element
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    private int find_remove(K key){

        int i=0;
        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;
        int index2=index;
        while ((table[index] != null) && (!key.equals(table[index].getKey()))) {
            index=index2;
            i++;
            index = (index + (i*i)) % 10;
            if (index >= table.length)
                index = 0;
        }
        Entry<K,V> tmp;
        int count=index;

        while ((table[index] != null)) {
            index=index2;
            i++;
            index = (index + (i*i)) % table.length;
            if (index >= table.length)
                index = 0;
            if(table[index]==null){
                return count;
            }
            if(table[index].getKey().hashCode()%table.length==index2){
                tmp=table[count];
                table[count]=table[index];
                table[index]=tmp;
                count=index;
            }
        }
        return index;
    }

    /**
     * Removes an element from the table
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        int index = find_remove(key);
        Entry<K,V>tmp=table[index];
        table[index]=null;
        numKeys--;
        return tmp.getValue();
    }
    /**
     * Returns the size of the table
     * @return
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * To string
     * @return
     */
    public String toString(){
        StringBuilder result=new StringBuilder();
        for(int i=0;i< table.length;i++){
            if(table[i]!=null){
                result.append("\nindex= "+i+"->"+table[i]);
            }
        }
        return result.toString() ;
    }
}

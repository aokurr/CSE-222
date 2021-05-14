import java.util.Iterator;
import java.util.TreeSet;
@SuppressWarnings("unchecked")
public class AOHashtableChainTree <K,V> implements AOHashMap<K, V> {
    /** The table */
    private TreeSet<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 10;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    public AOHashtableChainTree() {
            table = new TreeSet[CAPACITY];
    }
    /** Method get for class HashtableChain(TreeSet).
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.

        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key))
                return nextItem.getValue();
        }
        return null;
    }
    /**
     * Returns true if this table contains no key‐value mappings
     * @return
     */
    @Override
    public boolean isEmpty() {
            return numKeys<1;
    }
    /** Method put for class HashtableChain.
     @post This key‐value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            table[index] = new TreeSet<>();
        }
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key)) {
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }
        table[index].add(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)){
            rehash();
        }
        return null;
    }
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     @post The size of the table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    public void rehash(){
        TreeSet<Entry<K, V>>[] tmp= new TreeSet[table.length*2];
        for(int i=0;i< table.length;i++){
            tmp[i]=table[i];
        }
        table=new TreeSet[tmp.length];
        Iterator iter;
        numKeys=0;
        for(int i=0;i< table.length-1;i++){
            if(tmp[i]!=null){
                iter=tmp[i].iterator();
            }
            else
                continue;
            while (iter.hasNext()){
                Entry tmp2= (Entry) iter.next();
                this.put((K)tmp2.getKey(),(V)tmp2.getValue());
            }
        }
    }
    /**
     * Removes an element from the table
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            return null;
        }
        Iterator iter=table[index].iterator();
        while (iter.hasNext()){
            Entry<K,V> tmp= (Entry<K, V>) iter.next();
            if(tmp.getKey().equals(key)){
                iter.remove();
                numKeys--;
                if(table[index].size()==0){
                    table[index]=null;
                }
                return tmp.getValue();
            }
        }
        return null;
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
     * toString
     * @return
     */
    public String toString(){
        StringBuilder result=new StringBuilder();
        for(int i=0;i< table.length;i++){
            if(table[i]!=null){
                result.append("\nindex= "+i+table[i]);
            }
        }
        return result.toString() ;
    }
}


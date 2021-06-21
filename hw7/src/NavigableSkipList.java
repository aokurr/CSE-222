import java.security.PublicKey;
import java.util.*;

public class NavigableSkipList<E extends Comparable<E>> implements NavigableSet<E> {
    private SkipList<E> list;
    private int size;
    public NavigableSkipList(){
        list = new SkipList<>();
        size = 0;
    }

    /**
     * Adds the specified element to this set if it is not already present (optional operation).
     * More formally, adds the specified element e to this set if the set contains no element e2 such that (e==null ? e2==null : e.equals(e2)). If this set already contains the element, the call leaves the set unchanged and returns false. In combination with the restriction on constructors,
     * this ensures that sets never contain duplicate elements.
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        if(list.add(e)){
            ++size;
            return true;
        }
        return false;
    }
    /**
     * Removes the specified element from this set if it is present (optional operation). More formally, removes an element e such that (o==null ? e==null : o.equals(e)),
     * if this set contains such an element. Returns true if this set contained the element (or equivalently, if this set changed as a result of the call). (This set will not contain the element once the call returns.)
     * @param o- object to be removed from this set, if present
     * @return true if this set contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        if(list.remove((E) o)){
            --size;
            return true;
        }
        return false;
    }
    @Override
    public Iterator<E> descendingIterator() {
        return new NavigableSkipListIterator<>();
    }

    @Override
    public E lower(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E floor(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E ceiling(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E higher(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size != 0;
    }
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    @Override
    public NavigableSet<E> descendingSet() {
        throw new UnsupportedOperationException();
    }
    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        throw new UnsupportedOperationException();
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        throw new UnsupportedOperationException();
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Comparator<? super E> comparator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E first() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E last() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an iterator over the elements in this set, in descending order.
     * @param <E>
     */
    public class NavigableSkipListIterator<E> implements Iterator<E>{
        ArrayList<E> arrayList = new ArrayList<>();
        int cursor = 0;

        public NavigableSkipListIterator() {
            Iterator<E> temp = (Iterator<E>) list.iterator();
            while (temp.hasNext()) {
                arrayList.add(0,temp.next());
            }
        }
        @Override
        public void remove() {
            Iterator.super.remove();
        }
        @Override
        public boolean hasNext() {
            return arrayList.size() > cursor;
        }

        @Override
        public E next() {
            return arrayList.get(cursor++);
        }
    }
}

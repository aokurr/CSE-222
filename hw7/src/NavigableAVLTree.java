import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class NavigableAVLTree<E extends Comparable<E>> implements NavigableSet<E> {
    AVLTree<E> avlTree;
    private int size;
    public NavigableAVLTree(){
        avlTree = new AVLTree<>();
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
        if(avlTree.add(e)){
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
        if(avlTree.remove((E) o)){
            --size;
            return true;
        }
        return false;
    }
    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException();
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
        return new NavigableAVLTreeIterator<>();
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

    /**
     * Returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
     * The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.
     * @param toElement - high endpoint of the returned set
     * @param inclusive - true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     */

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        NavigableAVLTree<E> result = new NavigableAVLTree<>();
        Iterator<E> iterator = iterator();

        while(iterator.hasNext()){
            E temp = iterator.next();
            if((temp.compareTo(toElement) == 0 && inclusive ) || (temp.compareTo(toElement) < 0)){
                result.add(temp);
            }
        }
        return result;
    }

    /**
     *Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.
     * The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.
     * @param fromElement - low endpoint of the returned set
     * @param inclusive - true if the low endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        NavigableAVLTree<E> result = new NavigableAVLTree<>();
        Iterator<E> iterator = iterator();

        while(iterator.hasNext()){
            E temp = iterator.next();
            if((temp.compareTo(fromElement) == 0 && inclusive ) || temp.compareTo(fromElement) > 0)
                result.add(temp);
        }
        return result;
    }

    @Override
    public Comparator<? super E> comparator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a view of the portion of this set whose elements are strictly less than toElement. The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.
     * @param toElement - high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly less than toElement
     */
    @Override
    public SortedSet<E> headSet(E toElement) {
        NavigableAVLTree<E> result = new NavigableAVLTree<>();
        Iterator<E> iterator = iterator();

        while(iterator.hasNext()){
            E tempItem = iterator.next();
            if(tempItem.compareTo(toElement) < 0)
                result.add(tempItem);
        }
        return result;
    }

    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     * The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.
     * @param fromElement - low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    @Override
    public SortedSet<E> tailSet(E fromElement) {
        NavigableAVLTree<E> result = new NavigableAVLTree<>();
        Iterator<E> iterator = iterator();

        while(iterator.hasNext()){
            E temp = iterator.next();
            if(temp.compareTo(fromElement) >= 0 )
                result.add(temp);
        }
        return result;
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
    class NavigableAVLTreeIterator<E extends Comparable<E>> implements Iterator<E>{
        Queue<E> queue = new LinkedList<>();
        public NavigableAVLTreeIterator() {
            BinaryTree.Node<E> root = (BinaryTree.Node<E>) avlTree.root;
            addToQueue(root);
        }
        private void addToQueue(BinaryTree.Node<E> root){
            if(root == null) return;
            addToQueue(root.left);
            queue.add(root.data);
            addToQueue(root.right);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public boolean hasNext() {
            return queue.size() > 0;
        }
        @Override
        public E next() {
            return queue.poll();
        }

    }
}

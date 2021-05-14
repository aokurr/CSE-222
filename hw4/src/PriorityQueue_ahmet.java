import java.util.*;

public class PriorityQueue_ahmet<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E> {
    // Data Fields
    /** The ArrayList to hold the data. */
    private ArrayList<E> theData;
    /** The ArrayList to hold the data count. */
    public ArrayList<Integer> theDataCount;
    /** An optional reference to a Comparator object. */
    Comparator<E> comparator = null;

    public PriorityQueue_ahmet() {
        theData = new ArrayList<>();
        theDataCount=new ArrayList<>();
    }

    /** Creates a heap‐based priority queue with the specified initial
     capacity that orders its elements according to the specified
     comparator.
     @param cap The initial capacity for this priority queue
     @param comp The comparator used to order this priority queue
     @throws IllegalArgumentException if cap is less than 1
     */
    public PriorityQueue_ahmet(int cap, Comparator<E> comp) {
        if (cap < 1)
            throw new IllegalArgumentException();
        theData = new ArrayList<>();
        comparator = comp;
    }


    /**
     * Returns an iterator
     * @return gives iterator
     */
    public QueueIterator_ahmet iterator(){
        return new QueueIterator_ahmet();
    }

    /**
     * returns the size of the heap
     * @return
     */
    @Override
    public int size() {
        return theData.size();
    }

    /** Insert an item into the priority queue.
     pre: The ArrayList theData is in heap order.
     post: The item is in the priority queue and
     theData is in heap order.
     @param item The item to be inserted
     */
    @Override
    public boolean offer(E item) {
        // Add the item to the heap.
        int index=theData.indexOf(item);
        if(index!=-1){
            int count=theDataCount.get(index);
            count++;
            theDataCount.set(index,count);
            return false;
        }
        theDataCount.add(1);
        theData.add(item);
        // child is newly inserted item.
        int child = theData.size() - 1;
        int parent = (child - 1) / 2; // Find child's parent.
        // Reheap
        while (parent >= 0 && compare(theData.get(parent),theData.get(child)) < 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }

    /** Remove an item from the priority queue
     pre: The ArrayList theData is in heap order.
     post: Removed bigger item, theData is in heap order.
     @return The item with the smallest priority value or null if empty.
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E result = theData.get(0);
        if (theData.size() == 1) {
            theData.remove(0);
            return result;
        }
        if(theDataCount.get(0)>1){
            int count=theDataCount.get(0);
            count--;
            theDataCount.set(0,count);
            return result;
        }

        theData.set(0, theData.remove(theData.size() - 1));
        theDataCount.set(0,theDataCount.remove(theDataCount.size()-1));
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size()) {
                break;
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild;

            if (rightChild < theData.size()
                    && compare(theData.get(leftChild),
                    theData.get(rightChild)) < 0) {
                minChild = rightChild;
            }
            if (compare(theData.get(parent),
                    theData.get(minChild)) < 0) {
                swap(parent, minChild);
                parent = minChild;
            } else { // Heap property is restored.
                break;
            }
        }
        return result;
    }

    /**
     * Returns the bigger entry without removing it. If the queue is empty, returns null
     * @return E
     */
    @Override
    public E peek() {
        return theData.get(0);
    }

    /**
     * swaps the indexes of data and data count
     * @param parent
     * @param minChild
     */
    private void swap(int parent, int minChild) {
        E temp = theData.get(parent);
        theData.set(parent, theData.get(minChild));
        theData.set(minChild,temp);

        int tmp=theDataCount.get(parent);
        theDataCount.set(parent, theDataCount.get(minChild));
        theDataCount.set(minChild,tmp);

    }
    /** Compare two items using either a Comparator object's compare method
     or their natural ordering using method compareTo.
     @pre: If comparator is null, left and right implement Comparable<E>.
     @param left One item
     @param right The other item
     @return Negative int if left less than right,
     0 if left equals right,
     positive int if left > right
     @throws ClassCastException if items are not Comparable
     */
    private int compare(E left, E right) {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        } else { // Use left's compareTo method.
            return ((Comparable<E>) left).compareTo(right);
        }
    }

    /**
     * heap prints
     * @return
     */
    public String toString(){
        return theData.toString();
    }

    /**
     *the specified value is searched in heap
     * @param data
     * @return
     */
    public boolean search(E data){
        return theData.contains(data);
    }

    /**
     * 2 structures are combined and the combination is made in the first structure
     * @param other
     */
    public void merge(PriorityQueue_ahmet<E> other){
        while(!other.isEmpty()){
            this.offer(other.poll());
        }

    }

    /**
     * Removing ith largest element from the Heap
     * @param a
     * @return
     */
    public boolean remove_largest_element(int a){
        if(a<1 || a>size()-1){
            System.out.println("yavaş");
        }
        ArrayList<E> tmp=new ArrayList<>();
        ArrayList<Integer> tmp2=new ArrayList<>();

        tmp.addAll(theData);
        tmp2.addAll(theDataCount);
        int index;
        E tmpe = null;
        for(int i=0;i<a;i++){
           tmpe= this.poll();
        }
        theData=tmp;
        theDataCount=tmp2;
        index=theData.indexOf(tmpe);

        if(theDataCount.get(index)>1){
            theDataCount.set(index,theDataCount.get(index)-1);
            return true;
        }

        swap(index,size()-1);
        theData.remove(size()-1);
        theDataCount.remove(size()-1);
        boolean flag=false;
        if(index>0){
            while(true){
                if(index>0 && theData.get(index).compareTo(theData.get((index-1)/2))>0){
                    swap(index,(index-1)/2);
                    index=(index-1)/2;
                    flag=true;
                }
                else{
                    if(flag==true){
                        return flag;
                    }
                    else
                        break;
                }
            }
        }

        int leftchild,rightchild;
        while(true){
            if(index*2+1>=size()-1){
                break;
            }
            leftchild=index*2+1;
            rightchild=leftchild+1;
            if(theData.get(leftchild).compareTo(theData.get(rightchild))>0 && theData.get(index).compareTo(theData.get(leftchild))<0){
                swap(index,leftchild);
                index=leftchild;
            }
            else if(theData.get(rightchild).compareTo(theData.get(leftchild))>0 && theData.get(index).compareTo(theData.get(rightchild))<0){
                swap(index,rightchild);
                index=rightchild;
            }
            else
                break;
        }
        return true;
    }

    /**
     * removes the specified element from the heap
     * @param item
     * @return
     */
    public boolean remove_element(E item){
        int index=theData.indexOf(item);

        if(theDataCount.get(index)>1){
            theDataCount.set(index,theDataCount.get(index)-1);
            return true;
        }
        if(index==size()-1){
            theData.remove(size()-1);
            theDataCount.remove(size()-1);
            return true;
        }
        swap(index,size()-1);
        theData.remove(size()-1);
        theDataCount.remove(size()-1);
        boolean flag=false;
        if(index>0){
            while(true){
                if(index>0 && theData.get(index).compareTo(theData.get((index-1)/2))>0){
                    swap(index,(index-1)/2);
                    index=(index-1)/2;
                    flag=true;
                }
                else{
                    if(flag==true){
                        return flag;
                    }
                    else break;
                }
            }
        }

        int leftchild,rightchild;
        while(true){
            if(index*2+1>=size()-1){
                break;
            }
            leftchild=index*2+1;
            rightchild=leftchild+1;
            if(theData.get(leftchild).compareTo(theData.get(rightchild))>0 && theData.get(index).compareTo(theData.get(leftchild))<0){
                swap(index,leftchild);
                index=leftchild;
            }
            else if(theData.get(rightchild).compareTo(theData.get(leftchild))>0 && theData.get(index).compareTo(theData.get(rightchild))<0){
                swap(index,rightchild);
                index=rightchild;
            }
            else
                break;
        }
        return true;
    }

    /**
     * the specified value is searched in heap
     * @param data
     * @return
     */
    public boolean containQueue(E data){
        return theData.contains(data);
    }

    /**
     * Returns the index of the specified element n in the heap
     * @param data
     * @return
     */
    public int containQueueNumber(E data){
        return theData.indexOf(data);
    }

    /**
     * finds the mode of the heap and returns it as an arraylist
     * @return
     */
    public ArrayList<Integer> modequeue(){
        int max,index;
        max=theDataCount.get(0);
        index=0;
        for(int i=0;i<size();i++){
            if(theDataCount.get(i)>max){
                max=theDataCount.get(i);
                index=i;
            }
        }
        ArrayList<Integer> mod=new ArrayList<>();
        mod.add(0,theDataCount.get(index));
        mod.add(1, (Integer) theData.get(index));
        return  mod;
    }

    private class QueueIterator_ahmet implements Iterator_ahmet<E> {

        private Iterator iter;
        private E lastReturned;
        public QueueIterator_ahmet(){
            iter = theData.iterator();
        }

        /**
         * sets the specified element of the heap
         * @param item
         * @return
         */
        public E set(E item) {
            int index=theData.indexOf(lastReturned);
            int leftchild,rightchild;
            leftchild=index*2+1;
            rightchild=leftchild+1;
            theData.set(index,item);
            while(true){
                if(index*2+1>=size()){
                    break;
                }
                leftchild=index*2+1;
                rightchild=leftchild+1;
                if(theData.get(leftchild).compareTo(theData.get(rightchild))>0 && theData.get(index).compareTo(theData.get(leftchild))<0){
                    swap(index,leftchild);
                    index=leftchild;
                }
                else if(theData.get(rightchild).compareTo(theData.get(leftchild))>0 && theData.get(index).compareTo(theData.get(rightchild))<0){
                    swap(index,rightchild);
                    index=rightchild;
                }
                else
                    break;
            }
            while(true){
                if(theData.get(index).compareTo(theData.get((index-1)/2))>0){
                    swap(index,(index-1)/2);
                    index=(index-1)/2;
                }
                else
                    break;
            }
            return null;

        }
        /**
         * Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         */
        @Override
        public E next()
        {
            lastReturned = (E) iter.next();
            return lastReturned;
        }

    }


}

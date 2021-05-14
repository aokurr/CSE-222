import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList_ahmet<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /*NODE*/

    private static class Node<E>{
        private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E data_kullanici){
            data=data_kullanici;
            next=null;
        }
        private Node (E data_kullanici,Node<E> a){
            data=data_kullanici;
            next=a;
        }
    }
    /*LIST ITERATOR*/

    /**
     * Inserts the specified element at the beginning of this list.
     * @param anEntry
     */
    public void addFirst(E anEntry){
        try {
            add(anEntry,0);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * @param data
     */
    public void addLast(E data){
        try {
            add(data,size);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param data
     * @param index
     * @throws Exception
     */
    public void add(E data,int index)throws Exception{
        if(index<0 || index>size){
            throw new ahmets_exceptions("error1");
        }
        Iterator(index).add(data);
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     */
    public E get(int index){
        try {
            return Iterator(index).next();
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * Returns the first element in this list.
     * @return the first element in this list
     * @throws NoSuchElementException
     */

    public E getFirst()throws NoSuchElementException {
        if(head==null){
            throw new NoSuchElementException("error");
        }
        return head.data;
    }

    /**
     * Returns the last element in this list.
     * @return the last element in this list
     * @throws NoSuchElementException
     */
    public E getLast()throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("error");
        }
        return tail.data;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index-index of the element to replace
     * @param res-- element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E res)throws IndexOutOfBoundsException{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("error");
        }
        Node<E> iter = head;
        for(int i=0 ; i<index ;++i){
            iter = iter.next;
        }
        iter.data = res;
        return res;
    }

    /**
     *Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param -element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(E data){
        Node<E> iter = head;
        int index = 0;
        while(iter != null){
            if(iter.data.equals(data)){
                return index;
            }
            iter = iter.next;
            index++;
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index
     */
    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("Incorrect entry");
            return;
        }
        if(index == 0){
            removeFirst();
        }
        else if(index == size -1){
            removeLast();
        }
        else{
            Node<E> iter = head;
            for (int i = 0 ; i < index-1 ;++i){
                iter = iter.next;
            }
            iter.next = iter.next.next;
            iter.next.prev = iter;
        }
        --size;
    }

    /**
     * Removes the last element from this list.
     */
    public void removeLast(){
        tail = tail.prev;
        tail.next = null;

    }

    /**
     * Removes the first element from this list.
     */
    public void removeFirst(){
        if(head == null){
            System.out.println("Incorrect entry");
        }
        else if(size!=1){
            head = head.next;
            head.prev = null;
        }
        else
            head=null;
    }
    private class MyListIterator<E> implements ListIterator<E> {
        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index = 0;

        public MyListIterator(int i)throws Exception {
            if (i < 0 || i > size) {

                throw new Exception("sad");
            }
            lastItemReturned = null;
            if (i == size) {
                index = size;
                nextItem = null;
            }
            else {
                nextItem = (Node<E>) head;
                for (int index = 0; index < i; index++)
                    nextItem = nextItem.next;
            }
        }

        /**
         * Returns true if this list iterator has more elements when traversing the list in the forward direction
         * @return true if the list iterator has more elements when traversing the list in the forward direction
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /**
         *Returns the next element in the list and advances the cursor position
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        @Override
        public E next()throws NoSuchElementException {
            if (hasNext() == false) {
                throw new NoSuchElementException("error");
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            ++index;

            return lastItemReturned.data;
        }

        /**
         *Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * @return true if the list iterator has more elements when traversing the list in the reverse direction
         */
        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Returns the previous element in the list and moves the cursor position backwards
         * @return the previous element in the list
         * @throws NoSuchElementException  if the iteration has no previous element
         */
        @Override
        public E previous()throws NoSuchElementException{
            if (!hasPrevious()) {
                throw new NoSuchElementException("error");
            }
            if (nextItem == null)
                nextItem = (Node<E>) tail;
            else
                nextItem = nextItem.prev;
            lastItemReturned = nextItem;
            --index;
            return lastItemReturned.data;

        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next()
         * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
         */
        @Override
        public int nextIndex() {

            return index;
        }

        /**
         *Returns the index of the element that would be returned by a subsequent call to previous().
         * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
         */
        @Override
        public int previousIndex() {
            return index-1;
        }

        /**
         * Removes from the list the last element that was returned by next() or previous() (optional operation)
         * @throws UnsupportedOperationException
         */
        @Override
        public void remove()throws UnsupportedOperationException {
            if(lastItemReturned==null){
                throw new UnsupportedOperationException("error");
            }

            if(lastItemReturned.next!=null){
                lastItemReturned.next.prev=lastItemReturned.prev;

            }
            else{
                tail=(Node) lastItemReturned.prev;
                if(tail!=null){
                    tail.next=null;
                }
                else
                    head=null;
            }

            if(lastItemReturned.prev!=null){
                lastItemReturned.prev.next=lastItemReturned.next;
            }
            else{
                head=(Node) lastItemReturned.next;
                if(head!=null){
                    head.prev=null;
                }
                else{
                    tail=null;
                }
            }
            lastItemReturned=null;
            size--;
            index--;
            return ;

        }

        /**
         * the element with which to replace the last element returned by next or previous
         * @param e
         */
        @Override
        public void set(E e) {
            lastItemReturned.data=e;
            return;

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * @param e-the element to insert
         */
        @Override
        public void add(E e){
            if(head==null){
                head=(Node) new Node<E>(e);
                tail=head;
            }
            else if(nextItem==head){
                Node<E>tmp=new Node<E>(e);
                tmp.next=nextItem;
                nextItem.prev=tmp;
                head=(Node) tmp;
            }
            else if(nextItem==null){
                Node<E>tmp=new Node<E>(e);
                tail.next=(Node) tmp;
                tmp.prev=(Node) tail;
                tail=(Node) tmp;
            }
            else{
                Node<E>tmp=new Node<E>(e);
                tmp.prev=nextItem.prev;
                tmp.next=nextItem;
                nextItem.prev.next=tmp;
                nextItem.prev=tmp;
            }
            size++;
            index++;
            lastItemReturned=null;

        }

    }
    public ListIterator<E> Iterator(int i)throws Exception
    {
        return new MyListIterator<E>(i);
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int getSize(){
        return  size;
    }

    /**
     * prints all elements
     * @return -return the all elements
     */
    public String toString(){
        StringBuilder result=new StringBuilder();
        try {
            int k=1;
            ListIterator iter = Iterator(0);
            while(iter.hasNext()){
                result.append("$$$$$$$$$$ "+k+" BRANCH$$$$$$$$$\n\n"+iter.next());
                k++;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return result.toString();
    }
}

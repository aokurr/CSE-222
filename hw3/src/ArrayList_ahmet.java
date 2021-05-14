public class ArrayList_ahmet <E>{
    private E data[];
    private int capacity;
    private int size=0;
    private static final int MAX_NUMBER =20;
    public ArrayList_ahmet(){
        capacity=MAX_NUMBER;
        data=(E[])new Object[capacity];
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param entry element to be inserted
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public void add(int index,E entry)throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>capacity){
            throw new ArrayIndexOutOfBoundsException("ERROR ADD");
        }
        if(size==capacity){
            reallocate();
        }

        for(int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=entry;
        size++;
    }

    /**
     * reallocate if the size==capacity
     */
    private void reallocate(){
        capacity*=2;
        E tmp[]=(E[]) new Object[capacity];
        for(int i=0;i<size;i++){
            tmp[i]=data[i];
        }
        data=tmp;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index)throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("error get");
        }
        return data[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param entry element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E set(int index,E entry)throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("error set");
        }
        E old=data[index];
        data[index]=entry;
        return old;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws ArrayIndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E remove(int index)throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("error remove");
        }
        E returnValue=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        return returnValue;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int getSize(){
        return size;
    }

    /**
     * prints all elements
     * @return -return the all elements
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

       for(int i=0;i<size;i++){
           result.append(data[i]);
           result.append(" ");
       }
        return result.toString();
    }

    /**
     *Returns true if this list contains the specified element.
     * @param entry element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public int contains(E entry){
        for(int i=0;i<size;i++){
            if(data[i].equals(entry)){
                return i;
            }
        }
        return -1;
    }
}

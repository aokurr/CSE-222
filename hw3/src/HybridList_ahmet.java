import java.util.ListIterator;

public class HybridList_ahmet<E> {
    private  Node<E> head = null;
    private int size = 0;
    private static int MAX_VALUE=40;

    private static class Node<E> {
        private ArrayList_ahmet<E> data;
        private Node<E> next;
        private String which_furniture;


        private Node(ArrayList_ahmet<E> data_kullanici,String which_furniture){
            data=data_kullanici;
            this.which_furniture=which_furniture;
            next=null;
        }
        private Node (ArrayList_ahmet<E> data_kullanici, Node<E> a){
            data=data_kullanici;
            next=a;
        }
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * @param anEntry the element to add
     * @param which_furniture furniture name
     */
    public void addFirst(ArrayList_ahmet<E> anEntry,String which_furniture){
        if (head != null) {
            Node<E> temp = new Node<E>(anEntry,which_furniture);
            temp.next = head;
            head = temp;
        }
        else {
            head = new Node<E>(anEntry,which_furniture);
        }
        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * @param index index at which the specified element is to be inserted
     * @param data data to be inserted
     * @param which_furniture furniture name
     */
    public void add(int index, ArrayList_ahmet<E> data,String which_furniture){
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(data,which_furniture);
        }
        else if (index == size-1) {
            addLast(data,which_furniture);
        }
        else {
            Node<E> iter1 = head;
            Node<E> iter2;
            for(int i=0; i<index-1; ++i)
                iter1 = iter1.next;
            iter2 = iter1.next;
            iter1.next = new Node<E>(data,which_furniture);
            iter1.next.next = iter2;
            size++;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * @param data the element to add
     * @param which_furniture furniture name
     */
    public void addLast(ArrayList_ahmet<E> data,String which_furniture){
        if(size==0){
            addFirst(data,which_furniture);
        }
        Node<E> iter = head;
        while(iter.next != null)
            iter = iter.next;
        iter.next = new Node<E>(data,which_furniture);
        size++;
    }

    /**
     * prints all elements
     * @return -return the all elements
     */
    public String toString(){
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();

        while (nodeRef != null) {
            result.append("********"+nodeRef.which_furniture+"**********\n");
            result.append(nodeRef.data);
            if (nodeRef.next != null)
                result.append("\n");

            nodeRef = nodeRef.next;
        }
        return result.toString();
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index  index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException  if the index is out of range (index < 0 || index >= size())
     */
    public ArrayList_ahmet<E> get(int index)throws IndexOutOfBoundsException{
        if(index < 0 || index >= size){

            throw new IndexOutOfBoundsException("ERROR");
        }
        Node<E> iter = head;
        for(int i=0 ; i<index ;++i)
            iter = iter.next;

        return iter.data;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index  index of the element to replace
     * @param res  element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public ArrayList_ahmet<E> set(int index, ArrayList_ahmet<E> res){
        if (index < 0 || index >= size) {
            System.out.println("Incorrect ındex");
            return null;
        }
        Node<E> iter = head;
        for (int i = 0 ; i < index; ++i)
            iter = iter.next;

        iter.data = res;
        return res;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index the index of the element to be removed
     */
    public void remove(int index){
        if (index < 0 || index >= size) {
            System.out.println("Incorrect remove ındex");
            return;
        }
        if (index == 0)
            removeFirst();
        else if (index == size -1)
            removeLast();
        else{
            Node<E> iter = head;
            for (int i = 0 ; i < index-1; ++i){
                iter = iter.next;
            }
            iter.next = iter.next.next;
        }
        size--;
    }

    /**
     * Removes the last element from this list.
     */
    public void removeLast(){
        Node<E> iter = head;
        while (iter.next.next != null){
            iter = iter.next;
        }
        iter.next = null;
    }

    /**
     * Removes  the first element from this list.
     */
    public void removeFirst(){
        if (head == null) {
            System.out.println("Incorrect remove");
        }
        else {
            head = head.next;
        }
    }

    /**
     * Adds elements to Arraylist data
     * @param entry furniture
     * @return true if process succesful
     * @throws IndexOutOfBoundsException
     */
    public boolean add_new_item(furniture entry)throws IndexOutOfBoundsException{
        Node<E> it=head;
        boolean flag=false;
        if(head==null){
            throw new   IndexOutOfBoundsException("error");
        }

        while(it!=null){
            if(it.which_furniture.equals(entry.getName())){
                flag=true;
                if(MAX_VALUE>it.data.getSize()){
                    break;
                }
            }
            it=it.next;
        }

        if(it==null && flag==true){
            ArrayList_ahmet<E> new_data=new ArrayList_ahmet<E>();
            new_data.add(0, (E) entry);
            addLast(new_data, entry.getName());
            return true;
        }
        furniture tmp;
        flag=false;
        for(int i=0;i<it.data.getSize();i++){
            tmp=(furniture) it.data.get(i);
            if(tmp.equals(entry)){
                tmp.add_item();
                it.data.set(i,(E) tmp);
                return  true;
            }
        }
        it.data.add(0, (E) entry);
        return true;
    }

    /**
     * remove elements to Arraylist data
     * @param furniture_name furniture name
     * @param color_ıd color id
     * @param model_ıd model id
     * @return tru if the process succesful
     */
    public boolean remove_item(String furniture_name,int color_ıd,char model_ıd){
        Node<E> it=head;
        Node<E>it2=head;
        int index=0;
        while (it!=null){
            if(it.which_furniture.equals(furniture_name)==true){
                it2=it;
                break;
            }
            index++;
            it=it.next;
        }
        if(it==null){
            return false;
        }

        for(int i=0;i<it2.data.getSize();i++){
            furniture tmp= (furniture) it2.data.get(i);
            if(tmp.getColor()==color_ıd && tmp.getModel()==model_ıd){
                if(tmp.delete_item()==false){
                    it2.data.remove(i);
                    break;
                }
            }
        }
        if(it2.data.getSize()==0){
            remove(index);
        }

        return true;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int getSize(){return size;}

    /**
     * Returns true if this lists datas contains the specified element
     * @param furniture_name furniture name
     * @param model mode id
     * @param color color id
     * @return true if this list datas contains the specified element
     */
    public boolean is_in(String furniture_name,char model,int color){
        Node<E> it=head;
        furniture tmp;
        while(it!=null){
            if(it.which_furniture.equals(furniture_name)){
                for(int i=0;i<it.data.getSize();i++){
                    tmp=(furniture) it.data.get(i);
                    if(tmp.getModel()==model&&tmp.getColor()==color){
                        return true;
                    }
                }
            }
            it=it.next;
        }
        return false;
    }
}

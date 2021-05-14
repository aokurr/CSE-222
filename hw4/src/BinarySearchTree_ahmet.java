
import java.io.Serializable;
import java.util.ArrayList;

public class BinarySearchTree_ahmet<E extends Comparable<E>> implements Serializable {

    protected Node<E> root;
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;
    int  deleteReturn=0;

    protected static class Node<E extends Comparable<E>>
    {
        protected PriorityQueue_ahmet<E> data;
        protected Node<E> left;
        protected Node<E> right;
        public Node(PriorityQueue_ahmet<E> data)
        {
            this.data = data;
            left = null;
            right = null;
        }
        public String toString()
        {
            return data.toString();
        }
    }

    public BinarySearchTree_ahmet()
    {
        root = null;
    }
    protected BinarySearchTree_ahmet(Node<E> root)
    {
        this.root = root;
    }
    /** Constructs a new binary tree with data in its root leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinarySearchTree_ahmet(PriorityQueue_ahmet<E> data, BinarySearchTree_ahmet<E> leftTree, BinarySearchTree_ahmet<E> rightTree)
    {
        root = new Node<E>(data);
        if (leftTree != null){
            root.left = leftTree.root;
        }
        else{
            root.left = null;
        }
        if (rightTree != null){
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }
    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinarySearchTree_ahmet<E> getLeftSubtree()
    {
        if (root != null && root.left != null) {
            return new BinarySearchTree_ahmet(root.left);
        } else {
            return null;
        }
    }
    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf()
    {
        return (root.left == null && root.right == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Performs a recursive pre‐order traversal of the tree,
     * applying the action specified in the consumer object
     * @param node
     * @param depth
     * @param sb
     */
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" "); // indentation
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item)
    {
        root = add(root, item);
        return addReturn;
    }
    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, if the specified value is present, the counter is incremented
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node<E> add(Node<E> localRoot, E item)
    {
        if (localRoot == null) {
            addReturn = true;
            PriorityQueue_ahmet tmp=new PriorityQueue_ahmet();
            tmp.offer(item);
            return new Node<E>(tmp);
        }
        if (localRoot.data.size()<7 || localRoot.data.containQueue(item)){
            localRoot.data.offer(item);
            return localRoot;
        }
        else if (item.compareTo(localRoot.data.peek()) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return returns the number of occurrences of the item after removal
     @throws ClassCastException if target does not implement
     Comparable
     */
    public int delete(E target)
    {
        root=delete(root,target);
        return deleteReturn;
    }

    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.data.peek();
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }
    }

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn=-1;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot.data.peek());
        int index=localRoot.data.containQueueNumber(item);
        if(index>-1) {

            if(localRoot.data.size()>1 || localRoot.data.theDataCount.get(index)>1){
                deleteReturn=localRoot.data.theDataCount.get(index);
                deleteReturn--;
                localRoot.data.remove_element(item);
                return localRoot;
            }
            deleteReturn = 0;
            if (localRoot.left == null) {
                return localRoot.right;
            }
            else if (localRoot.right == null) {
                return localRoot.left;
            }
            else {
                if (localRoot.left.right == null) {

                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else{

                    Iterator_ahmet iter=localRoot.data.iterator();
                    iter.next();
                    iter.set(findLargestChild(localRoot.left));
                    return localRoot;
                }
            }

        }
        else if (compResult < 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }

        else{
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
    }
    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return returns the number of occurrences of the item in the BSTHeapTree
     */
    public int find(E target){
        int occurancy=find(root,target);
        if(occurancy<0){
            return 0;
        }
        return occurancy;
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The number of occurrances, if found, otherwise -1
     */
    private int find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return -1;
        int compResult = target.compareTo(localRoot.data.peek());
        int index=localRoot.data.containQueueNumber(target);
        if (index>-1)
            return localRoot.data.theDataCount.get(index);
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /** Starter method find mode.
     * finds the mode of the BSTHeapTree
     * @return Returns the arraylist holding the mode and how many
     */
    public ArrayList<Integer> find_mode(){
        ArrayList<Integer> mode=new ArrayList<>();
        mode=root.data.modequeue();
       mode= find_mode(root,mode);
        return mode;
    }
    /**
     * finds the mode of the BSTHeapTree
     * @return Returns the arraylist holding the mode and how many
     */
    private ArrayList<Integer> find_mode(Node<E> localRoot,ArrayList<Integer> mode){
        if(localRoot==null){
            return mode;
        }
        mode=find_mode(localRoot.right, mode);
        if(mode.get(0).compareTo(localRoot.data.modequeue().get(0))<0){
            mode=localRoot.data.modequeue();
        }
        mode=find_mode(localRoot.left,mode);

        return mode;
    }
}

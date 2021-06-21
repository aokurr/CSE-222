import java.util.ArrayList;

public class HeapSort<T> implements Sorts_Method<T> {
    /**
     * Sort the array using heapsort algorithm.
     * @param table The arraylist to be sorted
     * @param choice Comparable items selection
     */
    public void sort(ArrayList<T> table,int choice) {
        buildHeap(table,choice);
        shrinkHeap(table,choice);
    }

    /**
     * buildHeap transforms the table into a heap
     * @param table
     * @param choice
     */
    private  void buildHeap(ArrayList<T> table,int choice) {
        int n = 1;
        while (n < table.size()) {
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent.

            while (parent >= 0 && compare_A((product)table.get(parent),(product)table.get(child),choice) < 0) {
                swap(table, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    /**
     * shrinkHeap transforms a heap into a sorted array.
     * @param table
     * @param choice
     */
    private  void shrinkHeap(ArrayList<T> table,int choice) {
        int n = table.size();

        while (n > 0) {
            n--;
            swap(table, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;

                int maxChild = leftChild;

                if (rightChild < n && compare_A((product)table.get(leftChild),(product) table.get(rightChild),choice) < 0) {
                    maxChild = rightChild;
                }

                if (compare_A((product)table.get(parent),(product) table.get(maxChild),choice) < 0) {
                    swap(table, parent, maxChild);
                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Swap the items in table.get(i) and table.get(j).
     * @param table
     * @param i
     * @param j
     */
    private  void swap(ArrayList<T> table, int i, int j) {
        product temp = (product) table.get(i);
        table.set(i,table.get(j));
        table.set(j, (T) temp);
    }

    /**
     * myself compareTo method Multiple comparisons are made
     * @param p1
     * @param p2
     * @param choice
     * @return
     */
    private  int compare_A(product p1, product p2, int choice)
    {
        Integer x, y;
        switch (choice) {
            case 1:
                return p1.getProduct_name().compareTo(p2.getProduct_name());
            case 2:
                x = Integer.parseInt(p1.getPrice());
                y = Integer.parseInt(p2.getPrice());
                return x.compareTo(y);
            case 3:
                x = Integer.parseInt(p1.getDiscounted());
                y = Integer.parseInt(p2.getDiscounted());
                return x.compareTo(y);
        }
        return -10;
    }
}

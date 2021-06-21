import java.util.ArrayList;

public class shellsort<T> implements Sorts_Method<T> {
    /**
     * Sort the table using Shell sort algorithm.
     * @param table
     * @param choice
     */
    public void sort(ArrayList<T> table, int choice) {
        int gap = table.size() / 2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < table.size(); nextPos++) {
                insert(table, nextPos, gap,choice);
            }
            if (gap == 2) {
                gap = 1;
            }
            else {
                gap = (int) (gap / 2.2);
            }
        } // End while.
    }

    /**
     * Inserts element at nextPos where it belongs in array.
     * @param table
     * @param nextPos
     * @param gap
     * @param choice
     */
    private void insert(ArrayList<T> table, int nextPos, int gap,int choice) {
        product nextVal = (product) table.get(nextPos);

        while ((nextPos > gap - 1) && compare_A(nextVal, (product) table.get(nextPos - gap),choice) < 0) {

            table.set(nextPos,table.get(nextPos - gap));
            nextPos -= gap;
        }
        table.set(nextPos, (T) nextVal);
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

import java.util.ArrayList;

public class QuickSort<T>implements Sorts_Method<T> {
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

    /**
     * Sort the table using the quicksort algorithm.
     * @param table
     * @param choice
     */
    public void sort(ArrayList<T> table, int choice)
    {
        quickSort(table, 0, table.size() - 1, choice);
    }

    /**
     * Sort a part of the table using the quicksort algorithm.
     * @param table
     * @param first
     * @param last
     * @param choice
     */
    private void quickSort(ArrayList<T> table, int first, int last, int choice)
    {
        if (first < last) {
            int pivIndex = partition(table, first, last, choice);
            quickSort(table, first, pivIndex - 1, choice);
            quickSort(table, pivIndex + 1, last, choice);
        }
    }

    /**
     * Partition the table so that values from first to pivIndex
     * are less than or equal to the pivot value, and values from
     * @param table
     * @param first
     * @param last
     * @param choice
     * @return
     */
    private int partition(ArrayList<T> table,int first, int last, int choice)
    {
        product pivot = (product) table.get(first);
        int up = first;
        int down = last;
        do {
            while ((up < last) && (compare_A(pivot, (product) table.get(up), choice) >= 0)) {
                up++;
            }
            while (compare_A(pivot, (product) table.get(down), choice) < 0) {
                down--;
            }
            if (up < down) {
                swap(table, up, down);
            }
        }
        while (up < down);
        swap(table, first, down);
        return down;
    }

    /**
     * swap the two value
     * @param table
     * @param i
     * @param j
     */
    private void swap(ArrayList<T> table, int i, int j)
    {
        T temp = table.get(i);
        table.set(i, table.get(j));
        table.set(j, temp);
    }
}
import java.util.*;

public class test {
    public static void main(String[] args){
        driver_part1();
        driver_part2();
    }
    public static void driver_part1(){
        System.out.println("$$$$$$$$$$PART 1 TEST$$$$$$$$$\n");
        PriorityQueue_ahmet<Integer> heap1 = new PriorityQueue_ahmet<>();
        PriorityQueue_ahmet<Integer> heap2 = new PriorityQueue_ahmet<>();
        int min = 0;
        int max = 15;
        int max_numbers=14;
        int random_int;
        ArrayList<Integer> random_numbers=new ArrayList<>();

        for(int i=0;i<max_numbers/2;i++){
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            heap1.offer(random_int);
            random_numbers.add(random_int);
        }
        System.out.println("Random_Array_1 FOR HEAP_1");
        System.out.println("RANDOM ARRAY 1->"+random_numbers);
        System.out.println("HEAP 1->"+heap1);
        random_numbers.clear();
        for(int i=0;i<max_numbers/2;i++){
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            heap2.offer(random_int);
            random_numbers.add(random_int);
        }
        System.out.println("\nRandom_Array_2 FOR HEAP_2");
        System.out.println("RANDOM ARRAY 2->"+random_numbers);
        System.out.println("HEAP 2->"+heap2);

        System.out.println("\n******MERGE METHOD*******");
        System.out.println("MERGE HEAP_1 AND HEAP_2");
        heap1.merge(heap2);
        System.out.println("New heap_1->"+heap1);

        System.out.println("\n******Search method for heap_1*********");
        random_numbers.clear();
        min=-5;
        max=15;
        for(int i=0;i<10;i++){
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            if(random_numbers.contains(random_int)){
                i--;
                continue;
            }
            random_numbers.add(random_int);
        }

        for(int i=0;i<10;i++){
            System.out.println(random_numbers.get(i)+" Searh in heap->"+heap1.search(random_numbers.get(i)));
        }

        System.out.println("\n******Removing 3'th largest element *********");
        System.out.println(heap1);
        System.out.println("numbers of added elements->"+heap1.theDataCount);
        System.out.println("\nIf more than 1 of the same element is added, it counts as an element, but is not visible.");
        heap1.remove_largest_element(3);
        System.out.println(heap1);

        System.out.println("\n******ITERATOR SET  2. elemenet ->32 *********");
        Iterator_ahmet iter= heap1.iterator();
        iter.next();
        iter.next();
        iter.set(32);
        System.out.println(heap1);
    }

    public static void driver_part2(){
        System.out.println("\n\n$$$$$$$$$$PART 2 TEST$$$$$$$$$");
        BinarySearchTree_ahmet<Integer> BST_test=new BinarySearchTree_ahmet<>();

        int min = 0;
        int max = 50;
        int max_numbers=30;
        int random_int;
        ArrayList<Integer> random_numbers=new ArrayList<>();

        for(int i=0;i<max_numbers;i++){
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            BST_test.add(random_int);
            random_numbers.add(random_int);
        }

        Collections.sort(random_numbers,Collections.reverseOrder());
        int prev_index=0;
        System.out.println("****RANDOM ARRAY****");
        System.out.printf("%d",random_numbers.get(0));


        for(int i=1;i<max_numbers;i++){
            if (random_numbers.get(prev_index).equals(random_numbers.get(i))) {
                System.out.printf("\t%d",random_numbers.get(i));

                prev_index++;
            }
            else{
                System.out.printf("\n%d",random_numbers.get(i));
                prev_index++;
            }
        }
        System.out.println("\n****BSTHeap Structer****");
        System.out.println(BST_test);


        ArrayList<Integer> random_number_test=new ArrayList<>();
        for(int i=0;i<15;i++){
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            if(random_number_test.contains(random_int)){
                i--;
                continue;
            }
            random_number_test.add(random_int);
        }

        System.out.println("\n****BST MODE [adet,sayı]****");
        System.out.println(BST_test.find_mode());

        System.out.println("\n*****Test to find the numbers below *****");
        System.out.println(random_number_test);
        for(int i=0;i<15;i++){
            random_int=random_number_test.get(i);
            System.out.printf("number= %d\toccurancy= %d\n",random_int,BST_test.find(random_int));
        }


        System.out.println("\n*****Test to remove the numbers below *****");
        System.out.println(random_number_test);
        System.out.println("-1 means = nothing in the there");
        for(int i=0;i<15;i++){
            random_int=random_number_test.get(i);
            System.out.printf("number= %d\toccurancy= %d\n",random_int,BST_test.delete(random_int));
        }
    }
}
















public class main {
    public static void main(String args[]){
        driver();
    }
    public static void driver(){
        System.out.println("\t$$$$$$$$$PART 1$$$$$$$$$$$");
        part1_test();
        System.out.println("\t$$$$$$$$$PART 2.1$$$$$$$$$$$");
        part2_1test();
        System.out.println("\t$$$$$$$$$PART 2.2$$$$$$$$$$$");
        part2_2test();
        System.out.println("\t$$$$$$$$$PART 2.3$$$$$$$$$$$");
        part2_3test();
        System.out.println("\t$$$$$$$$$PART 2.4$$$$$$$$$$$");
        test_theree_class();
        System.out.println("\t$$$$$$$$$TEST PERFORMANCE$$$$$$$$$$$");
        test_performance();
    }
    public static void part1_test(){
        map_ahmet<Integer,String> Galatasaray=new map_ahmet<>();
        Galatasaray.put(1,"Muslera");
        Galatasaray.put(2,"Yedlin");
        Galatasaray.put(3,"Donk");
        Galatasaray.put(4,"Marcao");
        Galatasaray.put(5,"Saracchi");
        Galatasaray.put(6,"Arda");
        Galatasaray.put(7,"Emre");
        Galatasaray.put(8,"Taylan");
        Galatasaray.put(9,"Gedson");
        Galatasaray.put(10,"Babel");
        Galatasaray.put(11,"Halil");
        System.out.println("MAP->"+Galatasaray);

        Iterator_map iter=Galatasaray.iterator(3);
        System.out.println("\n" +"The iterator started from the 3rd key");
        System.out.println("\n" +"next method");
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("\n" +"prev method");
        while (iter.hasPrev()){
            System.out.println(iter.prev());
        }
    }
    public static void part2_1test(){
        AOHashtableChain<Integer,String> test=new AOHashtableChain<>();
        System.out.println("****HashTableChain->LinkedList TableSize=10***");
        test.put(3,"Muslera");
        test.put(12,"Yedlin");
        test.put(13,"Donk");
        test.put(25,"Marcao");
        test.put(23,"Arda");
        test.put(51,"Taylan");
        test.put(42,"Gedson");
        System.out.println("****After Put****");
        System.out.println(test);
        System.out.println("\n****After Remove Key=12,51,23****");
        test.remove(12);
        test.remove(51);
        test.remove(23);
        System.out.println(test);

        System.out.println("\nGet key 42 ->"+test.get(42));
        System.out.println("Get key 111 ->"+test.get(111));
        System.out.println("\n***HashMap Size***->"+test.size());

    }
    public static void part2_2test(){
        AOHashtableChainTree<Integer,String> test=new AOHashtableChainTree<>();
        System.out.println("****HashTableChain->TreeSet TableSize=10***");
        test.put(3,"Muslera");
        test.put(12,"Yedlin");
        test.put(13,"Donk");
        test.put(25,"Marcao");
        test.put(23,"Arda");
        test.put(51,"Taylan");
        test.put(42,"Gedson");
        System.out.println("****After Put****");
        System.out.println(test);
        System.out.println("\n****After Remove Key=12,51,23****");
        test.remove(12);
        test.remove(51);
        test.remove(23);
        System.out.println(test);

        System.out.println("\nGet key 42 ->"+test.get(42));
        System.out.println("Get key 111 ->"+test.get(111));
        System.out.println("\n***HashMap Size***->"+test.size());

    }
    public static void part2_3test(){
        AOHashMapOpenQuadratic<Integer,String> test=new AOHashMapOpenQuadratic<>();
        System.out.println("****HashTableOpen TableSize=10***");
        test.put(3,"Muslera");
        test.put(12,"Yedlin");
        test.put(13,"Donk");
        test.put(25,"Marcao");
        test.put(23,"Arda");
        test.put(51,"Taylan");
        test.put(42,"Gedson");
        System.out.println("****After Put****");
        System.out.println(test);
        System.out.println("\n****After Remove Key=12,51,23****");
        test.remove(12);
        test.remove(51);
        test.remove(23);
        System.out.println(test);

        System.out.println("\nGet key 42 ->"+test.get(42));
        System.out.println("Get key 111 ->"+test.get(111));
        System.out.println("\n***HashMap Size***->"+test.size());

    }
    public static void test_theree_class(){
        AOHashtableChain<Integer,Integer> test1=new AOHashtableChain<>();
        for(int i=0;i<200;i++){
            test1.put(i,i*2);
        }
        for(int i=0;i<200;i++){
            test1.remove(i);
        }
        System.out.println(test1);

        AOHashtableChainTree<Integer,Integer> test2=new AOHashtableChainTree<>();
        for(int i=0;i<200;i++){
            test2.put(i,i*2);
        }
        for(int i=0;i<200;i++){
            test2.remove(i);
        }
        System.out.println(test2);

        AOHashMapOpenQuadratic<Integer,Integer> test3=new AOHashMapOpenQuadratic<>();
        for(int i=0;i<200;i++){
            test3.put(i,i*2);
        }

        for(int i=0;i<200;i++){
            test3.remove(i);
        }
        System.out.println(test3);

    }
    public static void test_performance(){
        long startTime = System.nanoTime();
        AOHashtableChain<Integer,Integer> test1=new AOHashtableChain<>();
        for(int i=0;i<1000;i++){
            test1.put(i,i*2);
        }
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000000000;
        System.out.println("Performance chain->Linkedlist= "+seconds+" second");


        long startTime2 = System.nanoTime();
        AOHashtableChainTree<Integer,Integer> test2=new AOHashtableChainTree<>();
        for(int i=0;i<1000;i++){
            test2.put(i,i*2);
        }
        long endTime2 = System.nanoTime();
        long estimatedTime2 = endTime2 - startTime2;
        double seconds2 = (double)estimatedTime2/1000000000;
        System.out.println("Performance chain->TreeSet= "+seconds2+" second");

        long startTime3 = System.nanoTime();
        AOHashMapOpenQuadratic<Integer,Integer> test3=new AOHashMapOpenQuadratic<>();
        for(int i=0;i<1000;i++){
            test3.put(i,i*2);
        }
        long endTime3 = System.nanoTime();
        long estimatedTime3 = endTime3 - startTime3;
        double seconds3 = (double)estimatedTime3/1000000000;
        System.out.println("Performance Open addressing= "+seconds3+" second");
    }

}

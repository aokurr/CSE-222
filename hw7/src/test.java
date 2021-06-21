import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class test extends BinarySearchTree {
    public static void main(String Args[]) throws InterruptedException {
    part1();
   part2();
        part3();
    }
    public static void part1(){
        System.out.println("PART 1.1\n");
        System.out.println("\t## Testing **NAVIGABLE SKIPLIST** ##");
        NavigableSet<Integer> slist = new NavigableSkipList<>();

        slist.add(140);
        slist.add(28);
        slist.add(21);
        slist.add(92);
        slist.add(59);
        slist.add(17);
        slist.add(81);
        slist.add(91);
        slist.add(-1);

        StringBuilder res1 = new StringBuilder();
        System.out.println("\nTEST descendingIterator");
        Iterator iter = slist.descendingIterator();
        while (iter.hasNext()) {
            res1.append(iter.next());
            res1.append(" ");
        }
        System.out.println(res1);
        StringBuilder res2 = new StringBuilder();
        System.out.println("\nRemoving... 91");
        slist.remove(91);
        iter = slist.descendingIterator();

        while (iter.hasNext()) {
            res2.append(iter.next());
            res2.append(" ");
        }
        System.out.println(res2);


        System.out.println("PART 1.2\n");
        System.out.println("\n\t## TEST **NAVIGABLE AVL TREE** ##");
        NavigableSet<Integer> tree = new NavigableAVLTree<>();

        res1 = new StringBuilder();
        res2 = new StringBuilder();
        tree.add(10);
        tree.add(38);
        tree.add(-128);
        tree.add(-12);
        tree.add(-29);
        tree.add(147);
        tree.add(241);
        tree.add(92);
        tree.add(51);
        System.out.println("\nTEST Iterator");
         iter = tree.iterator();

        while (iter.hasNext()) {
            res1.append(iter.next());
            res1.append(" ");
        }
        System.out.println(res1);
        System.out.println("\nTesting headset->51->false");
        {
            StringBuilder res = new StringBuilder();
            NavigableSet newTree = tree.headSet(51, false);
            Iterator iter1 = newTree.iterator();

            while (iter1.hasNext()) {
                res.append(iter1.next());
                res.append(" ");
            }
            System.out.println(res);
        }
        System.out.println("\nTesting tailset->51->false");
        {
            StringBuilder res = new StringBuilder();
            NavigableSet newTree = tree.tailSet(51, false);
            Iterator iter1 = newTree.iterator();

            while (iter1.hasNext()) {
                res.append(iter1.next());
                res.append(" ");
            }
            System.out.println(res);
        }
        tree.remove(-12);
        iter = tree.iterator();
        while(iter.hasNext()){
            res2.append(iter.next());
            res2.append(" ");
        }
        System.out.println("\nRemoving -12");
        System.out.println(res2);
    }
    public static void part2(){
        System.out.println("\n\n\t\t ### PART 2 ###\n");
        System.out.println("\nTesting with inserting items like RED-BLACK TREE\n");
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.add(14);
        tree1.add(6);
        tree1.add(36);
        tree1.add(20);
        tree1.add(44);
        tree1.add(20);
        tree1.add(22);
        tree1.add(52);
        whichTree(tree1);

        System.out.println("\nTesting with inserting items like AVL TREE\n");
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        tree2.add(200);
        tree2.add(100);
        tree2.add(300);
        tree2.add(50);
        tree2.add(150);
        tree2.add(250);
        tree2.add(350);
        tree2.add(130);
        tree2.add(170);

        whichTree(tree2);
    }
    public static void part3(){
        System.out.println("\n\n\t\t ### PART 3 ###\n");
        Random rand = new Random();

        ArrayList<BinarySearchTree<Integer> > bSearchTrees10 = new ArrayList<>();
        ArrayList<BinarySearchTree<Integer> > bSearchTrees20 = new ArrayList<>();
        ArrayList<BinarySearchTree<Integer> > bSearchTrees40 = new ArrayList<>();
        ArrayList<BinarySearchTree<Integer> > bSearchTrees80 = new ArrayList<>();

        int count = 0;
        double TotalTime_10=0,TotalTime_20=0,TotalTime_40=0,TotalTime_80=0;

        for(int i=0; i<10; ++i){
            bSearchTrees10.add(new BinarySearchTree<>());
            bSearchTrees20.add(new BinarySearchTree<>());
            bSearchTrees40.add(new BinarySearchTree<>());
            bSearchTrees80.add(new BinarySearchTree<>());
        }

        for(int i=0; i<10; ++i) {
            double start = System.currentTimeMillis();
            while (count < 10000) {
                int num = rand.nextInt();
                if(bSearchTrees10.get(i).add(num))
                    ++count;
            }
            double end = System.currentTimeMillis();
            TotalTime_10 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 20000){
                int num = rand.nextInt();
                if(bSearchTrees20.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_20 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 40000){
                int num = rand.nextInt();
                if(bSearchTrees40.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_40 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 80000){
                int num = rand.nextInt();
                if(bSearchTrees80.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_80 += end - start;
            count = 0;
        }
        System.out.println("\t\t### BINARY SEARCH TREE TIME TEST ###\n\n");
        System.out.println("Average time of 10000 adding element Binary Search Tree " +  TotalTime_10/10 + " ms");
        System.out.println("Average time of 20000 adding element Binary Search Tree " +  TotalTime_20/10 + " ms");
        System.out.println("Average time of 40000 adding element Binary Search Tree " +  TotalTime_40/10 + " ms");
        System.out.println("Average time of 80000 adding element Binary Search Tree " +  TotalTime_80/10 + " ms");

        ArrayList<RedBlackTree<Integer> > redBlackTreesTree10 = new ArrayList<>();
        ArrayList<RedBlackTree<Integer> > redBlackTreesTree20 = new ArrayList<>();
        ArrayList<RedBlackTree<Integer> > redBlackTreesTree40 = new ArrayList<>();
        ArrayList<RedBlackTree<Integer> > redBlackTreesTree80 = new ArrayList<>();
        count = 0;
        for(int i=0; i<10; ++i){
            redBlackTreesTree10.add(new RedBlackTree<>());
            redBlackTreesTree20.add(new RedBlackTree<>());
            redBlackTreesTree40.add(new RedBlackTree<>());
            redBlackTreesTree80.add(new RedBlackTree<>());
        }
        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.currentTimeMillis();
            while (count < 10000) {
                int num = rand.nextInt();
                if(redBlackTreesTree10.get(i).add(num))
                    ++count;
            }
            double end = System.currentTimeMillis();
            TotalTime_10 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 20000){
                int num = rand.nextInt();
                if(redBlackTreesTree20.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_20 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 40000){
                int num = rand.nextInt();
                if(redBlackTreesTree40.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_40 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 80000){
                int num = rand.nextInt();
                if(redBlackTreesTree80.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_80 += end - start;
            count = 0;
        }
        System.out.println("\n\n\t\t### RED BLACK TREE TIME TEST ###\n\n");
        System.out.println("Average time of 10000 adding element to Red Black Tree " +  TotalTime_10/10 + " ms");
        System.out.println("Average time of 20000 adding element to Red Black Tree " +  TotalTime_20/10 + " ms");
        System.out.println("Average time of 40000 adding element to Red Black Tree " +  TotalTime_40/10 + " ms");
        System.out.println("Average time of 80000 adding element to Red Black Tree " +  TotalTime_80/10 + " ms");

        ArrayList<TwoThreeFourTree<Integer> > two_threeTree10 = new ArrayList<>();
        ArrayList<TwoThreeFourTree<Integer> > two_threeTree20 = new ArrayList<>();
        ArrayList<TwoThreeFourTree<Integer> > two_threeTree40 = new ArrayList<>();
        ArrayList<TwoThreeFourTree<Integer> > two_threeTree80 = new ArrayList<>();
        count = 0;
        for(int i=0; i<10; ++i){
            two_threeTree10.add(new TwoThreeFourTree<>());
            two_threeTree20.add(new TwoThreeFourTree<>());
            two_threeTree40.add(new TwoThreeFourTree<>());
            two_threeTree80.add(new TwoThreeFourTree<>());
        }
        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.currentTimeMillis();
            while (count < 10000) {
                int num = rand.nextInt();
                if(two_threeTree10.get(i).add(num))
                    ++count;
            }
            double end = System.currentTimeMillis();
            TotalTime_10 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 20000){
                int num = rand.nextInt();
                if(two_threeTree20.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_20 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 40000){
                int num = rand.nextInt();
                if(two_threeTree40.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_40 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 80000){
                int num = rand.nextInt();
                if(two_threeTree80.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_80 += end - start;
            count = 0;
        }
        System.out.println("\n\n\t\t### TWO THREE TREE TIME TEST ###\n\n");
        System.out.println("Average time of 10000 adding element to two-three Tree " +  TotalTime_10/10 + " ms");
        System.out.println("Average time of 20000 adding element to two-three Tree " +  TotalTime_20/10 + " ms");
        System.out.println("Average time of 40000 adding element to two-three Tree " +  TotalTime_40/10 + " ms");
        System.out.println("Average time of 80000 adding element to two-three Tree " +  TotalTime_80/10 + " ms");

        ArrayList<BTree<Integer> > bTrees10 = new ArrayList<>();
        ArrayList<BTree<Integer> > bTrees20 = new ArrayList<>();
        ArrayList<BTree<Integer> > bTrees40 = new ArrayList<>();
        ArrayList<BTree<Integer> > bTrees80 = new ArrayList<>();
        count = 0;
        for(int i=0; i<10; ++i){
            bTrees10.add(new BTree<>(5));
            bTrees20.add(new BTree<>(5));
            bTrees40.add(new BTree<>(5));
            bTrees80.add(new BTree<>(5));
        }
        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.currentTimeMillis();
            while (count < 10000) {
                int num = rand.nextInt();
                if(bTrees10.get(i).add(num))
                    ++count;
            }
            double end = System.currentTimeMillis();
            TotalTime_10 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 20000){
                int num = rand.nextInt();
                if(bTrees20.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_20 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 40000){
                int num = rand.nextInt();
                if(bTrees40.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_40 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 80000){
                int num = rand.nextInt();
                if(bTrees80.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_80 += end - start;
            count = 0;
        }
        System.out.println("\n\n\t\t###  B TREE TIME TEST ###\n\n");
        System.out.println("Average time of 10000 adding element to B-Tree Tree " +  TotalTime_10/10 + " ms");
        System.out.println("Average time of 20000 adding element to B-Tree Tree " +  TotalTime_20/10 + " ms");
        System.out.println("Average time of 40000 adding element to B-Tree Tree " +  TotalTime_40/10 + " ms");
        System.out.println("Average time of 80000 adding element to B-Tree Tree " +  TotalTime_80/10 + " ms");

        ArrayList<SkipList<Integer> > skipList10 = new ArrayList<>();
        ArrayList<SkipList<Integer> > skipList20 = new ArrayList<>();
        ArrayList<SkipList<Integer> > skipList40 = new ArrayList<>();
        ArrayList<SkipList<Integer> > skipList80 = new ArrayList<>();
        count = 0;
        for(int i=0; i<10; ++i){
            skipList10.add(new SkipList<>());
            skipList20.add(new SkipList<>());
            skipList40.add(new SkipList<>());
            skipList80.add(new SkipList<>());
        }
        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.currentTimeMillis();
            while (count < 10000) {
                int num = rand.nextInt();
                if(skipList10.get(i).add(num))
                    ++count;
            }
            double end = System.currentTimeMillis();
            TotalTime_10 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 20000){
                int num = rand.nextInt();
                if(skipList20.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_20 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 40000){
                int num = rand.nextInt();
                if(skipList40.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_40 += end - start;
            count = 0;
            start = System.currentTimeMillis();
            while(count < 80000){
                int num = rand.nextInt();
                if(skipList80.get(i).add(num))
                    ++count;
            }
            end = System.currentTimeMillis();
            TotalTime_80 += end - start;
            count = 0;
        }
        System.out.println("\n\n\t\t###  SKIP LIST TIME TEST ###\n\n");
        System.out.println("Average time of 10000 adding element to Skip List " +  TotalTime_10/10 + " ms");
        System.out.println("Average time of 20000 adding element to Skip List " +  TotalTime_20/10 + " ms");
        System.out.println("Average time of 40000 adding element to Skip List " +  TotalTime_40/10 + " ms");
        System.out.println("Average time of 80000 adding element to Skip List " +  TotalTime_80/10 + " ms");



        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.nanoTime();
            while (count < 100) {
                int num = rand.nextInt();
                if(bSearchTrees10.get(i).add(num))
                    ++count;
            }
            double end = System.nanoTime();
            TotalTime_10 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bSearchTrees20.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_20 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bSearchTrees40.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_40 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bSearchTrees80.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_80 += (end - start) / Math.pow(10,6);
            count = 0;
        }
        System.out.printf("\nAfter inserting 100 item to Binary Search Tree(10000) %.4f ms\n",TotalTime_10);
        System.out.printf("After inserting 100 item to Binary Search Tree(10000) %.4f ms\n",TotalTime_20);
        System.out.printf("After inserting 100 item to Binary Search Tree(10000) %.4f ms\n",TotalTime_40);
        System.out.printf("After inserting 100 item to Binary Search Tree(10000) %.4f ms\n",TotalTime_80);

        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.nanoTime();
            while (count < 100) {
                int num = rand.nextInt();
                if(redBlackTreesTree10.get(i).add(num))
                    ++count;
            }
            double end = System.nanoTime();
            TotalTime_10 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(redBlackTreesTree20.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_20 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(redBlackTreesTree40.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_40 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(redBlackTreesTree80.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_80 += (end - start) / Math.pow(10,6);
            count = 0;
        }
        System.out.printf("\nAfter inserting 100 item to Red Black Tree(10000) %.4f ms\n",TotalTime_10);
        System.out.printf("After inserting 100 item to Red Black Tree(10000) %.4f ms\n",TotalTime_20);
        System.out.printf("After inserting 100 item to Red Black Tree(10000) %.4f ms\n",TotalTime_40);
        System.out.printf("After inserting 100 item to Red Black Tree(10000) %.4f ms\n",TotalTime_80);

        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.nanoTime();
            while (count < 100) {
                int num = rand.nextInt();
                if(two_threeTree10.get(i).add(num))
                    ++count;
            }
            double end = System.nanoTime();
            TotalTime_10 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(two_threeTree20.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_20 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(two_threeTree40.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_40 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(two_threeTree80.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_80 += (end - start) / Math.pow(10,6);
            count = 0;
        }
        System.out.printf("\nAfter inserting 100 item to Two-Three Tree(10000) %.4f ms\n",TotalTime_10);
        System.out.printf("After inserting 100 item to Two-Three Tree(20000) %.4f ms\n",TotalTime_20);
        System.out.printf("After inserting 100 item to Two-Three Tree(40000) %.4f ms\n",TotalTime_40);
        System.out.printf("After inserting 100 item to Two-Three Tree(80000) %.4f ms\n",TotalTime_80);

        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.nanoTime();
            while (count < 100) {
                int num = rand.nextInt();
                if(bTrees10.get(i).add(num))
                    ++count;
            }
            double end = System.nanoTime();
            TotalTime_10 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bTrees20.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_20 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bTrees40.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_40 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(bTrees80.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_80 += (end - start) / Math.pow(10,6);
            count = 0;
        }
        System.out.printf("\nAfter inserting 100 item to B-Tree Tree(10000) %.4f ms\n",TotalTime_10);
        System.out.printf("After inserting 100 item to B-Tree Tree(20000) %.4f ms\n",TotalTime_20);
        System.out.printf("After inserting 100 item to B-Tree Tree(40000) %.4f ms\n",TotalTime_40);
        System.out.printf("After inserting 100 item to B-Tree Tree(80000) %.4f ms\n",TotalTime_80);

        TotalTime_10=0;TotalTime_20=0;TotalTime_40=0;TotalTime_80=0;
        for(int i=0; i<10; ++i) {
            double start = System.nanoTime();
            while (count < 100) {
                int num = rand.nextInt();
                if(skipList10.get(i).add(num))
                    ++count;
            }
            double end = System.nanoTime();
            TotalTime_10 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(skipList20.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_20 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(skipList40.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_40 += (end - start) / Math.pow(10,6);
            count = 0;
            start = System.nanoTime();
            while(count < 100){
                int num = rand.nextInt();
                if(skipList80.get(i).add(num))
                    ++count;
            }
            end = System.nanoTime();
            TotalTime_80 += (end - start) / Math.pow(10,6);
            count = 0;
        }
        System.out.printf("\nAfter inserting 100 item to Skip List(10000) %.4f ms\n",TotalTime_10);
        System.out.printf("After inserting 100 item to Skip List(20000) %.4f ms\n",TotalTime_20);
        System.out.printf("After inserting 100 item to Skip List(40000) %.4f ms\n",TotalTime_40);
        System.out.printf("After inserting 100 item to Skip List(80000) %.4f ms\n",TotalTime_80);


    }


    public static void whichTree(BinarySearchTree Tree){


        if(isAvl(Tree)){
            System.out.println("AVL TREE = YES");

        }
        else
            System.out.println("AVL TREE = NO");

        if(isRedBlack(Tree)){
            System.out.println("RED-BLACK TREE=YES");
        }
        else
            System.out.println("RED-BALCK TREE=NO");

    }

    public static boolean isAvl(BinarySearchTree tree){

        return isAvl(tree.root);
    }
    public static boolean isAvl(BinaryTree.Node Tree){

        if(Tree==null){
            return true;
        }
        int left = findHeight(Tree.left);
        int right = findHeight(Tree.right);

        if(Math.abs(left-right)<=1 && isAvl(Tree.left) && isAvl(Tree.right)){
            return true;
        }
        return false;
    }
    public static int findHeight(BinaryTree.Node aNode){
        if(aNode==null)
            return 0;
        return 1+Math.max(findHeight(aNode.left),findHeight(aNode.right));
    }
    public static int findHeightMin(BinaryTree.Node aNode){
        if(aNode==null)
            return 0;
        return 1+Math.min(findHeight(aNode.left),findHeight(aNode.right));
    }


    public static boolean isRedBlack(BinarySearchTree Tree){
        return isRedBlack(Tree.root);
    }
    public static boolean isRedBlack(BinaryTree.Node Tree){
        if(Tree==null){
            return true;
        }
        int min = Math.min(findHeightMin(Tree.left),findHeightMin(Tree.right))+1;
        int max = Math.max(findHeight(Tree.left),findHeight(Tree.right))+1;
        if(max<=min*2 && isAvl(Tree.left) && isAvl(Tree.right)){
            return true;
        }
        return false;
    }
}

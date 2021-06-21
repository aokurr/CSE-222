import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Menu {
    private Hashtable<String,User> users=new Hashtable<>();
    private ArrayList<product> datas=new ArrayList<>();
    private String Id;
    private static final String COMMA_DELIMITER=";";
    public Menu(){
        login_system_step1();
        login_system_step2();
    }

    /**
     * This method allows user information to be stored in a hash table.
     */
    private void login_system_step1(){
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                users.put(values[0],new User(values));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method determines the type of the user and starts the menu operations
     */
    private void login_system_step2(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Id");
        Id = myObj.nextLine();
        System.out.println("Enter password");
        String Password = myObj.nextLine();

        if(users.get(Id)!=null && users.get(Id).getPassword().equals(Password)){
            System.out.println("LOGGED IN");
            if(users.get(Id).getRole().equals("Costumer")){
                System.out.println("COSTUMER MENU");
                menu();
            }
            else{
                System.out.println("Trader Menu");
                try (BufferedReader br = new BufferedReader(new FileReader("Users_buy.txt"))){
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        System.out.println("Costumer Id="+values[0]);
                        for(int i=1;i< values.length;i++)
                            System.out.println("Product Id ="+values[i]);

                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        else
            System.out.println("Incorrect Id or Password please try again");
    }

    /**
     * user menu
     */
    private void menu(){
       Scanner myObj = new Scanner(System.in);
       while(true) {
           System.out.printf("1) Search and query the product\n");
           System.out.printf("2) Display all the products of a trader\n");
           System.out.printf("3)Exit \n");
           int choice = myObj.nextInt();
           myObj.nextLine();
           switch (choice) {
               case 1:
                   System.out.println("Please Enter the word");
                   String Search = myObj.nextLine();
                   try (BufferedReader br = new BufferedReader(new FileReader("edit.csv"))){
                       String line;
                       int i=0;
                       while ((line = br.readLine()) != null){
                           String[] values = line.split(COMMA_DELIMITER);

                           if(values[5].contains(Search)){
                               datas.add(new product(values));
                           }
                       }
                   }
                   catch (FileNotFoundException e) {
                       e.printStackTrace();
                   }
                   catch (IOException e) {
                       e.printStackTrace();
                   }
                   filtered();
                   break;
               case 2:
                   String traders = myObj.nextLine();
                   see_traders_produt(traders);
                   filtered();
                   break;
               case 3:
                   return;
           }
       }
   }

    /**
     * This method lists the trader's products
     * @param traders
     */
   private void see_traders_produt(String traders){
       try (BufferedReader br = new BufferedReader(new FileReader("edit.csv"))){
           String line;
           int i=0;
           while ((line = br.readLine()) != null){
               String[] values = line.split(COMMA_DELIMITER);

               if(values[6].contains(traders)){
                   datas.add(new product(values));
               }
           }
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   }

    /**
     * This method is responsible for filtering products
     */
   private void filtered(){
        Scanner myObj = new Scanner(System.in);
        ArrayList<product> tmp_;
        while(true) {
            System.out.println(datas);
            System.out.println("Please Select\n");
            System.out.println("1) Lower-Price\n");
            System.out.println("2) Upper-Price \n");
            System.out.println("3)Lower-Upper-Price\n");
            System.out.println("4)Category\n");
            System.out.println("5)Buy Product\n");
            System.out.println("6)Sort Page\n");
            System.out.println("7)Back Page\n");
            int choice = myObj.nextInt();
            myObj.nextLine();
            if (choice == 1) {
                tmp_=new ArrayList<>();
                System.out.println("Please Enter the Lower-Price\n");
                Integer LowerPrice = myObj.nextInt();
                for (int i = 0; i < datas.size(); i++) {
                    Integer tmp = Integer.parseInt(datas.get(i).getPrice());
                    if (tmp.compareTo(LowerPrice)>0) {
                        tmp_.add(datas.get(i));
                    }
                }
                datas=tmp_;
            }
            else if(choice==2){
                tmp_=new ArrayList<>();
                System.out.println("Please Enter the Upper-Price\n");
                Integer UpperPrice = myObj.nextInt();
                for (int i = 0; i < datas.size(); i++) {
                    Integer tmp = Integer.parseInt(datas.get(i).getPrice());
                    if (tmp.compareTo(UpperPrice)<0) {
                        tmp_.add(datas.get(i));
                    }
                }
                datas=tmp_;
            }
            else if(choice==3){
                tmp_=new ArrayList<>();
                System.out.println("Please Enter the Lower-Price\n");
                Integer LowerPrice = myObj.nextInt();
                System.out.println("Please Enter the Upper-Price\n");
                Integer UpperPrice = myObj.nextInt();
                for (int i = 0; i < datas.size(); i++) {
                    Integer tmp = Integer.parseInt(datas.get(i).getPrice());
                    if (tmp.compareTo(UpperPrice)<0 && tmp.compareTo(LowerPrice)>0) {
                        tmp_.add(datas.get(i));
                    }
                }
                datas=tmp_;
            }
            else if(choice==4){
                tmp_=new ArrayList<>();
                System.out.println("Please Enter the Category\n");
                String cat = myObj.nextLine();
                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).Contains_Category(cat)) {
                        tmp_.add(datas.get(i));
                    }
                }
                datas=tmp_;;
            }
            else if(choice==5){
                try {
                    buy_product();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(choice==6){
                sort_product();
            }
            else if(choice==7){
                return;
            }
            else
                System.out.println("Please Try Again");
        }
    }

    /**
     * This method handles the sorting of products
     */
   private void sort_product(){
       Scanner myObj = new Scanner(System.in);

       while(true) {
            System.out.println("Please select%n");
            System.out.println("1) Sort Price%n");
            System.out.println("2) Sort Discounted%n");
            System.out.println("3) Sort Name%n");
            System.out.println("4) Buy Product%n");
            System.out.println("5) Back Page");
           int choice = myObj.nextInt();
           switch (choice){
               case 1:
                   QuickSort<product> sort=new QuickSort<>();
                   sort.sort(datas,2);
                   for(int i=0;i<datas.size();i++){
                       System.out.println("Product Id="+datas.get(i).getId()+"Product Name="+datas.get(i).getProduct_name()+
                                                        "Product Price="+datas.get(i).getPrice());
                   }
                   break;
               case 2:
                   shellsort<product> sort2=new shellsort<>();
                   sort2.sort(datas,3);
                   for(int i=0;i<datas.size();i++){
                       System.out.println("Product Id="+datas.get(i).getId()+"Product Name="+datas.get(i).getProduct_name()+
                               "Product Price="+datas.get(i).getPrice()+"Product Discounted="+datas.get(i).getDiscounted());
                   }
                   break;
               case 3:
                   HeapSort<product> sort3=new HeapSort<>();
                   sort3.sort(datas,1);
                   for(int i=0;i<datas.size();i++){
                       System.out.println("Product Id="+datas.get(i).getId()+"Product Name="+datas.get(i).getProduct_name()+
                               "Product Price="+datas.get(i).getPrice());
                   }
                   break;
               case 4:
                   try{
                       buy_product();
                   }
                   catch (Exception e){
                       System.out.println(e);
                   }
                   break;
               case 5:
                   return;
           }
       }
   }

    /**
     *This method allows products to be sold. uploads the products sold and customer ID to the file
      * @throws IOException
     */
   private void buy_product() throws IOException {
        Scanner myObj = new Scanner(System.in);
        ArrayList<String> buy=new ArrayList<>();
        buy.add(Id);
        while(true){
            System.out.println("1)Select Product");
            System.out.println("2)Back Page");
            int choice = myObj.nextInt();
            myObj.nextLine();
            if(choice==1){
                System.out.println("Please Enter The product Id");
                String product=myObj.nextLine();
                for(int i=0;i<datas.size();i++){
                    if(datas.get(i).getId().equals(product)){
                        buy.add(product);
                    }
                }
            }
            else if(choice==2){
                if(buy.size()>1){
                    File file = new File("Users_buy.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    for(int i=0;i<buy.size();i++)
                        bWriter.write(buy.get(i)+",");
                    bWriter.close();
                }
                return;
            }
        }


    }
}

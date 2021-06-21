import java.util.Iterator;
import java.util.LinkedList;

public class product implements Comparable<product> {
    private String id;
    private String product_name;
    private LinkedList<String> category=new LinkedList<>();
    private String price;
    private String discounted;
    private String description;
    private String trader;
    private static final String COMMA_DELIMITER=">>";

    /**
     * constructor that saves the data to the object
     * @param product
     */
    public product(String product[]){
        id=product[0];
        product_name=product[1];
        String A[]=product[2].substring(4,product[2].length()-4).split(COMMA_DELIMITER);
        for(int i=0;i< A.length;i++) {
            category.add(A[i]);
        }

        price=product[3];
        discounted=product[4];
        description=product[5];
        trader=product[6];
    }

    /**
     * Returns the LinkedList at object.
     * @return
     */
    public LinkedList<String> getCategory(){
        return category;
    }

    /**
     *Searches for data categories on the Linked List
     * @param a
     * @return
     */
    public boolean Contains_Category(String a){
        Iterator iter=category.iterator();
        while(iter.hasNext()){
            String tmp= (String) iter.next();
            if(tmp.contains(a)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns Discounted
     * @return
     */
    public String getDiscounted() {
        return discounted;
    }

    /**
     * returns the unique ID of the product
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * returns the price of the product
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     *returns the name of the product
     * @return
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     *returns the name of the product's traders
     * @return
     */
    public String getTrader() {
        return trader;
    }

    /**
     * print product information on the screen
     * @return
     */
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        sb.append('"');
        Iterator iter=category.iterator();
        while(iter.hasNext())
            sb.append(iter.next()+">>");
        sb.append('"');
        sb.append(']');
        return String.format("%s;%s;%s;%s;%s;%s;%s\n",id,product_name,sb.toString(),price,discounted,description,trader);
    }

    /**
     * Compares this object with the specified object for order.
     * @param o
     * @return
     */
    public int compareTo(product o) {
        return getTrader().compareTo(o.getTrader());
    }
}

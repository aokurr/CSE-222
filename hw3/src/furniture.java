public interface furniture{
    /**
     * return furniture name
     * @return return furniture name
     */
    public String getName();

    /**
     * retrun furniture model
     * @return retrun furniture model
     */
    public char getModel();

    /**
     * return color id
     * @return return color id
     */
    public int getColor();

    /**
     * compares two items
     * @param o
     * @return
     */
    public boolean equals(furniture o);

    /**
     * increases the number of furniture
     */
    public void add_item();

    /**
     * decrease the number of furniture
     * @return if number of furniture==0,false
     */
    public boolean delete_item();
}

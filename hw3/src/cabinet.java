public class cabinet implements furniture {
    private char model;
    private int number=2;
    private static final String name="CABINET";
    public cabinet(int model_entry){
        model=(char)(model_entry+65);
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Model = " + model+"= "+number+"\n");
        return result.toString();
    }
    /**
     * return furniture name
     * @return return furniture name
     */
    @Override
    public String getName(){return name;}

    /**
     * retrun furniture model
     * @return retrun furniture model
     */
    public char getModel(){return model;}

    /**
     * return color id -1
     * @return return color id -1
     */
    public int getColor(){return -1;}

    /**
     * compares two items
     * @param o
     * @return
     */
    public boolean equals(furniture o){
        return getModel()==o.getModel() &&getColor()==o.getColor();
    }

    /**
     * increases the number of furniture
     */
    public void add_item(){
        number++;
    }

    /**
     * decrease the number of furniture
     * @return if number of furniture==0,false
     */
    public boolean delete_item(){
        number--;
        if(number==0)
            return false;
        return true;
    }
}

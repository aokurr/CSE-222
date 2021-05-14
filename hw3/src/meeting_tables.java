public class meeting_tables implements furniture{
    private int color;
    private char model;
    private int number=2;
    private static final String name="MEETINGTABLE";
    public meeting_tables(int color_entry,int model_entry)throws ahmets_exceptions{
        if(color_entry<1 || color_entry>5){
            throw new ahmets_exceptions("Incorrect color id. it should be color>0 && color<5");
        }
        color=color_entry;
        model=(char)(model_entry+65);
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        switch (color) {
            case 1:
                result.append("Color = Blue  ");
                break;
            case 2:
                result.append("Color = Red  ");
                break;
            case 3:
                result.append("Color = black  ");
                break;
            case 4:
                result.append("Color = yellow  ");
                break;
        }
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
    @Override
    public char getModel(){return model;}

    /**
     * return color id
     * @return return color id
     */
    @Override
    public int getColor(){return color;}

    /**
     * compares two items
     * @param o
     * @return
     */
    @Override
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

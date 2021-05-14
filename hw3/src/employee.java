public class employee implements person {
    private LinkedList_ahmet<branch> all_branchs;
    public employee(LinkedList_ahmet<branch> all_branchs){
        this.all_branchs = all_branchs;
    }
    /**
     * sees all products in branches
     */
    public void see_all_product() {
        System.out.println(all_branchs);
    }
    /**
     * Check to see if the desired product is available
     * @param branch_id branch number
     * @param furniture furniture name
     * @param model_id furniture model is
     * @param color_id furniture color id
     * @return if product is avaliable , true
     */
    public boolean product_is_in(int branch_id, String furniture, char model_id, int color_id) {

        return all_branchs.get(branch_id).data.is_in(furniture, model_id, color_id);
    }

    /**
     * specified product adds to specified branch
     * @param branch_id branch id
     * @param WhichFurniture furniture name
     * @param color_id furniture color id
     * @param model_id furniture model id
     */
    public void add_product(int branch_id,String WhichFurniture,int color_id,char model_id){

        try {
            if (WhichFurniture.equals("DESK")) {
                all_branchs.get(branch_id).data.add_new_item(new desks(color_id,model_id-65));
            }
            else if (WhichFurniture.equals("CHAIR")) {
                all_branchs.get(branch_id).data.add_new_item(new chairs(color_id,model_id-65));
            }
            else if (WhichFurniture.equals("MEETINGTABLE")) {
                all_branchs.get(branch_id).data.add_new_item(new meeting_tables(color_id,model_id-65));
            }
            else if (WhichFurniture.equals("CABINET")) {
                all_branchs.get(branch_id).data.add_new_item(new cabinet(model_id-65));
            }
            else if (WhichFurniture.equals("BOOKCASE")) {
                all_branchs.get(branch_id).data.add_new_item(new bookcase(model_id-65));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * specified product removes to specified branch
     * @param branch_id branch id
     * @param furniture furniture name
     * @param color_id furniture color id
     * @param model_id furniture model id
     */
    public void remove_product(int branch_id,String furniture,int color_id,char model_id){
        all_branchs.get(branch_id).data.remove_item(furniture,color_id,model_id);
    }

    /**
     * employee sells products in the store
     * @param costumer_ costumer linkedlist
     * @param id costumer id
     * @param branch_id branch id
     * @param which_furniture furniture name
     * @param model_id furniture model id
     * @param color_id furniture color id
     * @throws ahmets_exceptions
     */
    public void buy_product_store(costumer costumer_,int id,int branch_id,String which_furniture,char model_id,int color_id)throws ahmets_exceptions{
        if(costumer_.costumer_data.getSize()>id){
            remove_product(branch_id,which_furniture,color_id,model_id);
            costumer_.costumer_data.get(id).prev_view.add(0,"\nFURNITURE= "+which_furniture+"\t\tMODEL= "+model_id+"\tCOLOR= "+color_prev(color_id));
        }
        else{
            System.out.println("INCORRECT ID PLEASE TRY AGAIN\n");
        }

    }
    private String color_prev(int color){
        switch (color) {
            case 1:
                return "Blue";
            case 2:
                return "Red";
            case 3:
                return "Black";
            case 4:
                return "Yellow";
            case 5:
                return "Purple";
        }
        return  "Uncolored";
    }
}

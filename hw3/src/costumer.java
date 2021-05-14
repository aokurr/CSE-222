public class costumer implements person {
    private LinkedList_ahmet<branch> all_branchs;
    public ArrayList_ahmet<costumer_information> costumer_data=null;
    private String email_;
    private String password_;

    public costumer(LinkedList_ahmet<branch> all_branchs) {
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
     * first registration is done
     * @param name member's name
     * @param surname member's surname
     * @param email member's email
     * @param password member's password
     */
    public void login_system(String name, String surname, String email, String password) {
        if (costumer_data == null) {
            costumer_data=new ArrayList_ahmet<costumer_information>();
            try{
                email_=email;
                password_=password;
                costumer_data.add(0, new costumer_information());
                costumer_data.get(0).name = name;
                costumer_data.get(0).surname = surname;
                costumer_data.get(0).email = email;
                costumer_data.get(0).password = password;
                costumer_data.get(0).id = costumer_data.getSize()-1;
                System.out.printf("NAME=%s\nSURNAME=%s\nEMAIL=%s\nPASSWORD=%s", costumer_data.get(0).name, costumer_data.get(0).surname,
                                                                                costumer_data.get(0).email, costumer_data.get(0).password);
                System.out.println("\nREGISTERED\n");
                return;
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        try{
            email_ = new String(email);
            password_ = new String(password);
            int index=costumer_data.getSize();
            costumer_data.add(index, new costumer_information());
            costumer_data.get(index).name = name;
            costumer_data.get(index).surname = surname;
            costumer_data.get(index).email = email;
            costumer_data.get(index).password = password;
            costumer_data.get(index).id = index;
            System.out.printf("NAME=%s\nSURNAME=%s\nEMAIL=%s\nPASSWORD=%s", costumer_data.get(index).name, costumer_data.get(index).surname,
                                                                            costumer_data.get(index).email, costumer_data.get(index).password);
            System.out.println("\nREGISTERED\n");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * login to the system with password and mail
     * @param email member's email
     * @param password member's password
     * @return Returns true if the member is logged into the system
     */
    public boolean login_system(String email, String password) {
        email_ = new String(email);
        password_ = new String(password);
        if (costumer_data == null) {
            System.out.println("PLEASE REGISTER");
            return false;
        }
        for (int i = 0; i < costumer_data.getSize(); i++) {
            if (costumer_data.get(i).email.equals(email_) && costumer_data.get(i).password.equals(password_)) {
                System.out.println("LOG IN");
                return true;
            }
        }
        System.out.println("PLEASE REGISTER");
        return false;
    }

    /**
     * The desired product is purchased online
     * @param branch_number branch id
     * @param which_furniture furniture name
     * @param color furniture color
     * @param model_id furniture model
     * @param addres member's addres
     * @param phone_number member's phone number
     */
    public void buy_product_online(int branch_number, String which_furniture, int color, char model_id, String addres, String phone_number) {
        boolean flag = false;
        int costumer_id;
        for (costumer_id = 0; costumer_id < costumer_data.getSize(); costumer_id++) {
            if (costumer_data.get(costumer_id).email.equals(email_) && costumer_data.get(costumer_id).password.equals(password_)) {
                flag = true;

                break;
            }

        }
        if (flag == true) {
            if(all_branchs.get(branch_number).data.remove_item(which_furniture, color, model_id) == true) {
                costumer_data.get(costumer_id).prev_view.add(0,"\nFURNITURE= "+which_furniture+"\t\tMODEL= "+model_id+"\tCOLOR= "+color_prev(color));
                costumer_data.get(costumer_id).address=addres;
                costumer_data.get(costumer_id).address=phone_number;

            }
        }
    }

    /**
     * looks at the member's background
     */
    public void show_prev_views(){
          int i;
            for(i=0;i<costumer_data.getSize();i++){
            if(costumer_data.get(i).email.equals(email_)&&costumer_data.get(i).password.equals(password_)){
                break;
            }
        }
        if(costumer_data.get(i).prev_view!=null){
            System.out.println(costumer_data.get(i).name+" "+" "+costumer_data.get(i).surname);
            System.out.println(costumer_data.get(i).prev_view);
        }

        else
            System.out.println("NOT INFORMATION");
    }

    /**
     * all customer information is printed for driver function
     */
    public void show_all_costumer_information(){
        for(int i=0;i<costumer_data.getSize();i++){
            costumer_data.get(i).print_all_information();
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



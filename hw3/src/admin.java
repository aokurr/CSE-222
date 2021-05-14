/**
*<h1> JAVA automatıon system HOMEWORK-1!</h1>
*@author AHMET OKUR
*@since 2021-03-13
*/
import java.util.Iterator;

public class admin implements person{
    private LinkedList_ahmet<branch> all_branchs;
    public admin(LinkedList_ahmet<branch> all_branchs){
        this.all_branchs=all_branchs;
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
     * admin added new branch
     * @param branch_name branch name for ex=ANKARA
     */
    public void add_branch(String branch_name){
        try{
            all_branchs.add(new branch(branch_name),0);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * admin deleted  branch
     * @param index which branch
     */
    public void delete_branch(int index){
        try{
            all_branchs.remove(index);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * admin added new branch
     * @param branch_id which branch
     * @param employee_name employee name
     */
    public void add_employee(int branch_id,String employee_name){
        try{
            all_branchs.get(branch_id).employee_name.add(0,employee_name);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * admin deleted new branch
     * @param branch_id which branch
     * @param employee_name employee name
     * @return if the process succesful,true
     */
    public boolean delete_employee(int branch_id,String employee_name){
        int index=all_branchs.get(branch_id).employee_name.contains(employee_name);
        if(index!=-1){
            all_branchs.get(branch_id).employee_name.remove(index);
           return true;
        }
        return false;
    }

    /**
     * print all employee
     * @param branch_id which branch
     */
    public void print_employee(int branch_id){
        System.out.println(all_branchs.get(branch_id).employee_name);
    }

    /**
     * print the branchs name
     */
    public void show_branchs_name(){
        System.out.println("\t***BRANCHS NAME**");
        for(int i=0;i<all_branchs.getSize();i++){
            System.out.println((i+1)+")"+all_branchs.get(i).branch_name);
        }
    }
}

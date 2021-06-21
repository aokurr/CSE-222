
public class test {
    public static void main(String Args[]) {
        edit_csv edit=new edit_csv("e-commerce-sample.csv");
        try {
            edit.write_txt();
        }
        catch (Exception e){
            System.out.println(e);
        }
        Menu menu=new Menu();
    }

}

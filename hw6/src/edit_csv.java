import java.io.*;
import java.util.PriorityQueue;

public class edit_csv {
    private static final String COMMA_DELIMITER=";";
    private String file_name;
    private PriorityQueue<product> datas=new PriorityQueue<>();
    public edit_csv(String file_name){
        this.file_name=file_name;
        edit_tarader();
    }

    /**
     * Edit the csv file
     */
    private void edit_tarader(){
        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce-samples.csv"))){
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                i++;
                if(i==1)
                    continue;
                String[] values = line.split(COMMA_DELIMITER);
                datas.offer(new product(values));
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
     * write the new file
     * @throws IOException
     */
    public void write_txt() throws IOException {
        try {
            FileWriter setObj = new FileWriter("edit.csv");
            while(datas.isEmpty()!=true){
                setObj.write(datas.poll().toString());
            }
            setObj.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

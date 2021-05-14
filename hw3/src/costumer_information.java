
public class costumer_information{
	public String name=null;
	public String surname=null;
	public String email=null;
	public String password=null;
	public String phone_number=null;
	public String address=null;
	public ArrayList_ahmet<String> prev_view;
	public int id;
	public costumer_information(){
		prev_view=new ArrayList_ahmet<String>();
	}

	/**
	 * print costumer information
	 */
	public void print_all_information(){
		System.out.println("NAME= "+name+"\tSURNAME="+surname);
		System.out.println("\nE-MAIL= "+email+"\tPASSWORD="+password);
		if(phone_number!=null && address!=null){
			System.out.println("\nPHONE NUMBER= "+phone_number+"\tADDRESS="+address);
		}
	}

}
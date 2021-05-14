import java.util.ListIterator;

public class branch<E>{
	public ArrayList_ahmet<String> employee_name=new ArrayList_ahmet<String>();
	public HybridList_ahmet<furniture> data;
	public String branch_name;
	public branch(String branch_name) {
		this.branch_name=branch_name;
		employee_name.add(0,"AHMET");
		employee_name.add(0,"SENA");
		employee_name.add(0,"HATİCE");
		data=new HybridList_ahmet<furniture>();
		ArrayList_ahmet<furniture> desks_information=new ArrayList_ahmet<furniture>();
		ArrayList_ahmet<furniture> meeting_table_information=new ArrayList_ahmet<furniture>();
		ArrayList_ahmet<furniture> chairs_information=new ArrayList_ahmet<furniture>();
		ArrayList_ahmet<furniture> cabinets_informaiton=new ArrayList_ahmet<furniture>();
		ArrayList_ahmet<furniture> bookcases_informaiton=new ArrayList_ahmet<furniture>();

		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				try {
					desks_information.add(desks_information.getSize(), new desks(j+1, i));
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}

		for(int i=0;i<10;i++){
			for(int j=0;j<4;j++){
				try {
					meeting_table_information.add(meeting_table_information.getSize(), new meeting_tables(j+1, i));
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}

		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				try {
					chairs_information.add(chairs_information.getSize(), new chairs(j+1, i));
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}
		for(int i=0;i<2;i++){
			cabinets_informaiton.add(cabinets_informaiton.getSize(),new cabinet(i));
			bookcases_informaiton.add(bookcases_informaiton.getSize(),new bookcase(i));
		}
		data.addFirst(desks_information,"DESK");
		data.addLast(meeting_table_information,"MEETINGTABLE");
		data.addLast(chairs_information,"CHAIR");
		data.addLast(cabinets_informaiton,"CABINET");
		data.addLast(bookcases_informaiton,"BOOKCASE");
	}

	/**
	 * prints all elements
	 * @return -return the all elements
	 */
	public String toString(){
		StringBuilder result=new StringBuilder();
		result.append(data);
		return result.toString();
	}
}
import java.util.ListIterator;

public class automation_system{
	public LinkedList_ahmet<branch> branchs;
	public costumer costumer_skills;
	public employee employee_skills;
	public admin admin_skills;
	public automation_system(){
		branchs=new LinkedList_ahmet<branch>();
		try{
			branchs.add(new branch("İZMİT"),0);
			branchs.add(new branch("İSTANBUL"),0);
			branchs.add(new branch("ANKARA"),0);
			branchs.add(new branch("GÜMÜŞHANE"),0);
		}
		catch (Exception e){
			System.out.println(e);
		}
		costumer_skills=new costumer(branchs);
		employee_skills=new employee(branchs);
		admin_skills=new admin(branchs);
	}
}
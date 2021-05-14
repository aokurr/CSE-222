public class automation_system{
	public branch branchs[];
	public costumer costumer_test;
	public int branch_number;
	public admin admin_test;
	public employeee employee_test;
	public automation_system(){
		branchs=new branch[4];
		for(int i=0;i<4;i++){
			branchs[i]=new branch();
		}
		branch_number=4;
		costumer_test=new costumer(branchs,branch_number);
		employee_test=new employeee(branchs,branch_number);
		admin_test=new admin(branchs);
	}
	/**
    *branch increase transactions
    */
	public void add_branch(){
		branchs=admin_test.add_branch();
		costumer_test=new costumer(branchs,branch_number);
		employee_test=new employeee(branchs,branch_number);
	}
	/**
    *branch decrease transactions
    */
	public void delete_branch()throws Exception{
		
		branchs=admin_test.delete_branch();
		costumer_test=new costumer(branchs,branch_number);
		employee_test=new employeee(branchs,branch_number);
	}
	/**
    *see the employees name for test code
    */
	public void see_employee(){
		
		for(int i=0;i<branchs.length;i++){
			System.out.printf("***BRANCH%d***\n",i+1);
			for(int j=0;j<branchs[i].employee.length;j++)
				System.out.println(branchs[i].employee[j]);
		}
	}

}
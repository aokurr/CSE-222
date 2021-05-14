public class admin{
	public branch branch_admin[];
	public admin(branch a[]){
		branch_admin=a;
	}
	public branch[] add_branch(){
		int branch_number=branch_admin.length;
		branch tmp[]=new branch[branch_number+1];
		for(int i=0;i<branch_number;i++){
			tmp[i]=branch_admin[i];
		}
		tmp[branch_number]=new branch();
		branch_admin=tmp;
		System.out.println("BRANCH ADDED");
		return branch_admin;
	}
	/**
    *this function deletes a branch
    *@return branch[] - arrey
    */
	public branch[] delete_branch()throws ahmets_exceptions{
		if(branch_admin.length==0){
			throw new ahmets_exceptions("There is no branch!");
		}
		int branch_number=branch_admin.length;
		branch tmp[]=new branch[branch_number-1];
		for(int i=0;i<branch_number-1;i++){
			tmp[i]=branch_admin[i];
		}
		branch_admin=tmp;
		System.out.println("BRANCH DELETED");
		return branch_admin;
	}
	/**
    *this function adds branches
    *@param deneme,employee_name 
    */
	public void add_employee(branch deneme,String employee_name){
		int size=deneme.employee.length;
		size++;
		String tmp[]=new String[size];
		for(int i=0;i<size-1;i++){
			tmp[i]=new String (deneme.employee[i]);
		}
		tmp[size-1]=new String(employee_name);
		deneme.employee=tmp;
	}
	/**
    *this function deletes a worker
    *@param deneme,employee_name - specified name in specified branch
    */
	public void delete_employee(branch deneme,String employee_name)throws ahmets_exceptions{
		if(deneme.employee.length==0){
			throw new ahmets_exceptions("There is no employee!");
		}
		int size=deneme.employee.length;
		String tmp[]=new String[size-1];
		int j=0;
		for(int i=0;i<size;i++){
			if(!(deneme.employee[i].equals(employee_name))){
				tmp[j]=new String(deneme.employee[i]);
				j++;
			}
			
		}
		if(j!=size-1){
			throw new ahmets_exceptions("There is no employee this name !");
		}
		else{
			deneme.employee=tmp;
			System.out.println("EMPLOYEE DELETED");
		}
	}


}
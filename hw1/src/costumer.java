public class costumer implements person{
	public branch katalog[];
	public int number;
	public costumer_information costumers[];
	String email_;
	String password_;
	public costumer(branch a[],int branch_number){
		katalog=a;
		number=branch_number;
		costumers=null;

	}
	/**
    *THIS FUNCTION SHOWS THE PRODUCTS ON THE BRANCHES
    */
	public void see_all_product(){
		int i,j,count=0;;
		char ch;
		System.out.println("POLYMORPHISM EXAMPLE 1");
		for(j=0;j<katalog.length;j++){
			System.out.printf("\n\t $$$$$$$$$$ BRANCH -- %d $$$$$$$$$$$$$$$\n\n",j+1);
			for(i=0;i<12;i++){
				ch=(char)(i+65);
				System.out.printf("%d) %c model bookcases=%d\n",count,ch,katalog[j].bookcases[i]);
				count++;
			}
			System.out.println("\n****************************************************\n");
			for(i=0;i<12;i++){
				ch=(char)(i+65);
				System.out.printf("%d) %c model office_cabinets=%d\n",count,ch,katalog[j].office_cabinets[i]);
				count++;
			}
			System.out.println("\n****************************************************\n");
			for( i=0;i<7;i++){
				ch=(char)(i+65);
				System.out.printf("%d) %c model blue color chairs=%d\n",count,ch,katalog[j].chairs[i][0]);
				count++;
								
				System.out.printf("%d) %c model red color chairs=%d\n",count,ch,katalog[j].chairs[i][1]);
				count++;

				System.out.printf("%d) %c model yellow color chairs=%d\n",count,ch,katalog[j].chairs[i][2]);
				count++;

				System.out.printf("%d) %c model green color chairs=%d\n",count,ch,katalog[j].chairs[i][3]);
				count++;

				System.out.printf("%d) %c model brown color chairs=%d\n",count,ch,katalog[j].chairs[i][4]);
				count++;
			}
			System.out.println("\n****************************************************\n");
			for( i=0;i<5;i++){
				ch=(char)(i+65);
				System.out.printf("%d) %c model blue color desks=%d\n",count,ch,katalog[j].desks[i][0]);
				count++;
								
				System.out.printf("%d) %c model red color desks=%d\n",count,ch,katalog[j].desks[i][1]);
				count++;

				System.out.printf("%d) %c model yellow color desks=%d\n",count,ch,katalog[j].desks[i][2]);
				count++;

				System.out.printf("%d) %c model green color desks=%d\n",count,ch,katalog[j].desks[i][3]);
				count++;
			}

			System.out.println("\n****************************************************\n");
			for( i=0;i<10;i++){
				ch=(char)(i+65);
				System.out.printf("%d) %c model blue color meeting_tables=%d\n",count,ch,katalog[j].meeting_tables[i][0]);
				count++;
								
				System.out.printf("%d) %c model red color meeting_tables=%d\n",count,ch,katalog[j].meeting_tables[i][1]);
				count++;

				System.out.printf("%d) %c model yellow color meeting_tables=%d\n",count,ch,katalog[j].meeting_tables[i][2]);
				count++;

				System.out.printf("%d) %c model green color meeting_tables=%d\n",count,ch,katalog[j].meeting_tables[i][3]);
				count++;
			}
		}
		
	}
	/**
    *Returns true if this array contains the product.
    *@param branch,furniture,model,color
    *@return true if this array contains the  product
    */

	public boolean product_is_in(int branch,String furniture,char model,String color){
		int model_number=(int)model;
		model_number-=65;
			
			if(furniture.equals("chairs")){
				if(color.equals("blue")){
					return (katalog[branch].chairs[model_number][0]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].chairs[model_number][1]>0);
				}
				else if(color.equals("yellow")){
					return (katalog[branch].chairs[model_number][2]>0);
				}
				else if(color.equals("green")){
					return (katalog[branch].chairs[model_number][3]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].chairs[model_number][4]>0);
				}
				else if(color.equals("brown")){
					return (katalog[branch].chairs[model_number][5]>0);
				}
				else 
					return false;
			}
			else if(furniture.equals("desks")){
				if(color.equals("blue")){
					return (katalog[branch].desks[model_number][0]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].desks[model_number][1]>0);
				}
				else if(color.equals("yellow")){
					return (katalog[branch].desks[model_number][2]>0);
				}
				else if(color.equals("green")){
					return (katalog[branch].desks[model_number][3]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].desks[model_number][4]>0);
				}
				else 
					return false;
			}
			else if(furniture.equals("meeting_tables")){
				if(color.equals("blue")){
					return (katalog[branch].meeting_tables[model_number][0]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].meeting_tables[model_number][1]>0);
				}
				else if(color.equals("yellow")){
					return (katalog[branch].meeting_tables[model_number][2]>0);
				}
				else if(color.equals("green")){
					return (katalog[branch].meeting_tables[model_number][3]>0);
				}
				else if(color.equals("red")){
					return (katalog[branch].meeting_tables[model_number][4]>0);
				}
				else
					return false;
			}
			else if(furniture.equals("bookcases")){
				return (katalog[branch].bookcases[model_number]>0);

			}

			else if(furniture.equals("office_cabinets")){
				return (katalog[branch].office_cabinets[model_number]>0);
			}

		

		return false;
	}
	/**
    *makes the customer a member
    *@param name,surname,email,password 
    */
	public void login_system(String name,String surname,String email,String password){
	
		if(costumers==null){
			
			costumers=new costumer_information[1];
			costumers[0]=new costumer_information();
			costumers[0].name=new String(name);
			costumers[0].surname=new String(surname);
			email_=new String(email);
			costumers[0].email=new String(email_);
			password_=new String(password);
			costumers[0].password=new String(password_);
			costumers[0].id=0;
			System.out.println("NAME=ahmet\nSURNAME=okur\nEMAIL=ahmetokur_41@hotmail.com\nPASSWORD=asdasdasd");
			System.out.println("REGISTERED\n");
			return ;

		}
		email_=new String(email);	
		password_=new String(password);
		
		int size=costumers.length;
		costumer_information tmp[]=new costumer_information[size+1];
		for(int i=0;i<size;i++){
			tmp[i]=costumers[i];
		}
		tmp[size]=new costumer_information();
		tmp[size].name=new String(name);
		tmp[size].surname=new String(surname);
		tmp[size].email=new String(email);
		tmp[size].password=new String(password);
		costumers[size].id=size;
		costumers=tmp;
		System.out.println("REGISTERED\n");
		System.out.println("NAME=ahmet\nSURNAME=okur\nEMAIL=ahmetokur_41@hotmail.com\nPASSWORD=asdasdasd");
		
		
	}
	/**
    *member logs in
    *@param email,password 
    *@return true if this array contains the  product
    */
	public boolean login_system(String email,String password){
		email_=new String(email);	
		password_=new String(password);
		if(costumers==null){
			System.out.println("PLEASE REGISTER");
			return false;
		}
		for(int i=0;i<costumers.length;i++){
			if(costumers[i].email.equals(email_) && costumers[i].password.equals(password_) ){
				System.out.println("LOG IN");
				return true;
			}
		}
		System.out.println("PLEASE REGISTER");
		return false;
	}
	/**
    *member buys products online
    *@param choose,addres,phone_number 
    */
	public void buy_product_online(int choose,String addres,String phone_number){
		int which_product=choose%119;
		int i;
		boolean flag=false;
		
		if(choose>-1){
			/*işçinina adresini bulur*/
			for(i=0;i<costumers.length;i++){
				if(costumers[i].email.equals(email_)&&costumers[i].password.equals(password_)){
					break;
				}
			}
			/*bilgi update*/
			
			String tmp[]=new String[1];
			if(costumers[i].prev_view!=null){		
				tmp=new String[costumers[i].prev_view.length+1];
				for(int j=0;j<costumers[i].prev_view.length;j++){
					tmp[j]=costumers[i].prev_view[j];
				}
				flag=true;
			}
			else{
				costumers[i].prev_view=new String[1];
			}

			if(which_product>-1 && which_product<12){
				/*bookcase*/
				katalog[choose/119].bookcases[which_product]-=1;
				if(flag==true){
					tmp[costumers[i].prev_view.length]=new String("bookcase");
					costumers[i].prev_view=tmp;
				}
				else
					costumers[i].prev_view[0]=new String("bookcase");

			}
			else if(which_product>11 && which_product<24){
				which_product-=12;
				katalog[choose/119].office_cabinets[which_product]-=1;
				if(flag==true){
					tmp[costumers[i].prev_view.length]=new String("office_cabinets");
					costumers[i].prev_view=tmp;
				}
				else
					costumers[i].prev_view[0]=new String("office_cabinets");
			}
			
			else if(which_product>23 && which_product<59){
				which_product-=24;
				katalog[choose/119].chairs[which_product/7][which_product%5]-=1;
				if(flag==true){
					tmp[costumers[i].prev_view.length]=new String("chair");
					costumers[i].prev_view=tmp;
				}
				else
					costumers[i].prev_view[0]=new String("chair");
			}
			
			else if(which_product>58 && which_product<79){
				which_product-=59;
				katalog[choose/119].desks[which_product/5][which_product%4]-=1;
				if(flag==true){
					tmp[costumers[i].prev_view.length]=new String("desk");
					costumers[i].prev_view=tmp;
				}
				else
					costumers[i].prev_view[0]=new String("desk");
			}
			
			else {
				which_product-=79;
				katalog[choose/119].meeting_tables[which_product/4][which_product%4]-=1;
				if(flag==true){
					tmp[costumers[i].prev_view.length]=new String("meeting_tables");
					costumers[i].prev_view=tmp;
				}
				else
					costumers[i].prev_view[0]=new String("meeting_tables");
			}
			costumers[i].address=new String(addres);
			costumers[i].phone_number=new String(phone_number);

		}
		else{
			System.out.println("INCORRECT ENTRY");
		}
	}
	/**
    *member checks past purchases
    */
	public void show_prev_views(){
		int i;
		
		for(i=0;i<costumers.length;i++){
			if(costumers[i].email.equals(email_)&&costumers[i].password.equals(password_)){
				break;
			}
		}
		if(costumers[i].prev_view!=null){
			for(int j=0;j<costumers[i].prev_view.length;j++){
				System.out.println(costumers[i].prev_view[j]);
			}
		}
	}
	
}
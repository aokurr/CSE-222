public class employeee implements person{
	public branch katalog[];
	public int number;
	public employeee(branch a[],int branch_number){
		katalog=a;
		number=branch_number;
	}
	/**
    *THIS FUNCTION SHOWS THE PRODUCTS ON THE BRANCHES
    */
	public void see_all_product(){
		int i,j,count=0;;
		char ch;
		System.out.println("POLYMORPHISM EXAMPLE 2");
		for(j=0;j<number;j++){
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
		

		return false;
	}
	/**
    *The desired product is added to the desired branch.for model and color
    *@param branch_id,product,color_id,model_id
    */
	public void add_product(int branch_id,String product,int color_id,int model_id )throws ahmets_exceptions{
		if(branch_id>katalog.length+1){
			throw new ahmets_exceptions("INCORRECT BRANCH ID PLEASE TRY AGAIN");
		}
		if(product.equals("chairs")){
			katalog[branch_id].chairs[model_id][color_id]++;
		}
		if(product.equals("desks")){
			katalog[branch_id].desks[model_id][color_id]++;
		}
		if(product.equals("meeting_tables")){
			katalog[branch_id].meeting_tables[model_id][color_id]++;
		}	

	}
	/**
    *The desired product is added to the desired branch.just model
    *@param branch_id,product,model_id
    */
	public void add_product(int branch_id,String product,int model_id )throws ahmets_exceptions{
		if(branch_id>katalog.length+1){
			throw new ahmets_exceptions("INCORRECT BRANCH ID PLEASE TRY AGAIN");
		}
		if(product.equals("bookcases")){
			katalog[branch_id].bookcases[model_id]++;
		}
		if(product.equals("office_cabinets")){
			katalog[branch_id].office_cabinets[model_id]++;
		}

	}
	
	/**
    *The desired product is deleted to the desired branch.for model and color
    *@param branch_id,product,color_id,model_id
    */
	public void remove_product(int branch_id,String product,int color_id,int model_id )throws ahmets_exceptions{
		
		if(product.equals("chairs")){
			if(katalog[branch_id].chairs[model_id][color_id]<1){
				throw new ahmets_exceptions("THIS PRODUCT ALREADY NO");
			}
			katalog[branch_id].chairs[model_id][color_id]--;

		}
		if(product.equals("desks")){
			if(katalog[branch_id].desks[model_id][color_id]<1){
				throw new ahmets_exceptions("THIS PRODUCT ALREADY NO");
			}
			katalog[branch_id].desks[model_id][color_id]--;
		}
		if(product.equals("meeting_tables")){
			if(katalog[branch_id].meeting_tables[model_id][color_id]<1){
				throw new ahmets_exceptions("THIS PRODUCT ALREADY NO");
			}
			katalog[branch_id].meeting_tables[model_id][color_id]--;
		}	

	}
	/**
    *The desired product is deleted to the desired branch.just model
    *@param branch_id,product,model_id
    */
	public void remove_product(int branch_id,String product,int model_id )throws ahmets_exceptions{
		if(product.equals("bookcases")){
			if(katalog[branch_id].bookcases[model_id]<1){
				throw new ahmets_exceptions("THIS PRODUCT ALREADY NO");
			}
			katalog[branch_id].bookcases[model_id]--;
		}
		if(product.equals("office_cabinets")){
			if(katalog[branch_id].office_cabinets[model_id]<1){
				throw new ahmets_exceptions("THIS PRODUCT ALREADY NO");
			}
			katalog[branch_id].office_cabinets[model_id]--;
		}

	}
	
	/**
    *shop from the store creates an employee if there is no registration.for model and color
    *@param costumer_,id,branch_id,product,model_id,color_id
    */
	public void buy_product_store(costumer costumer_,int id,int branch_id,String product,int model_id,int color_id)throws ahmets_exceptions{
		if(costumer_.costumers.length>id){
			String tmp[]=new String[costumer_.costumers[id].prev_view.length+1];
			remove_product(branch_id,product,color_id,model_id);
			for(int i=0;i<costumer_.costumers[id].prev_view.length;i++){
				tmp[i]=new String(costumer_.costumers[id].prev_view[i]);

			}
			tmp[costumer_.costumers[id].prev_view.length]=new String(product);
			costumer_.costumers[id].prev_view=tmp;
		}
		else{
			System.out.println("Lütfen kayıt olun\n");
			int size=costumer_.costumers.length;
			costumer_information tmp_inf[]=new costumer_information[size+1];
			for(int i=0;i<size;i++){
				tmp_inf[i]=costumer_.costumers[i];
			}
			tmp_inf[size]=new costumer_information();
			tmp_inf[size].name=new String("name"+size);
			tmp_inf[size].surname=new String("surname"+size);		
			
			tmp_inf[size].email=new String(size+"@hotmail.com");
			
			tmp_inf[size].password=new String("password"+size);
			tmp_inf[size].id=size;	
			costumer_.costumers=tmp_inf;
		}

	}
	/**
    *shop from the store creates an employee if there is no registration.just model
    *@param costumer_,id,branch_id,product,model_id
    */
	public void buy_product_store(costumer costumer_,int id,int branch_id,String product,int model_id)throws ahmets_exceptions{
		
		if(costumer_.costumers.length>id){
			String tmp[]=new String[costumer_.costumers[id].prev_view.length+1];
			remove_product(branch_id,product,model_id);
			for(int i=0;i<costumer_.costumers[id].prev_view.length;i++){
				tmp[i]=new String(costumer_.costumers[id].prev_view[i]);
			}
			tmp[costumer_.costumers[id].prev_view.length]=new String(product);
			costumer_.costumers[id].prev_view=tmp;
		}
		else{
			System.out.println("Lütfen kayıt olun\n");
			int size=costumer_.costumers.length;
			costumer_information tmp_inf[]=new costumer_information[size+1];
			for(int i=0;i<size;i++){
				tmp_inf[i]=costumer_.costumers[i];
			}
			tmp_inf[size]=new costumer_information();
			tmp_inf[size].name=new String("name"+size);
			tmp_inf[size].surname=new String("surname"+size);		
			
			tmp_inf[size].email=new String(size+"@hotmail.com");
			
			tmp_inf[size].password=new String("password"+size);
			tmp_inf[size].id=size;
			costumer_.costumers=tmp_inf;
		}
	}
	/**
    *shows the employee member's past purchases
    *@param costumers[],email_,password_
    */
	public void show_prev_views(costumer_information costumers[],String email_,String password_)throws ahmets_exceptions{
		int i;
		if(costumers==null){
			throw new ahmets_exceptions("THERE IS NO COSTUMER");
		}
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
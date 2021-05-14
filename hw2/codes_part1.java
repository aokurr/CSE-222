
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
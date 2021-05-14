/**
*<h1> JAVA automatıon system HOMEWORK-1!</h1>
*@author AHMET OKUR
*@since 2021-03-13
*/
import java.util.Scanner;
public class test{
	public static void main(String[] args){
		driver_function();

	}

	
	public static void polymorphism_test_see_all(person a){
		a.see_all_product();
	}
	
	public static void driver_function(){
		automation_system test= new automation_system();
			/*********************ADMIN TEST**********************************/
			System.out.println("ADMIN TEST AREA\n");
			
			System.out.println("BRANCH DELETED TEST FOUR BRACH!");
			System.out.println("BEFORE BRANCH NUMBER="+test.branchs.length);
		
				/*exception handling contolr*/
			try{
				test.delete_branch();
				test.delete_branch();
				test.delete_branch();
				test.delete_branch();
				System.out.println("NEW BRANCH NUMBER="+test.branchs.length);
				System.out.println("ADMIN DELETE BRANCH EXCEPTION TEST");
				test.delete_branch();
			}
			catch (Exception e){
		        System.out.println(e.toString());
		    }
			System.out.println("BRANCH ADDED TEST FOUR BRACH!");	
			test.add_branch();
			test.add_branch();
			test.add_branch();
			test.add_branch();
			System.out.println("NEW BRANCH NUMBER="+test.branchs.length);
				
				

			System.out.println("\n ***ADD EMPLOYEE AND DELETE EMPLOYE TEST***\nBEFORE EMPLOYEE NAMES");
			test.see_employee();
			test.admin_test.add_employee(test.branchs[1],"bahadır");
			System.out.println("\nADMIN ADD EMPLOYEE 'BAHADIR' BRANCH 2");
			System.out.println("AFTER EMPLOYEE NAMES");
			test.see_employee();
			try{
				test.admin_test.delete_employee(test.branchs[1],"ahmet");
				System.out.println("\nADMIN DELETE EMPLOYEE 'AHMET' BRANCH 2");
			}
			catch (Exception e){
		        System.out.println(e.toString());
		    }
			System.out.println("AFTER EMPLOYEE NAMES");
			test.see_employee();
			
			/*********************COSTUMER TEST**********************************/
			System.out.println("COSTUMER TEST AREA\n");	
			System.out.println("\nLOGIN SYSTEM FIRST LOGIN");	
			
			if(test.costumer_test.login_system("ahmetokur_41@hotmail.com","qweasdzxc")==false){
				System.out.println("IN THIS SECTION IS TRYING TO LOGIN WITH MAIL AND PASSWORD BUT FAILS");
				System.out.println("THERE IS NO SUCH MEMBER");
				test.costumer_test.login_system("ahmet","okur","ahmetokur_41@hotmail.com","qweasdzxc");
			}
			System.out.println("\nCOSTUMER SHOP ONLINE ");

			System.out.println("SEE ALL PRODUCT BEFORE SHOPPING");
			polymorphism_test_see_all(test.costumer_test);
			
			System.out.println("\nCOSTUMER BUY PRODUCT !!121st product!!");	
			test.costumer_test.buy_product_online(121,"gebze teknik üni. bilgisayar müh.","02121312");//bookcase
			test.costumer_test.buy_product_online(55,"gebze teknik üni. bilgisayar müh.","02121312");//chair
			System.out.println("\nADRESS=gebze teknik üni. bilgisayar müh. PHONE_NUMBER=02121312!!");
			
			System.out.println("\nSEE ALL PRODUCT");
			polymorphism_test_see_all(test.costumer_test);
			
			System.out.println("\nCUSTOMER VIEWS PREVIOUS ORDERS");
			test.costumer_test.show_prev_views();
			System.out.println("\nPRODUCT IS IN CONTROL");
			if(test.costumer_test.product_is_in(0,"desks",'A',"blue")==true){
				System.out.println("YES PRODUCT IS IN");
			}
			
			/*********************EMPLOYEE TEST**********************************/
			System.out.println("\nEMPLOYEE TEST AREA");		
			System.out.println("\nADD AND REMOVE PRODUCT LİNE 64 and 60 BEFORE");
			
			polymorphism_test_see_all(test.employee_test);	
			try{
				test.employee_test.add_product(0,"desks",1,1);
			}
			catch(Exception e){
				System.out.println(e.toString());
			}

			try{
				test.employee_test.remove_product(0,"desks",1,0);
			}
			catch(Exception e){
				System.out.println("asda");
				System.out.println(e.toString());
			}
			System.out.println("\nSHOPPING FROM THE STORE LINE 13");
				
			try{
				test.employee_test.buy_product_store(test.costumer_test,0,0,"office_cabinets",1);
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
			System.out.println("\nSEE ALL PRODUCT");
			polymorphism_test_see_all(test.employee_test);
			//test.employee_test.see_all_product();	
			try{
				System.out.println("\nCUSTOMER VIEWS PREVIOUS ORDERS");
				test.employee_test.show_prev_views(test.costumer_test.costumers,"ahmetokur_41@hotmail.com","qweasdzxc");
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
			System.out.println("\nCOSTUMER IS IN FUNCTION CONTROL A MODEL DESKS BLUE 1. BRANCH");
			if(test.employee_test.product_is_in(0,"desks",'A',"blue")==true){
				System.out.println("YES PRODUCT IS IN");
			}
	}		
}

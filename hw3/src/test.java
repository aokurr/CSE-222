/**
*<h1> JAVA automatıon system HOMEWORK-1!</h1>
*@author AHMET OKUR
*@since 2021-03-13
*/
import java.util.Scanner;
public class test {
	public static void main(String[] args) {
		driver_func();


	}
	public static void driver_func(){
		automation_system test_outamation=new automation_system();
		/******************		TEST ADMIN AREA		****************/
		System.out.println("BEFORE ADD/DELETE BRANCH");
		test_outamation.admin_skills.show_branchs_name();

		System.out.println("\nAFTER ADD KASTAMONU");
		test_outamation.admin_skills.add_branch("KASTAMONU");
		test_outamation.admin_skills.show_branchs_name();

		System.out.println("\nAFTER DELETE İZMİT");
		test_outamation.admin_skills.delete_branch(4);
		test_outamation.admin_skills.show_branchs_name();

		System.out.println("***BEFORE ADD/DELETE EMPLOYEE***");
		test_outamation.admin_skills.print_employee(0);

		System.out.println("\n***AFTER ADD ARGIT***");
		test_outamation.admin_skills.add_employee(0,"ARGIT");
		test_outamation.admin_skills.print_employee(0);

		System.out.println("\n***AFTER DELETE HATİCE***");
		test_outamation.admin_skills.delete_employee(0,"HATİCE");
		test_outamation.admin_skills.print_employee(0);

		/******************		TEST COSTUMER AREA		****************/
		System.out.println("\n\n***FIRST LOGİN SYSTEM 2 PEOPLE***");
		test_outamation.costumer_skills.login_system("AHMET","OKUR","a.okur2018@gtu.edu.tr","asdasd");
		test_outamation.costumer_skills.login_system("MEHMET","OKUR","a.mehmet@gtu.edu.tr","sasasa");

		System.out.println("***LOGİN SYSTEM FOR MEHMET OKUR***");
		test_outamation.costumer_skills.login_system("a.mehmet@gtu.edu.tr","sasasa");
		System.out.println("***LOGİN SYSTEM INCORRECT EMAİL***");
		test_outamation.costumer_skills.login_system("a.mehmeast@gtu.edu.tr","sasasa");

		System.out.println("***BRANCH 3 is in product BLUE DESK CONTROL***");
		System.out.println(test_outamation.costumer_skills.product_is_in(2,"DESK",'A',1));

		test_outamation.costumer_skills.login_system("a.mehmet@gtu.edu.tr","sasasa");
		System.out.println("***BUY PRODUCT ONLINE DESK A MODEL COLOR=BLUE ***");
		test_outamation.costumer_skills.buy_product_online(1,"DESK",1,'A',"kocaeli/izmit","213123");

		System.out.println("***COSTUMER SEE ALL BRANCH AND FURNITURE***");
		test_outamation.costumer_skills.see_all_product();

		System.out.println("******Show PREVIOUS****");
		test_outamation.costumer_skills.show_prev_views();


		/******************		TEST EMPLOYEE AREA		****************/
		System.out.println("\n******************\t\tTEST EMPLOYEE AREA\t\t****************");
		System.out.println("\n***BRANCH 3 is in product BLUE DESK REMOVE 2 TIMES");
		test_outamation.employee_skills.remove_product(2,"DESK",1,'A');
		test_outamation.employee_skills.remove_product(2,"DESK",1,'A');

		System.out.println("***AFTER REMOVE BRANCH 3 is in product BLUE DESK CONTROL(EMPLOYEE)***");
		System.out.println(test_outamation.employee_skills.product_is_in(2,"DESK",'A',1));

		System.out.println("\n***BRANCH 3 is in product BLUE DESK ADD 2 TIMES");
		test_outamation.employee_skills.add_product(2,"DESK",1,'A');
		test_outamation.employee_skills.add_product(2,"DESK",1,'A');

		System.out.println("***AFTER ADD BRANCH 3 is in product BLUE DESK CONTROL(EMPLOYEE)***");
		System.out.println(test_outamation.employee_skills.product_is_in(2,"DESK",'A',1));

		System.out.println("***BUY PRODUCT STORE TEST FOR MEHMET OKUR DESK B RED***\n");
		try {
			test_outamation.employee_skills.buy_product_store(test_outamation.costumer_skills, 1, 1, "DESK", 'B', 2);
		}
		catch (Exception e){
			System.out.println(e);
		}

		test_outamation.costumer_skills.show_prev_views();

	}
}
	

	

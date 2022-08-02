import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<Package> packageList = new ArrayList<Package>();
		packageList.add(new Package(001, "PackageA", "2020-09-04", "2021-01-15", 5000));
		packageList.add(new Package(002, "PackageB", "2021-04-16", "2021-10-23", 6540));
		
		ArrayList<RequestQuotation> requestQuotationList = new ArrayList<RequestQuotation>();
		requestQuotationList.add(new RequestQuotation("HDB", 170, "Lee Jackson", 87500650, "kokpop1090@gmail.com", 50000, "10-8-2022", "kitches", 1, 0, null, null));
		requestQuotationList.add(new RequestQuotation("HDB", 170, "KOKPOP", 87500650, "cbbawe1090@gmail.com", 100000, "20-8-2022", "toilet", 0, 1, null, null));


		int option = 0;

		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			switch (option) {
			
			case 1:  //Customer view: Request Quotation, Add appointment		
				customerMenu();
				int customerOption = Helper.readInt("Enter an option > ");
				
				switch (customerOption) {
				case 1:  //Request for quotation
					RequestQuotation userrq = inputRequestQuotation();
					C206_CaseStudy.addRequestQuotation(requestQuotationList, userrq);
					System.out.println("Quotation Requested");
					break;
				case 2: // Make appointment
				}
				break;
				
				
			case 2:  //Admin view: Add/Delete/View Package, Add/View/Delete Appointment, View/Delete request quotation
				adminMenu();
				int adminOption = Helper.readInt("Enter an option > ");
				
				switch (adminOption) {
				
				case 1:  //Manage Package
					adminPackageMenu();
					int adminPackageOption = Helper.readInt("Enter an option > ");
					
					switch (adminPackageOption) {
					case 1: //View package
						C206_CaseStudy.viewAllPackage(packageList);
						break;
					case 2: //Add package
						Package userp = inputPackage();
						C206_CaseStudy.addPackage(packageList, userp);
						System.out.println("Package added");
						break;
					case 3: //Delete Package
						
					}
					break;
				case 2:  //Manage Appointment
					break;
				
				case 3:  //Manage Quotation Requests
					adminReqQuotMenu();
					int adminReqQuoOption = Helper.readInt("Enter an option > ");
					
					switch (adminReqQuoOption) {
					case 1: //View Quotation request
						C206_CaseStudy.retrieveAllRequestQuotation(requestQuotationList);
					case 2: //Delete Quotation request
					}
					break;
					
				}//end of adminOption
				break;

				 
			case 3:  //Designer view: Add/View/Delete quotation, View request quotation
				break;
				
			case 4:
				System.out.println("Bye!");
				option = 4;
				break;
			}
		}//end of while loop
		
	}//end of method
	
	
	public static void menu() {
		C206_CaseStudy.setHeader("Renovation ACE Website");
		System.out.println("1. Enter as a Customer");
		System.out.println("2. Enter as an Admin");
		System.out.println("3. Enter as an Designer");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void adminMenu() {
		C206_CaseStudy.setHeader("Admin");
		System.out.println("1. Manage Package");
		System.out.println("2. Manage Appointment");
		System.out.println("3. Manage Quotation Requests");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void adminPackageMenu() {
		C206_CaseStudy.setHeader("Manage Package");
		System.out.println("1. View Package");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void adminReqQuotMenu() {
		C206_CaseStudy.setHeader("Manage Quotation Requests");
		System.out.println("1. View quotation request");
		System.out.println("2. Delete quotation request");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	
	public static void customerMenu() {
		C206_CaseStudy.setHeader("Customer");
		System.out.println("1. Request For Quotation");
		System.out.println("2. Make Appointment");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static Package inputPackage() {
		int code = Helper.readInt("Enter package code > ");
		String description = Helper.readString("Enter description > ");
		String startDate = Helper.readString("Enter start date in format (yyyy-mm-dd) > ");
		String endDate = Helper.readString("Enter end date in format (yyyy-mm-dd) > ");
		double amount = Helper.readDouble("Enter amount > ");

		Package p= new Package(code, description, startDate, endDate, amount);
		return p;	
	}
	
	public static void addPackage(ArrayList<Package> packageList, Package p) {
		packageList.add(p);
	}
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-10d %-30s %-15s %-15s %-10.2f\n", packageList.get(i).getCode(),
					packageList.get(i).getDescription(), (packageList.get(i).getStartDate()),
					packageList.get(i).getEndDate(),packageList.get(i).getAmount());
		}
		return output;
	}
	
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-30s %-15s %-15s %-10s\n", "CODE", "DESCRIPTION",
				"START DATE", "END DATE","AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.println(output);
	}
	
	public static int inputDelPackage() {
		int code = Helper.readInt("Enter package code > ");
		return code;	
	}
	
//	public static boolean verifyPackage(ArrayList<Package> packageList, int x) {
//		boolean isExist = true;
//		
//		for(Package i : packageList) {
//			if (x == i.getCode()) {
//				isExist = true;
//			}
//		}
//		return isExist;
//	}

	public static void removePackage(ArrayList<Package> packageList, int x) {
		for(Package i : packageList) {
			if (x == i.getCode()) {
				packageList.remove(i);
			}
		}
	}
	
	public static RequestQuotation inputRequestQuotation() {
		String propertyType = Helper.readString("Enter Property type > ");
		Double areaSize = Helper.readDouble("Enter Area size > ");
		String name = Helper.readString("Enter requestor name > ");
		int no = Helper.readInt("Enter contact number > ");
		String email = Helper.readString("Enter requestor email > ");
		double budget = Helper.readDouble("Enter your budget > ");
		String date = Helper.readString("Target completion date > ");
		String type = Helper.readString("Enter your renovation type ");
		int numberOfRoom = Helper.readInt("Number of rooms to renovate ");
		int numberOfToilet = Helper.readInt("Number of toilets to renovate");
		String style = Helper.readString("Renovation style");
		String urgent = Helper.readString("Urgent request");
		
		RequestQuotation qq = new RequestQuotation(propertyType, areaSize, name, no, email,budget, date, type, numberOfRoom, numberOfToilet,style, urgent);
		return qq;
	}
		
	public static void addRequestQuotation(ArrayList<RequestQuotation> requestQuotationList, RequestQuotation qq) {
		requestQuotationList.add(qq);
	}

	public static String retrieveAllRequestQuotation(ArrayList<RequestQuotation> requestQuotationList) {
		String output = "";

		for (int i = 0; i < requestQuotationList.size(); i++) {

			output += String.format("%-10s %-10.2f %-10s %-10d %-20s %-10.2f %-10s %-10s %-10d %-10d %-10s %-10s\n", requestQuotationList.get(i).getPropertyType(),
					requestQuotationList.get(i).getAreaSize(), requestQuotationList.get(i).getRequestorName(), 
					requestQuotationList.get(i).getContactNumber(), requestQuotationList.get(i).getEmail() , 
					requestQuotationList.get(i).getBudget(),requestQuotationList.get(i).getCompletionDate() ,
					requestQuotationList.get(i).getRenovationType()	, requestQuotationList.get(i).getNumOfRoom(), 
					requestQuotationList.get(i).getNumOfToilet() , requestQuotationList.get(i).getRenovationStyle() , 
					requestQuotationList.get(i).getUrgentReq());					
		}
		return output;
	}

	public static void viewAllRequestQuotation(ArrayList<RequestQuotation> requestQuotationList) {
		C206_CaseStudy.setHeader("REQUEST FOR QUOTATION LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "PROPERTY TYPE", "AREA SIZE",
				"REQUESTOR NAME", "CONTACT NUMBER","EMAIL", "BUDGET", "TARGET COMPLETION DATE","RENOVATION TYPE","NUMBER OF ROOMS TO RENOVATE","NUMBER OF TOILETS TO RENOVATE","RENOVATION STYLE","URGENT REQUST");
		 output += retrieveAllRequestQuotation(requestQuotationList);	
		System.out.println(output);
	}

}//end of class

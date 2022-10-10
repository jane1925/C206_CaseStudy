import java.util.ArrayList;

public class C206_CaseStudy {

	public static ArrayList<Package> packageList = new ArrayList<Package>();
	public static ArrayList<RequestQuotation> requestQuotationList = new ArrayList<RequestQuotation>();
	public static ArrayList<ManageQuotation> manageList = new ArrayList<ManageQuotation>();
	public static ArrayList<RequestAppointment> AppointmentList = new ArrayList<RequestAppointment>();
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		
		packageList.add(new Package(001, "PackageA", "2020-09-04", "2021-01-15", 5000.20));
		packageList.add(new Package(002, "PackageB", "2021-04-16", "2021-10-23", 6540.90));
		
		requestQuotationList.add(new RequestQuotation("HDB", 170, "Lee Jackson", 87500650, "kokpop1090@gmail.com", 50000, "10-8-2022", "kitches", 1, 0, null, null));
		requestQuotationList.add(new RequestQuotation("HDB", 170, "KOKPOP", 87500650, "cbbawe1090@gmail.com", 100000, "20-8-2022", "toilet", 0, 1, null, null));
		
		manageList.add(new ManageQuotation(1234, 8765, "Kitchen", "tiles", "Heisenburg", "9-8-2022", 500000));
		
		AppointmentList.add(new RequestAppointment("Arya",88888888,"ar19@gmail.com","19-10-1999","10:30","Amberd","Admirality",""));
		AppointmentList.add(new RequestAppointment("John",66666666,"jh@gmail.com","10-10-1999","4:30","Heard","Canberra",""));

		
		int option = 0;

		while (option != OPTION_QUIT) {

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
					adminAppointMenu();
					break;
				}
				break;
				
				
			case 2:  //Admin view: Add/Delete/View Package, Add/View/Delete Appointment, View/Delete request quotation
				adminMenu();
				int adminOption = Helper.readInt("Enter an option > ");
				
				switch (adminOption) {
				
				case 1:  //Manage Package
					adminPackageOption();					
					break;
					
				case 2:  //Manage Appointment
					break;
				
				case 3:  //Manage Quotation Requests
					adminReqQuoOption();
					break;
					
				}//end of adminOption
				break;

			case 3:  //Designer view: Add/View/Delete quotation, View request quotation
				designQuoOption();
				break;
				
			case OPTION_QUIT:
				System.out.println("Bye!");
				option = 4;
				break;
				
			default:
				System.out.println("Invalid input");
				break;		
			}
		}//end of while loop
		
	}//end of method
	
	
	public static void menu() {
		setHeader("Renovation ACE Website");
		System.out.println("1. Enter as a Customer");
		System.out.println("2. Enter as an Admin");
		System.out.println("3. Enter as an Designer");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void customerMenu() {
		setHeader("Customer");
		System.out.println("1. Request For Quotation");
		System.out.println("2. Make Appointment");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void adminMenu() {
		setHeader("Admin");
		System.out.println("1. Manage Package");
		System.out.println("2. Manage Appointment");
		System.out.println("3. Manage Quotation Requests");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void designerMenu() {
		setHeader("Designer");
		System.out.println("1. View Quotation");
		System.out.println("2. Add Quotation");
		System.out.println("3. Delete Quotation");
		System.out.println("4. View Quotation Requests");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static void adminPackageMenu() {
		setHeader("Manage Package");
		System.out.println("1. View Package");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void adminReqQuotMenu() {
		setHeader("Manage Quotation Requests");
		System.out.println("1. View quotation request");
		System.out.println("2. Delete quotation request");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void adminAppointMenu() {
		setHeader("Manage Appointment");
		System.out.println("1. View appointment");
		System.out.println("2. Make appointment");
		System.out.println("3. Delete appointment");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void adminPackageOption(){
		adminPackageMenu();
		int adminPackageOption = Helper.readInt("Enter an option > ");

		switch (adminPackageOption) {
		case OPTION_VIEW:
			viewAllPackage(packageList);
			break;
		case OPTION_ADD:
			Package userp = inputPackage();
			addPackage(packageList, userp);
			System.out.println("Package added");
			break;
		case OPTION_DELETE:
			removePackage(packageList);
			break;
		default:
			System.out.println("Invalid input");
		}
	}
	
	public static void adminReqQuoOption(){
		adminReqQuotMenu();
		int adminReqQuoOption = Helper.readInt("Enter an option > ");		

		switch (adminReqQuoOption) {
		case OPTION_VIEW:
			viewAllRequestQuotation(requestQuotationList);
			break;
		case 2: //Delete Quotation request
			removeRequestQuotation(requestQuotationList);
			break;
		case 3:
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	
	public static void adminAppointOption(){
		adminAppointMenu();
		int adminAppointOption = Helper.readInt("Enter an option > ");

		switch (adminAppointOption) {
		case OPTION_VIEW:
			retrieveAllAppointments(AppointmentList);
			break;
		case OPTION_ADD:
			RequestAppointment userp = inputManageAppointments();
			addPackage(AppointmentList, userp);
			System.out.println("Package added");
			break;
		case OPTION_DELETE:
			removePackage(packageList);
			break;
		default:
			System.out.println("Invalid input");
		}
	}


	public static void designQuoOption(){
		designerMenu();
		int desigOption = Helper.readInt("Enter an option > ");		

		switch (desigOption) {
		case OPTION_VIEW:
			viewAllManageQuotation(manageList);
			break;
		case OPTION_ADD:
			ManageQuotation userq = inputManageQuotation();
			addManageQuotation(manageList, userq);
			System.out.println("Quotation added");
			break;
		case OPTION_DELETE:
			removeManageQuotation(manageList);
			break;
		case 4:
			viewAllRequestQuotation(requestQuotationList);
			break;
		case 5:
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
		
	
	//================================= Manage Package (Jane)  =================================
	
	public static boolean findPackageCode(ArrayList<Package> packageList, int x) {
		boolean isExist = false;
		
		for(Package i : packageList) {
			if (x == i.getCode()) {
				isExist = true;
			}
		}
		return isExist;
	}

	public static Package inputPackage() {
		int code = Helper.readInt("Enter package code > ");
		boolean isFound = findPackageCode(packageList, code);
		
		while(isFound == true) {
				System.out.println("Package code already exists!");
				code = Helper.readInt("Enter package code > ");
				isFound = findPackageCode(packageList, code);
		}

		String description = Helper.readString("Enter description > ");
		String startDate = Helper.readString("Enter start date in format (yyyy-mm-dd) > ");
		String endDate = Helper.readString("Enter end date in format (yyyy-mm-dd) > ");
		double amount = Helper.readDouble("Enter amount > ");
		
		Package p = new Package(code, description, startDate, endDate, amount);
		return p;	
	}
	
	public static void addPackage(ArrayList<Package> packageList, Package p) {
		packageList.add(p);
	}
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-74s", packageList.get(i).toString());	
		}
		return output;
	}
	
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-20s %-15s %-15s %-10s\n", "CODE", "DESCRIPTION",
				"START DATE", "END DATE","AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.println(output);
	}

	public static void doRemovePackage(ArrayList<Package> packageList, int x) {
		for(Package i : packageList) {
			if (x == i.getCode()) {
				packageList.remove(i);
			}
		}
	}
	
	public static void removePackage(ArrayList<Package> packageList) {
		viewAllPackage(packageList);
		int code = Helper.readInt("Enter package code > ");
		boolean isFound = findPackageCode(packageList, code);
				
		while(isFound == false) {
			System.out.println("Package doesn't exist!");
			code = Helper.readInt("Enter package code > ");
			isFound = findPackageCode(packageList, code);
		}
		doRemovePackage(packageList, code);					
		System.out.println("Package deleted");
	}
	
	
	
	

	//================================= Manage Requests Quotation (Jackson)  =================================
		
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

			output += String.format("%-207s", requestQuotationList.get(i).toString());					
		}
		return output;
	}

	public static void viewAllRequestQuotation(ArrayList<RequestQuotation> requestQuotationList) {
		C206_CaseStudy.setHeader("REQUEST FOR QUOTATION LIST");
		String output = String.format("%-15s %-10s %-20s %-20s %-25s %-10s %-25s %-20s %-20s %-20s %-20s %-20s\n", "PROPERTY TYPE", "AREA SIZE",
				"REQUESTOR NAME", "CONTACT NUMBER","EMAIL", "BUDGET", "TARGET COMPLETION DATE","RENOVATION TYPE","NUMBER OF ROOMS","NUMBER OF TOILETS","RENOVATION STYLE","URGENT REQUST");
		 output += retrieveAllRequestQuotation(requestQuotationList);	
		System.out.println(output);
	}
	
	public static boolean findRequestorName(ArrayList<RequestQuotation> requestQuotationList, String x) {
		boolean isExist = false;
		
		for(RequestQuotation i : requestQuotationList) {
			if (x.equalsIgnoreCase(i.getRequestorName())) {
				isExist = true;
			}
		}
		return isExist;
	}

	public static void doRemoveRequestQuotation(ArrayList<RequestQuotation> requestQuotationList, String x) {
		for(RequestQuotation i : requestQuotationList) {
			if (x.equalsIgnoreCase(i.getRequestorName())) {
				requestQuotationList.remove(i);
			}
		}
	}

	public static void removeRequestQuotation(ArrayList<RequestQuotation> requestQuotationList) {
		String name = Helper.readString("Enter requestor name > ");
		boolean verify = findRequestorName(requestQuotationList, name);

		if(verify == true) {
			doRemoveRequestQuotation(requestQuotationList, name);					
			System.out.println("Request for quotation deleted");
		}else {
			System.out.println("Invalid requestor name");
		}
	}
	
    //================================= Manage Quotation (Shamir) =================================
    public static String retrieveAllManageQuotation(ArrayList<ManageQuotation> ManageQuotationList) {
        String output = "";

        for (int i = 0; i < ManageQuotationList.size(); i++) {
            output += String.format("%-103s", ManageQuotationList.get(i).toString());
        }
        return output;
    }

    public static void viewAllManageQuotation(ArrayList<ManageQuotation> ManageQuotationList) {
        C206_CaseStudy.setHeader("Quotation");
        String output = String.format("%-15s%-15s%-13s%-20s%-15s%-15s%-10s\n","REQUEST ID","QUOTATION ID","CATEGORY","ITEMS IN CATEGORY","DESIGNER","START DATE","TOTAL AMOUNT");

        output += retrieveAllManageQuotation(ManageQuotationList);
        System.out.println(output);

    }

    public static ManageQuotation inputManageQuotation() {
        int RID = Helper.readInt("Enter your Request ID > ");
        int QID = Helper.readInt("Enter your quotation ID > "); 
        String Category = Helper.readString("Enter your category(Room, Kitchen, Etc.) > ");
        String CategoryItem = Helper.readString("Enter the items for category > ");
        String DesignerName = Helper.readString("Enter the name of the designer > ");
        String Date = Helper.readString("Enter the start date > ");
        int amount = Helper.readInt("Enter the total quotation amount > ");

        ManageQuotation MQ = new ManageQuotation(RID, QID, Category, CategoryItem, DesignerName, Date, amount);
        return MQ;
    }


    public static void addManageQuotation(ArrayList<ManageQuotation> ManageQuotationList, ManageQuotation MQ) {
        ManageQuotationList.add(MQ);
    }

    
    public static boolean findManageQuotation(ArrayList<ManageQuotation> ManageQuotationList, int ID) {
        boolean found = false;
        for (int i=0 ; i<ManageQuotationList.size() ; i++) {
            if (ID == ManageQuotationList.get(i).getQuotationID()) {
                found = true;
            }
        }
        return found;
    }
    
	public static void doRemoveManageQuotation(ArrayList<ManageQuotation> ManageQuotationList, int ID) {
        for (int i=0 ; i<ManageQuotationList.size() ; i++) {
            if (ID == ManageQuotationList.get(i).getQuotationID()) {
            	ManageQuotationList.remove(i);
            }
        }
	}

    public static void removeManageQuotation(ArrayList<ManageQuotation> ManageQuotationList) {
        retrieveAllManageQuotation(ManageQuotationList);
        int ID = Helper.readInt("Enter your quotation ID > "); 

        boolean found = findManageQuotation(ManageQuotationList, ID);

        if (found == false) {
            System.out.println("invalid ID number");
        } else {
        	doRemoveManageQuotation(ManageQuotationList, ID);
            System.out.println("quotation ID: " + ID + " successfully deleted!");
        }
    }

    
    //================================= Manage Appointment (Arya) =================================

	public static RequestAppointment inputManageAppointments() {
    	String requestorName = Helper.readString("Enter requestor name > ");
    	int contactNumber = Helper.readInt("Enter contact number > ");
    	String email = Helper.readString("Enter email > ");
    	String appointmentDate = Helper.readString("Enter appointment Date > ");
    	String appointmentTime = Helper.readString("Enter Appointment time > ");
    	String designerName = Helper.readString("Enter designer name > ");
    	String premiseAddress = Helper.readString("Enter premise address > ");
    	
    	
    	RequestAppointment aa = new RequestAppointment(requestorName,contactNumber,email,appointmentDate,appointmentTime,appointmentDate,designerName,premiseAddress);
		return aa;
    }
	
    public static void addManagementAppointments(ArrayList<RequestAppointment> managementList, RequestAppointment aa) {
		managementList.add(aa);
	}

    public static String retrieveAllAppointments(ArrayList<RequestAppointment> AppointmentList) {
    	String output = "";
    	for(int i=0;i<AppointmentList.size();i++) {
    		output += String.format("%-14s %-20s %-20s %-20s %-17s %-15s %-20s\n", 
    				AppointmentList.get(i).getRequestorName(),AppointmentList.get(i).getContactNumber(),
    				AppointmentList.get(i).getEmail(),AppointmentList.get(i).getAppointmentDate()
    				,AppointmentList.get(i).getAppointmentTime(),AppointmentList.get(i).getDesignerName(),AppointmentList.get(i).getPremiseAddress());
    	}
    	return output;
    }
    
    public static void viewAllAppointments(ArrayList<RequestAppointment> AppointmentList) {
    	C206_CaseStudy.setHeader("APPOINTMENT LIST");
    	String output = String.format("%-10s %-20s %-20s %-20s %-10s %-16s %-10s \n","REQUESTOR NAME","CONTACT NUMBER",
    			"E-mail","APPOINTMENT DATE","APPOINTMENT NAME","DESIGNER NAME","PREMISE ADDRESS");
    	output += retrieveAllAppointments(AppointmentList);
    	System.out.println(output);
    }

    public static  void deleteAppointments(ArrayList<RequestAppointment> appointmentList, String x) {
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (x.matches(appointmentList.get(i).getRequestorName() )) {
				appointmentList.remove(i);
			}
		}	
	}
    
	public static String inputDeleteAppointments() {	
		String x = Helper.readString("Please enter requestor name > ");
			return x;
	}
			
		

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//end of class

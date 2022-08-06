import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest { 
	private Package p1;
	private Package p2;
	private static ArrayList<Package> packageList;
	 
	private RequestQuotation qq1;
	private RequestQuotation qq2;
	private static ArrayList<RequestQuotation> requestQuotationList;

	private ManageQuotation Q;
	private static ArrayList<ManageQuotation> manageList;

	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		p1 = new Package(001, "Package1", "2020-09-04", "2021-01-15", 5000.20);
		p2 = new Package(002, "Package2", "2021-04-16", "2021-10-23", 6540.90);
		packageList= new ArrayList<Package>();
		
		qq1 = new RequestQuotation("HDB", 170.00, "Lee Jackson", 87500650, "kokpop1090@gmail.com", 50000.00, "10-8-2022", "kitches", 1, 0, null, null);
		qq2 = new RequestQuotation("HDB", 170.00, "KOKPOP", 98716488, "cbbawe1090@gmail.com", 100000.00, "20-8-2022", "toilet", 0, 1, null, null);
		requestQuotationList = new ArrayList<RequestQuotation>();
		
		Q = new ManageQuotation(1234, 8765, "Kitchen", "tiles", "Heisenburg", "9-8-2022", 500000);
		manageList = new ArrayList<ManageQuotation>();
	}

	
	
	
    //================================= Manage Quotation (Jane) =================================

	@Test
	public void testRetrieveAllPackage() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//test if the list of packages retrieved from the Main is empty - boundary
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package array list size is 2", 2, packageList.size());
		
		//Test if the expected output string same as the list of packages retrieved from the SourceCentre	
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10d %-20s %-15s %-15s %-10.1f\n", 001, "Package1", "2020-09-04", "2021-01-15", 5000.20);
		testOutput += String.format("%-10d %-20s %-15s %-15s %-10.1f\n", 002, "Package2", "2021-04-16", "2021-10-23", 6540.90);
	
		assertEquals("Test that ViewAllPackagelist", testOutput, allPackage);
	}

	@Test
	public void testAddPackage() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that Package is added", p1, packageList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Check that Package arraylist size is 2", 2, packageList.size());
		assertSame("Check that Package is added", p2, packageList.get(1));
	}
		
	@Test
	public void testRemovePackage() {
		// Test if Item list is not null but empty boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//Add 2 items in list
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);

		//Test if the item is exist in array list
		boolean test = C206_CaseStudy.findPackageCode(packageList, p1.getCode());
		assertTrue("Check package exists in Package List", test);
		
		//Test that array list size is 1 after removed 1st item
		C206_CaseStudy.doRemovePackage(packageList, p1.getCode());
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());		
	}


	
	
    //================================= Manage Quotation (Jackson) =================================

	@Test
	public void testAddRequestQuotation() {
		
		// write your code here 
        assertNotNull("Test if there is valid Request For Quotation arraylist to add to", requestQuotationList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
        C206_CaseStudy.addRequestQuotation(requestQuotationList, qq1);		
		assertEquals("Test if that Request For Quotation arraylist size is 1?", 1, requestQuotationList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Request For Quotation is added same as 1st item of the list?", qq1, requestQuotationList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addRequestQuotation(requestQuotationList, qq2);
		assertEquals("Test that Request For Quotation arraylist size is 2?", 2, requestQuotationList.size());
		assertSame("Test that Request For Quotation is added same as 2nd item of the list?", qq2, requestQuotationList.get(1));
	}

	@Test
    public void testRetrieveAllRequestQuotation() {
        // Test if Item list is not null but empty -boundary
        assertNotNull("Test if there is valid Request For Quotation arraylist to retrieve item", requestQuotationList);

        //test if the list of Request For Quotations retrieved from the SourceCentre is empty - boundary
        String allRequestQuotation= C206_CaseStudy.retrieveAllRequestQuotation(requestQuotationList);
        String testOutput = "";
        assertEquals("Check that ViewAllRequestQuotationlist", testOutput, allRequestQuotation);

        //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
        C206_CaseStudy.addRequestQuotation(requestQuotationList, qq1);
        C206_CaseStudy.addRequestQuotation(requestQuotationList, qq2);
        assertEquals("Test that Request For Quotation arraylist size is 2", 2, requestQuotationList.size());

        //test if the expected output string same as the list of request quotation retrieved from the SourceCentre  
        allRequestQuotation= C206_CaseStudy.retrieveAllRequestQuotation(requestQuotationList);
        testOutput = String.format("%-15s %-10.1f %-20s %-20d %-25s %-10.1f %-25s %-20s %-20d %-20d %-20s %-20s\n","HDB", 170.00, "Lee Jackson", 87500650, "kokpop1090@gmail.com", 50000.00, "10-8-2022", "kitches", 1, 0, null, null);
        testOutput += String.format("%-15s %-10.1f %-20s %-20d %-25s %-10.1f %-25s %-20s %-20d %-20d %-20s %-20s\n","HDB", 170.00, "KOKPOP", 98716488, "cbbawe1090@gmail.com", 100000.00, "20-8-2022", "toilet", 0, 1, null, null);

        assertEquals("Test that ViewAllRequestQuotationlist", testOutput, allRequestQuotation);
    }
	
	@Test
	public void testRemoveRequestQuotation() {
		// Test if Item list is not null but empty boundary
		assertNotNull("Test if there is valid Request For Quotation arraylist to retrieve item", requestQuotationList);
		
		//Add 2 items in list
        C206_CaseStudy.addRequestQuotation(requestQuotationList, qq1);
        C206_CaseStudy.addRequestQuotation(requestQuotationList, qq2);

		//Test if the item is exist in array list
		String nameToRemove = qq1.getRequestorName();
		boolean test = C206_CaseStudy.findRequestorName(requestQuotationList, nameToRemove);
		assertTrue("Check package exists in Request For Quotation array list", test);
		
		//Test that array list size is 1 after removed 1st item
		C206_CaseStudy.doRemoveRequestQuotation(requestQuotationList, nameToRemove);
		assertEquals("Check that Request For Quotation arraylist size is 1", 1, requestQuotationList.size());	
		
	}

	
    //================================= Manage Quotation (Shamir) =================================

	
	@Test
	public void testRetrieveAllManageQuotations() {
		// Test if list is not null but empty - boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", manageList);
		
		//test if the list of quotations retrieved from the SourceCentre is empty - boundary
		String allQuotation = C206_CaseStudy.retrieveAllManageQuotation(manageList);
		String output = "";
		assertEquals("Check that manageList", output, allQuotation);
		
		//Given an empty list, after adding 2 items, test if the size of the is 1 -
		// normal
		C206_CaseStudy.addManageQuotation(manageList, Q);
		assertEquals("check that quotation arraylist is size 1", 1, manageList.size());
		
		//Test if the expected output string same as the list of timetable retrieved
		allQuotation = C206_CaseStudy.retrieveAllManageQuotation(manageList);
		output = String.format("%-15d%-15d%-13s%-20s%-15s%-15s%-10d\n", Q.getRequestID(), Q.getQuotationID(), Q.getCategory(), Q.getCategoryItems(), Q.getDesignerName(), Q.getStartDate(), Q.getTotalAmount());
		assertEquals("Test that viewAllQuotations", output, allQuotation);
	}
	
	@Test 
	public void testAddManageQuotation() {
		//manageList is not null, so that can add new item - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", manageList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is the same as the first item of the list 
		C206_CaseStudy.addManageQuotation(manageList, Q);
		assertEquals("Check that the Quotation arraylist size is 1", 1, manageList.size());
		assertSame("Check that Quotation is added", Q, manageList.get(0));
	}
	
	public void testRemoveManageQuotation() {
		//Boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", manageList);
		C206_CaseStudy.addManageQuotation(manageList, Q);
		
		//Normal
		boolean found = C206_CaseStudy.findManageQuotation(manageList, Q.getRequestID());
		found = C206_CaseStudy.findManageQuotation(manageList, Q.getQuotationID());
		assertTrue("Check if its found", found);

		//Normal
		C206_CaseStudy.doRemoveManageQuotation(manageList,  Q.getRequestID());
		assertEquals("Check that Manage Quotation arraylist size is 0", 0, manageList.size());	
				
		//Error
		found = C206_CaseStudy.findManageQuotation(manageList, Q.getRequestID());
		assertFalse("Check if a non-existent user is found", found);
	}

	
	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		packageList = null;
		
		qq1 = null;
		qq2 = null ;
		requestQuotationList = null ;
		
		Q = null;
		manageList = null;
	}


}

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Package p1;
	private Package p2;
	private ArrayList<Package> packageList;
	 
	private RequestQuotation qq1;
	private RequestQuotation qq2;
	private ArrayList<RequestQuotation> requestQuotationList;
	
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
	public void testRetrieveAllPackage() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//test if the list of packages retrieved from the SourceCentre is empty - boundary
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
		
		//test if the expected output string same as the list of packages retrieved from the SourceCentre	
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10d %-30s %-15s %-15s %-10.2f\n", 001, "Package1", "2020-09-04", "2021-01-15", 5000.20);
		testOutput += String.format("%-10d %-30s %-15s %-15s %-10.2f\n", 002, "Package2", "2021-04-16", "2021-10-23", 6540.90);
	
		assertEquals("Test that ViewAllPackagelist", testOutput, allPackage);
	}
	
	@Test
	public void testRemovePackage() {
		// Test that the Package list is not empty
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//Add in 2 item in array list
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Check that Package arraylist size is 2", 2, packageList.size());

		//Test that array list size is 1 after removed 1 item
		C206_CaseStudy.removePackage(packageList, p1.getCode());
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());	
	}


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
    public void testRetrieveAllQuotation() {
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
        testOutput = String.format("%-10s %-10.2f %-10s %-10d %-20s %-10.2f %-10s %-10s %-10d %-10d %-10s %-10s\n","HDB", 170.00, "Lee Jackson", 87500650, "kokpop1090@gmail.com", 50000.00, "10-8-2022", "kitches", 1, 0, null, null);
        testOutput += String.format("%-10s %-10.2f %-10s %-10d %-20s %-10.2f %-10s %-10s %-10d %-10d %-10s %-10s\n","HDB", 170.00, "KOKPOP", 98716488, "cbbawe1090@gmail.com", 100000.00, "20-8-2022", "toilet", 0, 1, null, null);

        assertEquals("Test that ViewAllRequestQuotationlist", testOutput, allRequestQuotation);
    }
	
	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		packageList = null;
		
		qq1 = null;
		qq2 = null ;
		requestQuotationList = null ;
	}


}

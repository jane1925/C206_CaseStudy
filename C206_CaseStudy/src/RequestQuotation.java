import java.time.LocalDate;
import java.util.Date;

public class RequestQuotation {
	private String propertyType; 
	private double areaSize;
	private String requestorName;
	private int contactNumber;
	private String email;
	private double budget;
	private String completionDate;
	private String renovationType;
	private int numOfRoom ;
	private int numOfToilet;
	private String renovationStyle;
	private String urgentReq;
	

	public RequestQuotation(String propertyType, double areaSize, String requestorName, int contactNumber, String email,
			double budget, String completionDate, String renovationType, int numOfRoom, int numOfToilet,
			String renovationStyle, String urgentReq) {
		
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestorName = requestorName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.budget = budget;
		this.completionDate = completionDate;
		this.renovationType = renovationType;
		this.numOfRoom = numOfRoom;
		this.numOfToilet = numOfToilet;
		this.renovationStyle = renovationStyle;
		this.urgentReq = urgentReq;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRenovationType() {
		return renovationType;
	}

	public void setRenovationType(String renovationType) {
		this.renovationType = renovationType;
	}

	public String getRenovationStyle() {
		return renovationStyle;
	}

	public void setRenovationStyle(String renovationStyle) {
		this.renovationStyle = renovationStyle;
	}

	public String getUrgentReq() {
		return urgentReq;
	}

	public void setUrgentReq(String urgentReq) {
		this.urgentReq = urgentReq;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public double getBudget() {
		return budget;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public int getNumOfRoom() {
		return numOfRoom;
	}

	public int getNumOfToilet() {
		return numOfToilet;
	}
	
	
	
	
	

}


public class Package {

	private int code;
	private String description;
	private String startDate;
	private String endDate; 
	private double amount;
	  
	
	public Package(int code, String description, String startDate, String endDate, double amount) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}


	public int getCode() {
		return code;
	}


	public String getDescription() {
		return description;
	}


	public String getStartDate() {
		return startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public double getAmount() {
		return amount;
	}
	
	public String toString(){
		String output = String.format("%-10d %-20s %-15s %-15s %-10.1f\n", 
				code,
				description,
				startDate,
				endDate,
				amount);
		return output;
	}
			
}//end of class

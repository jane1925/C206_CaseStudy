
public class ManageQuotation {
	
	private int RequestID;
	private int QuotationID;
	private String category;
	private String categoryItems;
	private String DesignerName;
	private String startDate;
	private int TotalAmount;

	public ManageQuotation(int RequestID, int QuotationID, String category, String categoryItems, String DesignerName, String startDate, int TotalAmount) {

		
		this.RequestID = RequestID;
		this.QuotationID = QuotationID;
		this.category = category;
		this.categoryItems = categoryItems;
		this.DesignerName = DesignerName;
		this.startDate = startDate;
		this.TotalAmount = TotalAmount;
		
		// TODO Auto-generated constructor stub
	}

	public int getRequestID() {
		return RequestID;
	}

	public int getQuotationID() {
		return QuotationID;
	}

	public String getCategory() {
		return category;
	}

	public String getCategoryItems() {
		return categoryItems;
	}

	public String getDesignerName() {
		return DesignerName;
	}

	public String getStartDate() {
		return startDate;
	}

	public int getTotalAmount() {
		return TotalAmount;
	}
	
	public String toString(){
		String output = String.format("%-15d%-15d%-13s%-20s%-15s%-15s%-10d\n", 
				RequestID,
				QuotationID,
				category,
				categoryItems,
				DesignerName,
				startDate,
				TotalAmount);
		return output;
	}

}
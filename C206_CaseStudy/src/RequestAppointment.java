
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class RequestAppointment {
    private String requestorName;
    private int contactNumber;
    private String email;
    private String appointmentDate;
    private String appointmentTime;
    private String designerName;
    private String premiseAddress;


    public RequestAppointment(String requestorName,int contactNumber,String email,String appointmentDate,String appointmentTime,String designerName,String premiseAddress,String urgentReq) {
        this.requestorName=requestorName;
        this.contactNumber=contactNumber;
        this.email=email;
        this.appointmentDate=appointmentDate;
        this.appointmentTime=appointmentTime;
        this.designerName=designerName;
        this.premiseAddress=premiseAddress;

    }

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(String requestorName) {
        this.requestorName = requestorName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getPremiseAddress() {
        return premiseAddress;
    }

    public void setPremiseAddress(String premiseAddress) {
        this.premiseAddress = premiseAddress;
    }

} 

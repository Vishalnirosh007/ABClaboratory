package abc.laboratory.webapp.Model;

public class Doctor {
	
	private int doctorID;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorSpecialization;
    private String doctorEmail;
    
    // Constructors
    public Doctor(int doctorID, String doctorFirstName, String doctorLastName, String doctorSpecialization, String doctorEmail) {
        this.doctorID = doctorID;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorEmail = doctorEmail;
    }
    
    public Doctor(String doctorFirstName, String doctorLastName, String doctorSpecialization, String doctorEmail) {
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorEmail = doctorEmail;
    }

    public Doctor() {
        // Default constructor
    }

    // Getter and Setter methods
    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
}

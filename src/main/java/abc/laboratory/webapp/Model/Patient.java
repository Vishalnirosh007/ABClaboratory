package abc.laboratory.webapp.Model;

import java.sql.Date;

public class Patient {
	
	private int patientID;
    private String patientFullName;
    private int patientPhoneNumber;
    private Date dateOfBirth;
    private String patientAddress;
    private String gender;
    private String patientEmail;
    private String patientUsername;
    private String patientPassword;
    
    public Patient() {
        
    }

    public Patient(String patientFullName, int patientPhoneNumber, Date dateOfBirth, String patientAddress, String gender, String patientEmail, String patientUsername, String patientPassword) {
        this.patientFullName = patientFullName;
        this.patientPhoneNumber = patientPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.gender = gender;
        this.patientEmail = patientEmail;
        this.patientUsername = patientUsername;
        this.patientPassword = patientPassword;
    }
    

    public Patient(int patientID, String patientFullName, int patientPhoneNumber, Date dateOfBirth,
			String patientAddress, String gender, String patientEmail, String patientUsername, String patientPassword) {
		super();
		this.patientID = patientID;
		this.patientFullName = patientFullName;
		this.patientPhoneNumber = patientPhoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.patientAddress = patientAddress;
		this.gender = gender;
		this.patientEmail = patientEmail;
		this.patientUsername = patientUsername;
		this.patientPassword = patientPassword;
	}

	public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public int getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(int patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

}

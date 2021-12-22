package models;

public class PersonModel {
	
	private int id;
	private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String dateBirth;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;
    
    
    public PersonModel() {
    	
    }
    
    public PersonModel(String firstName, String lastName, String documentType, String documentNumber,
			int dayBirth, int monthBirth, int yearBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.dayBirth = dayBirth;
		this.monthBirth = monthBirth;
		this.yearBirth = yearBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDayBirth() {
		return dayBirth;
	}

	public void setDayBirth(int dayBirth) {
		this.dayBirth = dayBirth;
	}

	public int getMonthBirth() {
		return monthBirth;
	}

	public void setMonthBirth(int monthBirth) {
		this.monthBirth = monthBirth;
	}

	public int getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(int yearBirth) {
		this.yearBirth = yearBirth;
		setDateBirth();
	}
    
    public String getDocumnetType() {
		return documentType;
	}
	public void setDocumnetType(String documnetType) {
		String typeString = "";
		typeString += documnetType.charAt(0);
		typeString += documnetType.charAt(1);
		this.documentType = typeString;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth() {
		dateBirth = yearBirth + "/" + monthBirth + "/" + dayBirth;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    @Override
    public String toString(){
        return  firstName + " - " + lastName + " - " + documentNumber;    		
    }
}

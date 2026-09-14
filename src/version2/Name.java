package version2;

public class EmployeeNames {
    private String firstName;
    private char MiddleIn;
    private String lastname;



    public EmployeeNames() {
        this.firstName = "N/A";
        MiddleIn = 'N';
        this.lastname = "N/A";
    }

    public EmployeeNames(String firstName, char middleIn, String lastname) {
        this.firstName = firstName;
        MiddleIn = middleIn;
        this.lastname = lastname;
    }

    public EmployeeNames(String firstName, String lastname) {
        this.firstName = firstName;
        MiddleIn = 'N';
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleIn() {
        return MiddleIn;
    }

    public void setMiddleIn(char middleIn) {
        MiddleIn = middleIn;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}

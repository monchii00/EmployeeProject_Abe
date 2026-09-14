package version2;

public class Name {
    private String firstName;
    private char MiddleIn;
    private String lastname;



    public Name() {
        this.firstName = "N/A";
        MiddleIn = '\0';
        this.lastname = "N/A";
    }

    public Name(String firstName, char middleIn, String lastname) {
        this.firstName = firstName;
        MiddleIn = middleIn;
        this.lastname = lastname;
    }

    public Name(String firstName, String lastname) {
        this.firstName = firstName;
        MiddleIn = '\0';
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

package version3;

public class Name {
    private String firstName;
    private String middleName;
    private String lastname;
    private String suffix;

    public Name() {
    }

    public Name(String firstName, String middleName, String lastname, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastname;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(middleName, other.middleName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(suffix, other.suffix);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

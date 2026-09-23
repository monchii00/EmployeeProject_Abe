package version4;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String displayName() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }
        if (firstName != null && !firstName.isEmpty()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(firstName);
        }
        if (middleName != null && !middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }
        if (suffix != null && !suffix.isEmpty()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return displayName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;

        Name other = (Name) obj;

        return equalsIgnoreCase(this.firstName, other.firstName)
                && equalsIgnoreCase(this.middleName, other.middleName)
                && equalsIgnoreCase(this.lastName, other.lastName)
                && equalsIgnoreCase(this.suffix, other.suffix);
    }

    private boolean equalsIgnoreCase(String s1, String s2) {
        if (s1 == s2) return true;
        if (s1 == null || s2 == null) return false;
        return s1.equalsIgnoreCase(s2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName != null ? firstName.toLowerCase() : null,
                middleName != null ? middleName.toLowerCase() : null,
                lastName != null ? lastName.toLowerCase() : null,
                suffix != null ? suffix.toLowerCase() : null
        );
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); 
        }
    }
}
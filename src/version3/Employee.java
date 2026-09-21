package version3;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID; 
    private Name empName; 
    private MyDate birthDate; 
    private MyDate dateHired;

    public Employee() {
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    } 

    public double computeSalary(int currentMonth) { 
        double bonus = 0.0; 
        if (birthDate != null && birthDate.getMonth() == currentMonth) { 
            bonus = 5000.00; 
        } 
        return bonus; 
    }
    
    public double computeSalary() {
        return computeSalary(-1);
    }
    
    public void displayEmployee() {
        System.out.println("ID: " + empID + " | Name: " + empName + " | DOB: " + birthDate + " | Hired: " + dateHired); 
    }

    @Override
    public String toString() {
        return "Employee [empID=" + empID + ", empName=" + empName + ", birthDate=" + birthDate + ", dateHired=" + dateHired + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return empID == other.empID;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(empID);
    }
    
    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            if (this.empName != null) cloned.empName = this.empName.clone();
            if (this.birthDate != null) cloned.birthDate = this.birthDate.clone();
            if (this.dateHired != null) cloned.dateHired = this.dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
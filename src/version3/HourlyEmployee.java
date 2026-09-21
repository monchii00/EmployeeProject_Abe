package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour; 

    public HourlyEmployee() {
        super(); 
        this.totalHoursWorked = 0;
        this.ratePerHour = 0; 
    }
    
    public HourlyEmployee(float totalHoursWorked, double ratePerHour) {
        super(); 
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            System.err.println("Invalid hours worked: Value must be 0 or greater.");
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            System.err.println("Invalid rate per hour: Value must be 0 or greater.");
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay;
        if (totalHoursWorked <= 40) {
            basePay = totalHoursWorked * ratePerHour;
        } else {
            double regularHours = 40.0;
            double overtimeHours = totalHoursWorked - 40.0;
            basePay = (regularHours * ratePerHour) + (overtimeHours * ratePerHour * 1.5);
        }
        return basePay + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        displayEmployee();
        System.out.println("Hours Worked: " + totalHoursWorked + " | Rate/Hr: " + ratePerHour + " | Total Salary: " + computeSalary());
    }

    @Override
    public String toString() {
        return super.toString() + ", HourlyEmployee [totalHoursWorked=" + totalHoursWorked + ", ratePerHour=" + ratePerHour + ", totalSalary=" + computeSalary() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HourlyEmployee)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(this.totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(this.ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
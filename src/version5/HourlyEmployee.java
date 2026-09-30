package version5;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public HourlyEmployee(float totalHoursWorked, double ratePerHour) {
        super();
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
            System.err.println("Invalid hours worked.");
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            System.err.println("Invalid rate per hour.");
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        float regularHours = Math.min(totalHoursWorked, 40);
        float overtimeHours = Math.max(0, totalHoursWorked - 40);
        double basePay = (regularHours * ratePerHour) + (overtimeHours * ratePerHour * 1.5);
        double birthdayBonus = (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) ? 5000.00 : 0.0;
        return basePay + birthdayBonus;
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

    @Override
    public String toString() {
        return super.toString() + ", HourlyEmployee [totalHoursWorked=" + totalHoursWorked + ", ratePerHour=" + ratePerHour + "]";
    }
}
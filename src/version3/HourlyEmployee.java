package version3;

import version2.MyDate;
import version2.Name;

import java.time.LocalDate;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate birthday;
    private MyDate datehired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
        this.birthday = new MyDate();
        this.datehired = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthday, MyDate datehired) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
        this.birthday = birthday;
        this.datehired = datehired;
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour, MyDate birthday, MyDate datehired) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.birthday = birthday;
        this.datehired = datehired;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public MyDate getDatehired() {
        return datehired;
    }

    public void setDatehired(MyDate datehired) {
        this.datehired = datehired;
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        } else {
            return (40 * ratePerHour) + ((totalHoursWorked - 40) * (ratePerHour * 1.5));
        }
    }

    public double salaryBirthdaybonus(){
        //add 5000 if it matches the date today to employee birthday
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentDay = today.getDayOfMonth();

        int birthMonth = this.birthday.getMonth();
        int birthDay = this.birthday.getDate();

        double finalSalary = computeSalary();

        if (birthMonth == currentMonth && birthDay == currentDay) {
            finalSalary += 5000;
        }

        return finalSalary;
    }

    public void displayHourlyEmployee() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format(
            "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
            empID, empName, totalHoursWorked, ratePerHour, computeSalary()
        );
    }
}
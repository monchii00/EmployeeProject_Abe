package version3;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(double totalSale) {
        super();
        setTotalSale(totalSale);
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            System.err.println("Invalid sale amount: Must be 0 or greater.");
        }
    }

    public double getCommissionRate() {
        if (totalSale < 50000.0) {
            return 0.05;
        } else if (totalSale < 100000.0) {
            return 0.10;
        } else if (totalSale < 500000.0) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double commissionPay = totalSale * getCommissionRate();
        return commissionPay + super.computeSalary(currentMonth); 
    }

    public void displayCommissionEmployee() {
        displayEmployee();
        System.out.println("Total Sales: " + totalSale);
        System.out.println("Commission Rate: " + (getCommissionRate() * 100) + "%");
        System.out.println("Computed Salary: " + computeSalary());
    }

    @Override
    public String toString() {
        return super.toString() + ", CommissionEmployee [totalSale=" + totalSale 
                + ", commissionRate=" + getCommissionRate() 
                + ", computedSalary=" + computeSalary() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(this.totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}
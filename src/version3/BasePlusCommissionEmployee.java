package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(double baseSalary) {
        super();
        setBaseSalary(baseSalary);
    }

    public BasePlusCommissionEmployee(double totalSale, double baseSalary) {
        super(totalSale);
        setBaseSalary(baseSalary);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, 
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.err.println("Invalid base salary: Value must be 0 or greater.");
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Sales: " + getTotalSale());
        System.out.println("Commission Rate: " + (getCommissionRate() * 100) + "%");
        System.out.println("Total Compensation: " + computeSalary());
    }

    @Override
    public String toString() {
        return super.toString() + ", BasePlusCommissionEmployee [baseSalary=" + baseSalary 
                + ", totalSale=" + getTotalSale() 
                + ", totalCompensation=" + computeSalary() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(this.baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
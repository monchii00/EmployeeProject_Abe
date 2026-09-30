package version5;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public CommissionEmployee(double totalSale) {
        super();
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            System.err.println("Invalid sale amount.");
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
        double birthdayBonus = (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) ? 5000.00 : 0.0;
        return commissionPay + birthdayBonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CommissionEmployee)) return false;
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

    @Override
    public String toString() {
        return super.toString() + ", CommissionEmployee [totalSale=" + totalSale + "]";
    }
}
package version3;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        double rate;

        if (totalSale < 50000) {
            rate = 0.05;
        } else if (totalSale < 100000) {
            rate = 0.10;
        } else if (totalSale < 500000) {
            rate = 0.15;
        } else {
            rate = 0.20;
        }

        return baseSalary + (totalSale * rate);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format(
            "BasePlusCommissionEmployee [ID: %d, Name: %s, Base: ₱%,.2f, Sales: ₱%,.2f, Total Salary: ₱%,.2f]",
            empID, empName, baseSalary, totalSale, computeSalary()
        );
    }
}
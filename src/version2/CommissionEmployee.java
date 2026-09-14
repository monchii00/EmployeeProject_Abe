package version1;

public class CommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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

        return totalSale * rate;
    }

    public void displayCommissionEmployee() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format(
            "CommissionEmployee [ID: %d, Name: %s, Sales: ₱%,.2f, Total Salary: ₱%,.2f]",
            empID, empName, totalSale, computeSalary()
        );
    }
}
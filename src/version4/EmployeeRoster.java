package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public Employee[] getEmpList() {
        return empList;
    }

    public void setEmpList(Employee[] empList) {
        this.empList = empList;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean addEmployee(Employee emp) {
        // Fixed: Check if null OR if the array is full (count >= max)
        if (emp == null || this.count >= this.max) {
            return false;
        } else {
            this.empList[count] = emp;
            this.count++;
            return true;
        }
    }

    public Employee removeEmployee(int empID) {
        int x = 0;
        for (; x < this.count && this.empList[x].getEmpID() != empID; x++) {
        }
        if (x < this.count && this.empList[x].getEmpID() == empID) {
            Employee removedEmp = this.empList[x];
            for (int i = x; i < this.count - 1; i++) {
                this.empList[i] = this.empList[i + 1];
            }
            this.empList[count - 1] = null;
            this.count--;
            return removedEmp;
        } else {
            return null;
        }
    }

    public Employee searchEmployee(int empID) {
        int x = 0;
        for (; x < this.count && this.empList[x].getEmpID() != empID; x++) {}
        if (x < this.count) {
            return this.empList[x];
        } else {
            return null;
        }
    }

    public int countHE(){
        int count = 0;
        for(int x = 0; x < this.count; x++){
             if(this.empList[x] instanceof HourlyEmployee){
                 count++;
             }
        }
        return count;
    }

    public int countPWE(){
        int count = 0;
        for(int x = 0; x < this.count; x++){
            if(this.empList[x] instanceof PieceWorkerEmployee){
                count++;
            }
        }
        return count;
    }

    public int countCE() {
        int count = 0;
        for (int x = 0; x < this.count; x++) {
            if (this.empList[x].getClass() == CommissionEmployee.class) {
                count++;
            }
        }
        return count;
    }

    public int countBPCE(){
        int count = 0;
        for(int x = 0; x < this.count; x++){
            if(this.empList[x] instanceof BasePlusCommissionEmployee){
                count++;
            }
        }
        return count;
    }

    public void displayHE() {
        for (int x = 0; x < this.count; x++) {
            if (this.empList[x] instanceof HourlyEmployee) {
                ((HourlyEmployee) this.empList[x]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int x = 0; x < this.count; x++) {
            if (this.empList[x] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) this.empList[x]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        System.out.println("ID\tName\t\tType");
        System.out.println("--------------------------------------");

        for (int x = 0; x < this.count; x++) {
            Employee emp = this.empList[x];
            String empType = emp.getClass().getSimpleName();

            System.out.println(emp.getEmpID() + "\t" + emp.getEmpName() + "\t\t" + empType);
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            boolean birthdayMatch = e.getBirthDate().getMonth() == currentMonth;
            String bonusNote = birthdayMatch ? " (Birthday Bonus Applied)" : "";

            if (e instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) e;
                System.out.printf("[Base Plus Commission] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), bpce.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) e;
                System.out.printf("[Commission] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), ce.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) e;
                System.out.printf("[Piece Worker] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), pwe.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                System.out.printf("[Hourly] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), he.computeSalary(currentMonth), bonusNote);
            }
        }
    }

}
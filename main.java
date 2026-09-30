package version5;

public class main {
    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        HourlyEmployee emp1 = new HourlyEmployee(
                101,
                new Name("Alice", "M.", "Smith", null),
                new MyDate(15, 9, 1995),
                new MyDate(1, 10, 2020),
                40.0f,
                237.50
        );

        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C.", "Jones", "Jr."),
                new MyDate(10, 5, 1990),
                new MyDate(12, 3, 2019),
                250,
                15.00
        );

        CommissionEmployee emp3 = new CommissionEmployee(
                301,
                new Name("Maria", "L.", "Reyes", null),
                new MyDate(22, 9, 1988),
                new MyDate(5, 6, 2018),
                100000.00
        );

        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(
                401,
                new Name("Kevin", "S.", "Tan", null),
                new MyDate(3, 11, 1992),
                new MyDate(15, 1, 2021),
                80000.00,
                24000.00
        );

        roster.addEmployee(emp1);
        System.out.println("Enrolled: " + emp1.getEmpName() + " (Hourly)");
        roster.addEmployee(emp2);
        System.out.println("Enrolled: " + emp2.getEmpName() + " (Piece Worker)");
        roster.addEmployee(emp3);
        System.out.println("Enrolled: " + emp3.getEmpName() + " (Commission)");
        roster.addEmployee(emp4);
        System.out.println("Enrolled: " + emp4.getEmpName() + " (Base Plus Commission)");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        int targetID = 201;
        System.out.print("Removing Employee ID " + targetID + "... ");
        Employee removed = roster.removeEmployee(targetID);
        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Not found.");
        }

        System.out.println("Updated Roster Size: " + roster.countEmployees());
        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
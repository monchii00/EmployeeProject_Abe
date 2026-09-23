package version4;

public class main {

    public static void main(String[] args) {


        EmployeeRoster roster = new EmployeeRoster(6);

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");


        HourlyEmployee hourlyEmp1 = new HourlyEmployee(
                101,
                new Name("Alice", "M.", "Smith", null),
                new MyDate(15, 9, 1995), // September birthday (triggers bonus)
                new MyDate(1, 10, 2020),
                38.0f,
                350.00
        );

        PieceWorkerEmployee pieceEmp1 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C.", "Jones", "Jr."),
                new MyDate(10, 5, 1990),
                new MyDate(12, 3, 2019),
                250,
                15.00
        );

        CommissionEmployee commEmp1 = new CommissionEmployee(
                301,
                new Name("Maria", "L.", "Reyes", null),
                new MyDate(22, 9, 1988), // September birthday (triggers bonus)
                new MyDate(5, 6, 2018),
                200000.00
        );

        BasePlusCommissionEmployee baseCommEmp1 = new BasePlusCommissionEmployee(
                401,
                new Name("Kevin", "S.", "Tan", null),
                new MyDate(3, 11, 1992),
                new MyDate(15, 1, 2021),
                80000.00,
                15000.00
        );

        HourlyEmployee hourlyEmp2 = new HourlyEmployee(
                102,
                new Name("David", "A.", "White", null),
                new MyDate(19, 12, 1994),
                new MyDate(20, 7, 2022),
                32.0f,
                250.00
        );

        HourlyEmployee extraEmp = new HourlyEmployee(
                999,
                new Name("Charlie", "Z.", "Brown", null),
                new MyDate(1, 1, 2000),
                new MyDate(1, 1, 2023),
                40.0f,
                100.00
        );


        System.out.println("Added: " + hourlyEmp1.getEmpName() + " (Hourly) -> " + (roster.addEmployee(hourlyEmp1) ? "Success" : "Failed"));
        System.out.println("Added: " + pieceEmp1.getEmpName() + " (Piece Worker) -> " + (roster.addEmployee(pieceEmp1) ? "Success" : "Failed"));
        System.out.println("Added: " + commEmp1.getEmpName() + " (Commission) -> " + (roster.addEmployee(commEmp1) ? "Success" : "Failed"));
        System.out.println("Added: " + baseCommEmp1.getEmpName() + " (Base Plus Commission) -> " + (roster.addEmployee(baseCommEmp1) ? "Success" : "Failed"));
        System.out.println("Added: " + hourlyEmp2.getEmpName() + " (Hourly) -> " + (roster.addEmployee(hourlyEmp2) ? "Success" : "Failed"));


        HourlyEmployee sixthEmp = new HourlyEmployee(
                103,
                new Name("Frank", "T.", "Miller", null),
                new MyDate(14, 2, 1991),
                new MyDate(10, 8, 2023),
                40.0f,
                200.00
        );
        roster.addEmployee(sixthEmp);


        boolean overflowAdd = roster.addEmployee(extraEmp);


        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());


        System.out.println("\n======================================================================");
        System.out.println("CATEGORICAL DISPLAY METHODS (Hourly Employees)");
        System.out.println("======================================================================");
        roster.displayHE();


        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);


        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        int targetID = 201;
        Employee removed = roster.removeEmployee(targetID);
        if (removed != null) {
            System.out.println("Removing Employee ID " + targetID + " (" + removed.getEmpName() + ")... Successfully removed.");
        } else {
            System.out.println("Employee ID " + targetID + " not found.");
        }

        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
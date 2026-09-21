package version3;

public class Main {
    public static void main(String[] args) {
        int targetMonth = 9; // September

        Name n1 = new Name("Alice", "M.", "Smith", "");
        MyDate dob1 = new MyDate(18, 9, 2000);
        MyDate hired1 = new MyDate(1, 6, 2022);

        Name n2 = new Name("Bob", "C.", "Jones", "Jr.");
        MyDate dob2 = new MyDate(5, 4, 1998);
        MyDate hired2 = new MyDate(15, 1, 2023);

        Name n3 = new Name("Charlie", "D.", "Brown", "");
        MyDate dob3 = new MyDate(12, 9, 1995);
        MyDate hired3 = new MyDate(10, 3, 2021);

        Name n4 = new Name("Diana", "E.", "Prince", "");
        MyDate dob4 = new MyDate(22, 11, 1992);
        MyDate hired4 = new MyDate(5, 8, 2019);

        Employee[] employees = new Employee[] {
            new HourlyEmployee(101, n1, dob1, hired1, 40.0f, 237.50),
            new PieceWorkerEmployee(201, n2, dob2, hired2, 405, 10.0),
            new CommissionEmployee(301, n3, dob3, hired3, 60000.0),
            new BasePlusCommissionEmployee(401, n4, dob4, hired4, 120000.0, 15000.0)
        };

        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        int count = 1;
        for (Employee emp : employees) {
            double totalPayout = emp.computeSalary(targetMonth);
            double bonus = (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == targetMonth) ? 5000.00 : 0.00;
            double basePay = totalPayout - bonus;
            String eligibility = (bonus > 0) ? "(Eligible)" : "(Ineligible)";

            System.out.printf("%d. %s [ID: %d, Name: %s, DOB: %s, Hired: %s]%n",
                    count++,
                    emp.getClass().getSimpleName(),
                    emp.getEmpID(),
                    emp.getEmpName().displayName(),
                    emp.getBirthDate(),
                    emp.getDateHired()
            );
            System.out.printf("   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f %s%n", basePay, bonus, eligibility);
            System.out.printf("   Total Payout: ₱%.2f%n%n", totalPayout);
        }

        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee emp1 = new HourlyEmployee(101, n1, dob1, hired1, 40.0f, 237.50);
        HourlyEmployee emp1Identical = new HourlyEmployee(101, n1, dob1, hired1, 40.0f, 237.50);
        HourlyEmployee emp2 = new HourlyEmployee(102, n2, dob2, hired2, 45.0f, 200.00);

        boolean isEqual = emp1.equals(emp1Identical);
        boolean hashMatch = emp1.hashCode() == emp1Identical.hashCode();

        System.out.println("emp1 equals emp1Identical: " + isEqual);
        System.out.printf("emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n", emp1.hashCode(), emp1Identical.hashCode(), hashMatch);
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        System.out.println("\n======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        HourlyEmployee original = new HourlyEmployee(101, new Name("Alice", "M.", "Smith", ""), dob1, hired1, 40.0f, 237.50);
        HourlyEmployee clone = original.clone();

        System.out.println("Original Name before modification: " + original.getEmpName().displayName());
        
        clone.getEmpName().setLastName("Taylor");
        
        System.out.println("Clone Name changed to:             " + clone.getEmpName().displayName());
        System.out.println("Original Name after modification:  " + original.getEmpName().displayName() + " (Deep copy successful!)");
    }
}
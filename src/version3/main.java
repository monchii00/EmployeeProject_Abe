package version3;

import version1.BasePlusCommissionEmployee;
import version1.CommissionEmployee;
import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;

public class main {

    public static void main(String[] args) {
        
        PieceWorkerEmployee pieceEmp1 = new PieceWorkerEmployee();
        pieceEmp1.setEmpID(101);
        pieceEmp1.setEmpName("Marie Clam");
        pieceEmp1.setTotalPiecesFinished(250);
        pieceEmp1.setRatePerPiece(15.00);

        PieceWorkerEmployee pieceEmp2 = new PieceWorkerEmployee(102, "Kaelix Yu", 420, 20.00);

        HourlyEmployee hourlyEmp1 = new HourlyEmployee();
        hourlyEmp1.setEmpID(201);
        hourlyEmp1.setEmpName("Pia Justin");
        hourlyEmp1.setTotalHoursWorked(38.0f);
        hourlyEmp1.setRatePerHour(180.00);

        HourlyEmployee hourlyEmp2 = new HourlyEmployee(202, "Gabbie Lea", 48.5f, 250.00);

        CommissionEmployee commEmp1 = new CommissionEmployee();
        commEmp1.setEmpID(301);
        commEmp1.setEmpName("Rae Monique");
        commEmp1.setTotalSale(45000.00);

        CommissionEmployee commEmp2 = new CommissionEmployee(302, "Enna Alouette", 120000.00);

        BasePlusCommissionEmployee baseCommEmp1 = new BasePlusCommissionEmployee();
        baseCommEmp1.setEmpID(401);
        baseCommEmp1.setEmpName("Luca King");
        baseCommEmp1.setTotalSale(80000.00);
        baseCommEmp1.setBaseSalary(15000.00);

        BasePlusCommissionEmployee baseCommEmp2 = new BasePlusCommissionEmployee(402, "Melchora Aquino", 550000.00, 25000.00);

        pieceEmp1.displayPieceWorkerEmployee();
        pieceEmp2.displayPieceWorkerEmployee();

        hourlyEmp1.displayHourlyEmployee();
        hourlyEmp2.displayHourlyEmployee();

        commEmp1.displayCommissionEmployee();
        commEmp2.displayCommissionEmployee();

        baseCommEmp1.displayBasePlusCommissionEmployee();
        baseCommEmp2.displayBasePlusCommissionEmployee();

        System.out.println(pieceEmp1);
        System.out.println(pieceEmp2);

        System.out.println(hourlyEmp1);
        System.out.println(hourlyEmp2);

        System.out.println(commEmp1);
        System.out.println(commEmp2);

        System.out.println(baseCommEmp1);
        System.out.println(baseCommEmp2);
    }
}
package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished; 
    private double ratePerPiece; 

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int totalPiecesFinished, double ratePerPiece) {
        super();
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, 
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        } else {
            System.err.println("Invalid pieces finished: Must be 0 or greater.");
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        } else {
            System.err.println("Invalid rate per piece: Must be 0 or greater.");
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double base = totalPiecesFinished * ratePerPiece;
        double bonus = Math.floor(totalPiecesFinished / 100.0) * (10 * ratePerPiece);
        
        return base + bonus + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee(); 
        System.out.println("Total Pieces Finished: " + totalPiecesFinished);
        System.out.println("Rate Per Piece: " + ratePerPiece);
        System.out.println("Total Salary: " + computeSalary());
    }

    @Override
    public String toString() {
        return super.toString() + ", PieceWorkerEmployee [totalPiecesFinished=" + totalPiecesFinished 
                + ", ratePerPiece=" + ratePerPiece 
                + ", computedSalary=" + computeSalary() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return this.totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(this.ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
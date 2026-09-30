package version5;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public PieceWorkerEmployee(int totalPiecesFinished, double ratePerPiece) {
        super();
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
            System.err.println("Invalid pieces finished.");
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        } else {
            System.err.println("Invalid rate per piece.");
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double pieceBonus = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        double birthdayBonus = (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) ? 5000.00 : 0.0;
        return basePay + pieceBonus + birthdayBonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
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

    @Override
    public String toString() {
        return super.toString() + ", PieceWorkerEmployee [totalPiecesFinished=" + totalPiecesFinished + ", ratePerPiece=" + ratePerPiece + "]";
    }
}
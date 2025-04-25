package Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Invoices")
@Data
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceID", nullable = false)
    private int invoiceID;

    @Column(name = "ReservationID", nullable = false)
    private int reservationID;

    @Column(name = "InvoiceDate", nullable = false)
    private LocalDate invoiceDate;

    @Column(name = "TotalAmount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "IsPaid", nullable = false)
    private boolean isPaid;

    public Invoices() {
    }

    public Invoices(int invoiceID, int reservationID, LocalDate invoiceDate, BigDecimal totalAmount, boolean isPaid) {
        this.invoiceID = invoiceID;
        this.reservationID = reservationID;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.isPaid = isPaid;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}

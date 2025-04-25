package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ReservationHistories")
public class ReservationHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyID;

    @Column(name = "GuestID", nullable = false)
    private int guestID;


    public ReservationHistories() {
    }

    public ReservationHistories(int guestID) {
        this.guestID = guestID;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }
}
package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "LoyaltyPrograms")
public class LoyaltyPrograms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programID;

    @Column(name = "GuestID", nullable = false)
    private int guestID;

    @Column(name = "LoyaltyPoints", nullable = false)
    private int loyaltyPoints;


    public LoyaltyPrograms() {
    }

    public LoyaltyPrograms(int guestID, int loyaltyPoints) {
        this.guestID = guestID;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            throw new IllegalArgumentException("LoyaltyPoints cannot be negative.");
        }
        this.loyaltyPoints = loyaltyPoints;
    }
}

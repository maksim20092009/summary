import java.util.Date;

public class Guest {
    private int guestId;
    private String name;
    private String contactInfo;
    private Date dateOfBirth;
    private boolean vipStatus;
    private int loyaltyPoints;

    public Guest(int guestId, String name, String contactInfo, Date dateOfBirth, boolean vipStatus) {
        this.guestId = guestId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
        this.vipStatus = vipStatus;
        this.loyaltyPoints = 0;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints >= 100 ? 0.10 : 0.00;
    }

    public void sendNotification(String message) {
        System.out.printf("Уведомление для " + name + ": " + message);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", vipStatus=" + vipStatus +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

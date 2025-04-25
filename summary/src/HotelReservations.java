import java.util.Date;

public class HotelReservations {
    private int reservationId;
    private int guestId;
    private int hotelId;
    private int roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private String bookingStatus;

    public HotelReservations( int reservationId, int guestId, int hotelId, int roomId,
                              Date checkInDate, Date checkOutDate, double totalPrice, String bookingStatus ) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    public void updateStatusBasedOnDate() {
        Date currentDate = new Date();
        if (currentDate.after(checkInDate)) {
            this.bookingStatus = "Completed";
        }
    }

    public void applyDiscount(double discount) {
        this.totalPrice = totalPrice - (totalPrice * discount);
    }

    @Override
    public String toString() {
        return "HotelReservations{" +
                "reservationId=" + reservationId +
                ", guestId='" + guestId +
                ", hotelId='" + hotelId +
                ", roomId='" + roomId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalPrice=" + totalPrice +
                ", bookingStatus='" + bookingStatus +
                '}';
    }
}

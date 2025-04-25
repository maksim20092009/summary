package Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "HotelReservations")
public class HotelReservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

    @Column(name = "GuestID", nullable = false)
    private int guestID;

    @Column(name = "HotelID", nullable = false)
    private int hotelID;

    @Column(name = "CheckInDate", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "CheckOutDate", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "RoomID", nullable = false)
    private int roomID;

    @Column(name = "TotalPrice", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "BookingStatus", length = 50)
    private String bookingStatus = "Pending";

    // Конструктор по умолчанию
    public HotelReservations() {
    }

    // Конструктор с параметрами
    public HotelReservations(int guestID, int hotelID, LocalDate checkInDate, LocalDate checkOutDate, int roomID, BigDecimal totalPrice, String bookingStatus) {
        this.guestID = guestID;
        this.hotelID = hotelID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomID = roomID;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    // Геттеры и сеттеры
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}

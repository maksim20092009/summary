package Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomID;

    @Column(name = "HotelID", nullable = false)
    private int hotelID;

    @Column(name = "RoomType", nullable = false, length = 50)
    private String roomType;

    @Column(name = "PricePerNight", precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "IsAvailable", nullable = false)
    private boolean isAvailable = true;

    // Конструктор по умолчанию
    public Rooms() {
    }

    // Конструктор с параметрами
    public Rooms(int hotelID, String roomType, BigDecimal pricePerNight, boolean isAvailable) {
        this.hotelID = hotelID;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    // Геттеры и сеттеры
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Hotels")
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelID;

    @Column(name = "HotelName", nullable = false, length = 150)
    private String hotelName;

    @Column(name = "Location", length = 200)
    private String location;

    @Column(name = "Stars")
    private int stars;

    // Конструктор по умолчанию
    public Hotels() {
    }

    // Конструктор с параметрами
    public Hotels(String hotelName, String location, int stars) {
        this.hotelName = hotelName;
        this.location = location;
        this.stars = stars;
    }

    // Геттеры и сеттеры
    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Stars must be between 1 and 5.");
        }
        this.stars = stars;
    }
}

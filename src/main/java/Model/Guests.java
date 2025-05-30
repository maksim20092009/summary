//отвечает за бизнес-логику приложения
package Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
//генерирует геттеры, сеттеры
@Data
@Table(name = "Guests")
public class Guests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestID;

    //настройка столбца в базе данных

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "ContactInfo", length = 150)
    private String contactInfo;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    // Конструктор по умолчанию
    public Guests() {
    }

    // Конструктор с параметрами
    public Guests(String name, String contactInfo, LocalDate dateOfBirth) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
    }

    // Геттеры и сеттеры
    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

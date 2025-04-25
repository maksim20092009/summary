import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int hotelId;
    private String name;
    private String location;
    private int stars;
    private List<Room> rooms;

    public Hotel(int hotelId, String name, String location, int stars) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int countAvailableRooms() {
        int count = 0;
        for (Room room : rooms) {
            if (room.checkAvailability()) {
                count++;
            }
        }
        return count;
    }

    public double checkRatingBasedOnStars() {
        return stars >= 5 ? 4.5 : stars >= 3 ? 3.5 : 2.5;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", stars=" + stars +
                ", availableRooms=" + countAvailableRooms() +
                '}';
    }
}

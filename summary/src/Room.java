public class Room {
    private int roomId;
    private int hotelId;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomId, int hotelId, String roomType, double pricePerNight, boolean isAvailable) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    public void updatePrice(double newPrice) {
        this.pricePerNight += newPrice;
    }

    public boolean reserveRoom() {
        if (isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", hotelId='" + hotelId +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

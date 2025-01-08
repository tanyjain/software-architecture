import java.util.HashMap;

public class ParcelMap {
    private HashMap<String, Parcel> parcels;

    public ParcelMap() {
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(String id) {
        return parcels.get(id);
    }

    public boolean containsParcel(String id) {
        return parcels.containsKey(id);
    }
}

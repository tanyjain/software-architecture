public class Parcel {
    private String id;
    private double weight;
    private double fee;

    public Parcel(String id, double weight) {
        this.id = id;
        this.weight = weight;
        calculateFee();
    }

    private void calculateFee() {
        this.fee = weight * 5; // Example calculation
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getFee() {
        return fee;
    }
}

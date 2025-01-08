public class Worker {
    public void processCustomer(Customer customer, ParcelMap parcelMap) {
        String parcelId = customer.getParcelId();
        if (parcelMap.containsParcel(parcelId)) {
            Parcel parcel = parcelMap.getParcel(parcelId);
            Log.getInstance().addEntry(
                String.format("Processed parcel %s for customer %s. Fee: $%.2f",
                    parcelId, customer.getName(), parcel.getFee())
            );
        }
    }
}

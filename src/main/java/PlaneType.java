public enum PlaneType {

    BOEING777 (5, 1000),
    BOEING747 (3, 700),
    AIRBUS (2, 160);

    private int capacity;
    private double totalWeight;

    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}

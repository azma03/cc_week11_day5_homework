public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }


    public int getCapacity() {
        return planeType.getCapacity(); //gets the value from ENUM
    }

    public double getTotalWeight() {
        return planeType.getTotalWeight();
    }
}

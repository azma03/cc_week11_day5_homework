import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private FlightNumbers flightNumber;
    private Airports destination;
    private Airports departureAirport;
    private Date departureTime;
    private ArrayList<Integer> availableSeats;

    public Flight(Plane plane, FlightNumbers flightNumber, Airports destination, Airports departureAirport, Date departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.availableSeats = new ArrayList<Integer>();

        for(int i= 1; i< this.plane.getCapacity()+1; i++){
            this.availableSeats.add(i);
        }

    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public FlightNumbers getFlightNumber() {
        return flightNumber;
    }

    public Airports getDestination() {
        return destination;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public int getPassengerCount() {
        return this.passengers.size();
    }

    public int getNumberOfAvailableSeats() {
        return this.plane.getCapacity() - getPassengerCount();
    }

    public boolean passengerCheckedIn(Passenger passenger){
        return this.passengers.contains(passenger);

    }

    public void addPassengers(Passenger passenger) {
        if(getNumberOfAvailableSeats() > 0 && !passengerCheckedIn(passenger)){
            this.passengers.add(passenger);
            passenger.setFlight(Flight.this);

            Integer seatNumber = getRadomAvailableSeat();  //get the random seat number from available seats
            passenger.setSeatNumber(seatNumber);  //assign seat number to passenger
            this.availableSeats.remove(seatNumber); //remove the seat from the available seats

        }
    }

    public Integer getRadomAvailableSeat(){
        Random random = new Random();
//        int randomIndex = random.nextInt(this.availableSeats.size());
        int low = 0;
        int high = this.availableSeats.size() - 1;

        if(low == high){  //last available seat
            return this.availableSeats.get(low);
        }else{
            int randomIndex = random.nextInt(high-low) + low;
            return this.availableSeats.get(randomIndex);
        }
    }
}

package activities;

public class MountainBike extends Bicycle{
    //The MountainBike subclass adds one more field
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int startHeight) {
        //Invoking base-class(Bicycle) constructor
        super(gears, currentSpeed);
        seatHeight = startHeight;
    }
        public void setHeight(int newValue) {
            seatHeight = newValue;
        }

        public String bicycleDesc() {
            return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
        }

}

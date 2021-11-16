public class Car extends Vehicle{
    public boolean isDriven;
    public String driversName;

    public Car(Double speed, Integer freeSeats, Location location){
        super(speed, freeSeats, location);
    }

    public Car(){
        super();
    }

    @Override
    public void moveTo(Location location) {
        System.out.println("Машина заводится путем беспорядочного нажатия на рычажки...");
        Time.pause(100d);
        System.out.println("Машина завелась");
        System.out.println("Машина перемещается в " + location + "...");
        Time.pause(100d);
        System.out.println("Машина переместилась в " + location);
    }

    @Override
    public void speedUp(Double speed) {
        this.speed += speed;
    }

    @Override
    public void slowDown(Double speed) {
        this.speed -= speed;
    }
}

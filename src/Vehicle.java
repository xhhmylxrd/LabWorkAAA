public abstract class Vehicle implements Moveable{
    protected Double speed;
    public Integer freeSeats;
    public Location location;

    Vehicle(){
        speed = 0d;
        freeSeats = 0;
        location = Location.UNDEFINED;
    }

    Vehicle(Double speed, Integer freeSeats, Location location){
        this.speed = speed;
        this.freeSeats = freeSeats;
        this.location = location;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+location.hashCode()+speed.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode() && this.getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return "Средство передвижения со скоростью " + speed + ", находится в " + location;
    }

}

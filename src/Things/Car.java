package Things;

import java.util.Random;

import Utility.*;

public class Car extends Vehicle implements AbleToJoinStory {
    private boolean isDriven;
    private String driversName;
    private boolean engineIsOn;

    public Car(Double speed, Integer freeSeats, Location location) {
        super(speed, freeSeats, location);
    }

    public Car() {
        super();
    }

    @Override
    public void moveTo(Location location) {
        double distance = 200d;
        while (!engineIsOn) {
            System.out.println("Машина заводится путем беспорядочного нажатия на рычажки...");
            setEngineIsOn(true);
        }
        System.out.println("Машина перемещается в " + location + "...");
        this.location = location;
        Time.pause(distance * 10 / speed);
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

    public boolean getIsDriven() {
        return isDriven;
    }

    public void setIsDriven(boolean value) {
        isDriven = value;
    }

    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String name) {
        driversName = name;
    }

    @Override
    public void joinStory() {
        System.out.println("Машина присоединяется к истории\n");
    }

    public boolean getEngineIsOn() {
        return engineIsOn;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }


    private void setEngineIsOn(boolean value) {
        if (value) {
            final Random random = new Random();
            if (random.nextInt() > Math.pow(2, 16)) {
                engineIsOn = true;
                System.out.println("Машина завелась");
            } else {
                System.out.println("К сожалению машину завести не получилось:(");
            }
        } else {
            engineIsOn = false;
            System.out.println("Машина заглушена");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + location.hashCode() + speed.hashCode();
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


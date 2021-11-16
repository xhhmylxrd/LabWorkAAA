public class Shorty extends Creature {
    public Car isInTheCar;

    public Shorty() {
        super();
    }

    public Shorty(String name, Integer age, Location location, Double speed) {
        super(name, age, location, speed);
    }


    @Override
    public void joinStory() {
        System.out.println(joinMassage()+"\n");
    }


    @Override
    protected String joinMassage() {
        return "Коротышка " + name + " присоединился к истории";
    }


    public void moveTo(Location location) {
        if (isInTheCar == null) {
            if (speed == 0) {
                System.out.println("Коротышка " + name + " не имеет возможности перемещаться\n");
            } else if (this.location == location) {
                System.out.println("Коротышка " + name + " и так находится в " + location + "\n");
            } else {
                this.location = location;
                changingLocationMassage(speed);
                System.out.println("Коротышка " + name + " переместился в " + location + "\n");
            }
        }
        else{
            isInTheCar.moveTo(location);
        }
    }


    @Override
    protected void changingLocationMassage(Double speed) {
        Double distance = 200d;
        System.out.println("Коротышка " + name + " перемещается...");
        Time.pause(distance / speed);
    }

    @Override
    public void speedUp(Double speed) {
        this.speed += speed;
    }

    @Override
    public void slowDown(Double speed) {
        this.speed -= speed;
    }

    @Override
    public void driveCar(Car car) {
        if (car.isDriven) {
            System.out.println("За рулем уже кто-то есть!");
        } else {
            isInTheCar = car;
            car.isDriven = true;
            car.freeSeats += 1;
            car.driversName = name;
            System.out.println(name + " теперь находится за рулем машины.");
        }
    }

    @Override
    public void rideCar(Car car) {
        if (car.freeSeats > 0) {
            car.freeSeats -= 1;
            isInTheCar = car;
            System.out.println(name + " теперь находится на пассажирском сидении");
        } else {
            System.out.println("Машина уже битком!");
        }
        System.out.println();
    }

    @Override
    public void leaveCar(Car car) {
        if (car.driversName.equals(name)) {
            car.driversName = "";
            car.freeSeats += 1;
            System.out.println(name + " вышел с водительского места");
            isInTheCar = null;
        } else if (isInTheCar.equals(car)){
            car.freeSeats += 1;
            isInTheCar = null;
            System.out.println(name + " вышел с пассажирского места");
        }
        else{
            System.out.println(name + " и так не в машине.");
        }
        System.out.println();
    }

    public void communicateWith(Shorty shorty, String massage){
        if (this.location == shorty.location){
            System.out.println(this.name + " обращается к " + shorty.name+":");
            System.out.println(massage+"\n");

        }
        else{
            System.out.println(name + " не может обратиться к " + shorty.name + ". Персонажи не рядом");
        }
    }

}
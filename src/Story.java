import java.util.Random;

public class Story {
    public static void main(String[] args) {
        Shorty shorty1 = new Shorty("Незнайка", 5, Location.HOUSE, 12d);
        Shorty shorty2 = new Shorty("Сиропчик", 6, Location.HOUSE, 10d);
        Shorty shorty3 = new Shorty("Торопыжка", 7, Location.UNDEFINED, 20d);
        Car car = new Car(80d, 5, Location.BACKYARD);

        shorty1.joinStory();
        shorty2.joinStory();
        shorty3.joinStory();

        shorty1.communicateWith(shorty3, "Прокати меня машине");

        shorty1.moveTo(Location.BACKYARD);
        shorty1.driveCar(car);
        shorty2.communicateWith(shorty1, "Ты куда?!!");
        shorty2.moveTo(Location.BACKYARD);
        shorty2.communicateWith(shorty1, "Ты куда?!!");

        for(int i = 0; i<10;i++){
            Shorty shorty = new Shorty("Неизвестный" + i, 6, Location.HOUSE, 15d);
            shorty.joinStory();
            shorty.moveTo(Location.BACKYARD);
        }

        shorty1.moveTo(Location.PUBLIC_ROAD);
    }
}

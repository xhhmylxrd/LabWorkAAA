public abstract class Creature implements Moveable, CarInterface{
    public String name;
    public Integer age;
    public Location location;
    protected Double speed;

    public Creature(){
        name = "Nameless";
        age = 0;
        location = Location.UNDEFINED;
        speed = 0d;
    }
    public Creature(String name, Integer age, Location location, Double speed){
        this.name = name;
        this.age = age;
        this.location = location;
        this.speed = speed;
    }
    public abstract void joinStory();
    protected abstract String joinMassage();
    protected abstract void changingLocationMassage(Double speed);

    @Override
    public int hashCode() {
        return super.hashCode()+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode() && this.getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return "Коротышка " + name + ", находящийся в " + location + ", " + age + " лет от роду, со скоростью = " + speed;
    }

}

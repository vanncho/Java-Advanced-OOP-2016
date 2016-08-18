package liveDemos;

public class Main {
    public static void main(String[] args) {

        Traveler traveler = new Traveler(new Opel());
        traveler.travel();
    }
}

interface Vehicle {
    void move();
}

class Opel implements Vehicle {

    @Override
    public void move() {
        System.out.println("move");
    }
}

class Traveler {

    private Vehicle vehicle;

    public Traveler(Vehicle car) {
        this.vehicle = car;
    }

    public void travel() {
        vehicle.move();
    }
}

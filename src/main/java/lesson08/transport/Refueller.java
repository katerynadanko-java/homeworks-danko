package lesson08.transport;

public class Refueller {
    private int id;

    public Refueller(int id) {
        this.id = id;
    }

    public void refuell(CarForRefueller car){
        if(!car.isFull()){
            car.setRefuell(true);
            System.out.println("You should refuell the car");
            return;
        }
        System.out.println("Car is full");
    }
}

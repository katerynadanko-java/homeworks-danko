package lesson08.transport;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(Category.C,
                new Battery(50000, 150, 30, 200),
                false, true, new Wheel(50, "A", 50));
        Car car2 = new Car(Category.C,
                new Battery(50000, 150, 30, 200),
                true, false, new Wheel(50, "B", 50));

        car.drive(new Driver("Kateryna", "Danko",
                new DriverLicence(Category.B1, "K345"), "soft"));
        car.drive(new Driver("Kateryna1", "Danko1",
                new DriverLicence(Category.C, "K342"), "soft"));

        car.changeBattery (new Battery(50000, 150, 30, 200));
        car.changeBattery(new Battery(51000, 150, 30, 200));

        System.out.println("\n");

        Refueller refueller = new Refueller(5);
        refueller.refuell(car);
        refueller.refuell(car2);

        System.out.println("\n");

        Wheel wheel1 = new Wheel(50, "A", 50);
        Wheel wheel2 = new Wheel(50, "B", 50);

        wheel1.changeWheel(car);
        wheel2.changeWheel(car);
        wheel2.changeWheel(car2);
}
}

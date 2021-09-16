package lesson08.transport;

public class Car implements CarForWheel, CarForRefueller {

    private Category category;
    private Battery battery;
    private boolean isFull;
    private boolean isWheelOld;
    private Wheel wheel;

    public Car(Category category, Battery battery,
               boolean isFull, boolean isWheelOld, Wheel wheel) {
        this.category = category;
        this.battery = battery;
        this.isFull = isFull;
        this.isWheelOld = isWheelOld;
        this.wheel = wheel;
    }

    @Override
    public boolean isFull() {
        return isFull;
    }

    @Override
    public void setRefuell(boolean isFull) {
        this.isFull = isFull;
    }

    @Override
    public boolean isWheelOld() {
        return isWheelOld;
    }

    @Override
    public Wheel wheel() {
        return wheel;
    }

    @Override
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    void drive(Driver driver) {
        if (this.category.equals(driver.getDriverLicence().getCategory())) {
            System.out.println(driver.getDriverName() + " You can drive this car!");
        }
        System.out.println(driver.getDriverName() + " You can not drive this car!");
    }

    void changeBattery(Battery battery) {
        if (this.battery.equals(battery)){
            System.out.println("Change battery!");
        }
        System.out.println("Battery does not fit");
    }
}

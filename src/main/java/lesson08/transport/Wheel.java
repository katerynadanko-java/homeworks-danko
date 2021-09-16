package lesson08.transport;

import java.util.Objects;

public class Wheel {
    private int width;
    private String profile;
    private int diskDiameter;

    public Wheel(int width, String profile, int diskDiameter) {
        this.width = width;
        this.profile = profile;
        this.diskDiameter = diskDiameter;
    }

    public void changeWheel(CarForWheel car){
        if(!car.isWheelOld() && (car.wheel().getWidth() == this.getWidth()) &&
                (car.wheel().getProfile().equals(this.getProfile())) &&
                (car.wheel().getDiskDiameter() == this.getDiskDiameter())){
            car.setWheel(this);
            System.out.println("You should change the wheels!");
        }
        else {
            System.out.println("You shouldn`t change the wheels!");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getDiskDiameter() {
        return diskDiameter;
    }

    public void setDiskDiameter(int diskDiameter) {
        this.diskDiameter = diskDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return width == wheel.width &&
                diskDiameter == wheel.diskDiameter &&
                Objects.equals(profile, wheel.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, profile, diskDiameter);
    }
}

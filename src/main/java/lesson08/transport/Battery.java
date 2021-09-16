package lesson08.transport;

import java.util.Objects;

public class Battery implements CarForBattery{
    private int length;
    private int width;
    private int height;
    private int power;

    public Battery(int length, int width, int height, int power) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.power = power;
    }

    @Override
    public int lengthBattery() {
        return length;
    }

    @Override
    public int widthBattery() {
        return width;
    }

    @Override
    public int heightBattery() {
        return height;
    }

    @Override
    public int power() {
        return power;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battery battery = (Battery) o;
        return length == battery.length &&
                width == battery.width &&
                height == battery.height &&
                power == battery.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height, power);
    }
}

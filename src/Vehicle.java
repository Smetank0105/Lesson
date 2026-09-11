public class Vehicle {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            System.out.println("Скорость не может быть отрицательной");
            return;
        }
        this.speed = speed;
    }
}

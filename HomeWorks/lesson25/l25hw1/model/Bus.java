package l25hw1.model;

public class Bus {
    private int routeNum;
    private int capacity;
    private double routeSpeed;
    private double routeLength;

    public Bus(int routeNum, int capacity, double routeSpeed, double routeLength) {
        this.routeNum = routeNum;
        this.capacity = capacity;
        this.routeSpeed = routeSpeed;
        this.routeLength = routeLength;
    }

    public int getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRouteSpeed() {
        return routeSpeed;
    }

    public void setRouteSpeed(double routeSpeed) {
        this.routeSpeed = routeSpeed;
    }

    public double getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(double routeLength) {
        this.routeLength = routeLength;
    }

    public void go() {
        System.out.println("Bus " + routeNum + " is on the move.");
    }

    public void stop() {
        System.out.println("Bus " + routeNum + " has stopped.");
    }

    public void speedUp(double speedIncrease ) {
        routeSpeed += speedIncrease ;
        System.out.println("Bus " + routeNum + " has sped up to " + routeSpeed + " km/h.");
    }

    public void speedDown(double speedDecrease) {
        routeSpeed -= speedDecrease;
        if (routeSpeed < 0) {
            routeSpeed = 0;
        }
        System.out.println("Bus " + routeNum + " has slowed down to " + routeSpeed + " km/h.");
    }
}

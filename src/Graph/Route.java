package Graph;
public class Route {
    String name;
    Airport origin;  
    Airport destination;  
    int distance;  

    public Route(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.print("[" + getOrigin().getName() + ", " + getDestination().getName() + "]");
    }

    public void printStatus() {
        System.out.println("\n\n-----------------------ROUTE--" + getName() + "-----------------------");
        System.out.println("- ORIGIN: " + origin.getName());
        System.out.println("- DESTINATION: " + destination.getName());
        System.out.println("- DISTANCE: " + distance);
        System.out.println("-------------------------");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Airport getOrigin() {
        return origin;
    }
    public void setOrigin(Airport origin) {
        this.origin = origin;
    }
    public Airport getDestination() {
        return destination;
    }
    public void setDestination(Airport destination) {
        this.destination = destination;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
}

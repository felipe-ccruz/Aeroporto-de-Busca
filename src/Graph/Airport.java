package Graph;
import java.util.ArrayList;

public class Airport {
    private String name;
    private Airport predecessor;
    private int smallDistance;
    private ArrayList<Airport> entering;
    private ArrayList<Airport> leaving;
    private ArrayList<Route> routes;
    public Airport(String name) {
        this.name = name;
        this.entering = new ArrayList<Airport>();
        this.leaving = new ArrayList<Airport>();
        this.routes = new ArrayList<Route>();
    }
    
    public void addEnteringAirport(Airport airport) {
        entering.add(airport);
    }

    public void addLeavingAirport(Airport airport) {
        leaving.add(airport);
    }
    
    public void addRoute(Route route) {
        routes.add(route);
    }
    
    public void printEnteringAirport() {
        for (Airport a : entering) {
            System.out.print(" " + a.getName() + " ");
        }
    }

    public void printLeavingAirport() {
        for (Airport a : leaving) {
            System.out.print(" " + a.getName() + " ");
        }
    }

    public void printStatus(){
        System.out.println("\n\n-----------------------AIRPORT--" + getName() + "-----------------------");
        System.out.println("- LEAVING ROUTES:");
        System.out.print("  [");
        printLeavingAirport();
        System.out.println("]\n");

        System.out.println("- ENTERING ROUTES:");
        System.out.print("  [");
        printEnteringAirport();
        System.out.println("]\n");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Airport> getEntering() {
        return entering;
    }
    public ArrayList<Airport> getLeaving() {
        return leaving;
    }
    public Airport getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(Airport predecessor) {
        this.predecessor = predecessor;
    }
    public int getSmallDistance() {
        return smallDistance;
    }
    public void setSmallDistance(int smallDistance) {
        this.smallDistance = smallDistance;
    }
    public ArrayList<Route> getRoutes() {
        return routes;
    }
}

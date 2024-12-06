package Graph;

import java.util.ArrayList;

public class Graph {
    private int[][] connections;
    private ArrayList<Airport> airports;
    private ArrayList<Route> routes;

    public Graph(int numAirports) {
        this.airports = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.connections = new int[numAirports][numAirports];
        createConnectionMatrix();
    }

    // Criar matriz de conexão inicializada com 0
    public void createConnectionMatrix() {
        for (int i = 0; i < airports.size(); i++) {
            for (int j = 0; j < airports.size(); j++) {
                connections[i][j] = 0;
            }
        }
    }

    // Imprimir matriz de conexões
    public void printConnectionMatrix() {
        System.out.print("  ");
        for (Airport airport : airports) {
            System.out.print(" " + airport.getName());
        }
        System.out.println();

        for (int i = 0; i < airports.size(); i++) {
            System.out.print(airports.get(i).getName() + "[");
            for (int j = 0; j < airports.size(); j++) {
                if (connections[i][j] > 0) {
                    System.out.print(" " + ANSI_GREEN + connections[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(" " + connections[i][j] + " ");
                }
            }
            System.out.println("]");
        }
    }

    // Conectar duas cidades com uma rota
    public void connect(Route route, Airport source, Airport target, int distance) {
        Airport tempSource = source;
        Airport tempTarget = target;

        tempSource.addLeavingAirport(tempTarget);
        tempTarget.addEnteringAirport(tempSource);

        tempSource.addRoute(route);

        route.setDistance(distance);
        route.setOrigin(tempSource);
        route.setDestination(tempTarget);

        System.out.println("Conexão criada: " + tempSource.getName() + " -> " + tempTarget.getName());

        connections[airports.indexOf(tempSource)][airports.indexOf(tempTarget)]++;
    }

    // Imprimir conexões entre aeroportos
    public void printAirportConnections() {
        for (Airport airport : airports) {
            airport.printStatus();
        }
    }

    // Imprimir conexões de rotas
    public void printRouteConnections() {
        for (Route route : routes) {
            route.printStatus();
        }
    }

    // Limpar o grafo
    public void cleanGraph() {
        for (Airport airport : airports) {
            airport.setPredecessor(null);
            airport.setSmallDistance(0);
        }
    }

    public void addAirport(Airport airport) {
        airports.add(airport);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    // Getters
    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }
 

        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

}

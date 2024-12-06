package SearchAlgorithms;

import java.util.*;

import Graph.Route;
import Graph.Graph;
import Graph.Airport;

public class Dijkstra {
    private Graph graph;
    private Map<Airport, Integer> distances = new HashMap<>();
    private PriorityQueue<Airport> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

    public Dijkstra(Graph graph) {
        System.out.println("\n\n\n---------------Dijkstra---------------\n\n");
        this.graph = graph;
    }

    public void runDijkstra(String initialAirportName, String finalAirportName) {
        try {
            Airport initialAirport = searchFor(initialAirportName);
            Airport targetAirport = searchFor(finalAirportName);
            runDistances(initialAirport);
            queue.add(initialAirport);

            while (!queue.isEmpty()) {
                Airport current = queue.poll();

                if (current.equals(targetAirport)) break;

                for (Route r : current.getRoutes()) {
                    relaxRoute(current, r);
                }
            }
            showResults( initialAirport, targetAirport);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void runDistances(Airport initialAirport) {
        for (Airport v : graph.getAirports()) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(initialAirport, 0);
    }

    private void relaxRoute(Airport current, Route route) {
        Airport neighbor = route.getDestination();
        int newDist = distances.get(current) + route.getDistance();
    
        // Apenas atualize a distância se o novo caminho for menor
        if (newDist < distances.get(neighbor)) {
            distances.put(neighbor, newDist);
            neighbor.setPredecessor(current);
    
            // Adicione à fila apenas se ainda não estiver processado
            if (!queue.contains(neighbor)) {
                queue.add(neighbor);
            }
        }
    }
    

    // Busca um vértice pelo nome
    public Airport searchFor(String airportName) throws AirportNotFoundException {
        for (Airport a : graph.getAirports()) {
            if (a.getName().equals(airportName)) {
                return a;
            }
        }
        throw new AirportNotFoundException("Vértice '" + airportName + "' não encontrado.");
    }

    public void showResults(Airport initialAirport, Airport targetAirport) {
        System.out.printf("%-10s | %-10s | %-15s%n", "Vértice", "Distância", "Predecessor");
        System.out.println("--------------------------------------------");
    
        for (Airport a : graph.getAirports()) {
            String predecessorName = (a.getPredecessor() != null) ? a.getPredecessor().getName() : "null";
            int distance = distances.get(a);
    
            if (distance == Integer.MAX_VALUE) {
                System.out.printf("%-10s | %-10s | %-15s%n", a.getName(), "Infinito", predecessorName);
            } else {
                System.out.printf("%-10s | %-10d | %-15s%n", a.getName(), distance, predecessorName);
            }
        }
    
        printShortestPath(initialAirport, targetAirport);
    }
    
    
    // Função para imprimir o caminho mais curto até o target
    public void printShortestPath(Airport initialVertex, Airport target) {
    List<String> path = new ArrayList<>();
    Set<Airport> visited = new HashSet<>(); // Para detectar ciclos
    Airport step = target;

    while (step != null) {
        if (visited.contains(step)) {
            System.err.println("Ciclo detectado no caminho mais curto.");
            break; // Evita loop infinito
        }
        visited.add(step);
        path.add(step.getName());
        step = step.getPredecessor();
    }
    Collections.reverse(path);
    System.out.println("\nCaminho mais curto: " + String.join(" -> ", path));
    System.out.println("Distância total: " + distances.get(target));
}

    
}

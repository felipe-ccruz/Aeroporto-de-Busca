package SearchAlgorithms;

import Graph.Graph;
import Graph.Airport;
import java.util.ArrayList;

public  class DFS {
    private Graph graph;
    private ArrayList<Airport> visited = new ArrayList<>();
    private ArrayList<Airport> visitLine = new ArrayList<>();
    private ArrayList<Airport> altWay = new ArrayList<>();
    public DFS(Graph graph, String initialAirport, String finalAirport) {
        System.out.println("\n\n\n---------------DFS---------------");
        this.graph = graph;
        runDFS(initialAirport, finalAirport);
        altWay(finalAirport);
    }

    //Procura o VERTEX no grafo a pertir do nome.
    public Airport searchFor(String airport) throws AirportNotFoundException {
        for (Airport a : getGraph().getAirports()) {
            if (a.getName().equals(airport)) {
                return a; 
            }
        }
        throw new AirportNotFoundException("Vértice '" + airport + "' não encontrado.");
    }

    //Visita o VERTEX.
    public void visiting(){
        Airport a = visitLine.get(visitLine.size() - 1); //ultimo elemento da lista
        System.out.println("\nVisiting: " + a.getName());
        
        

        investigate(a);

        visitLine.remove(a);
        visited.add(a);
    }

    //Investiga os filhos do VERTEX
    public void investigate(Airport vistingAirport){
        for(Airport a : vistingAirport.getLeaving()){
            if(!visited.contains(a) && !visitLine.contains(a)){
                a.setPredecessor(vistingAirport);
                visitLine.add(a);
            }
        }
    }

    //EXECUTE
    public void runDFS(String initialAirport, String finalAirport) {
        
        try {
            visitLine.add(searchFor(initialAirport));
            Airport target = searchFor(finalAirport); 
            while (!visitLine.isEmpty() && !visited.contains(target)) {
                visiting();
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Acha um caminho alternativo.
    public void altWay(String finalAirport){
            
        try {
            Airport airport = searchFor(finalAirport);
            altWay.add(airport);


            while (airport.getPredecessor() != null) {
                altWay.add(airport.getPredecessor());
                airport = airport.getPredecessor();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

        //Tabela de Resultados do DFS
        public void showResult(){
            System.out.print("\n\nVISIT LINE: [");
            for(Airport a : visitLine){
                System.out.print(" " + ANSI_CYAN + a.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
                  
            System.out.print("\n\nDFS RESULT: [");
            for(Airport a : visited){
                System.out.print(" " + ANSI_CYAN + a.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
    
            System.out.print("\n\nALTERNATIVE WAY: [");
            for(Airport a : altWay){
                System.out.print(" " + ANSI_CYAN + a.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
    
        }

    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public ArrayList<Airport> getVisited() {
        return visited;
    }
    public ArrayList<Airport> getVisitLine() {
        return visitLine;
    }
    public ArrayList<Airport> getAltWay() {
        return altWay;
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
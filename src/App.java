import Graph.Airport;
import Graph.Route;
import SearchAlgorithms.BFS;
import SearchAlgorithms.DFS;
import SearchAlgorithms.Dijkstra;
import Graph.Graph;



public class App {
    public static void main(String[] args) throws Exception {

        Graph graph = new Graph(12);


        // Instanciando as rotas
        Route r1 = new Route("R1");
        Route r2 = new Route("R2");
        Route r3 = new Route("R3");
        Route r4 = new Route("R4");
        Route r5 = new Route("R5");
        Route r6 = new Route("R6");
        Route r7 = new Route("R7");
        Route r8 = new Route("R8");
        Route r9 = new Route("R9");
        Route r10 = new Route("R10");
        Route r11 = new Route("R11");
        Route r12 = new Route("R12");
        Route r13 = new Route("R13");
        Route r14 = new Route("R14");
        Route r15 = new Route("R15");
        Route r16 = new Route("R16");
        Route r17 = new Route("R17");
        Route r18 = new Route("R18");
        Route r19 = new Route("R19");
        Route r20 = new Route("R20");
        Route r21 = new Route("R21");
        Route r22 = new Route("R22");
        Route r23 = new Route("R23");
        Route r24 = new Route("R24");
        Route r25 = new Route("R25");
        Route r26 = new Route("R26");
        Route r27 = new Route("R27");
        Route r28 = new Route("R28");
        Route r29 = new Route("R29");
        Route r30 = new Route("R30");
        graph.addRoute(r1);
        graph.addRoute(r2);
        graph.addRoute(r3);
        graph.addRoute(r4);
        graph.addRoute(r5);
        graph.addRoute(r6);
        graph.addRoute(r7);
        graph.addRoute(r8);
        graph.addRoute(r9);
        graph.addRoute(r10);
        graph.addRoute(r11);
        graph.addRoute(r12);
        graph.addRoute(r13);
        graph.addRoute(r14);
        graph.addRoute(r15);
        graph.addRoute(r16);
        graph.addRoute(r17);
        graph.addRoute(r18);
        graph.addRoute(r19);
        graph.addRoute(r20);
        graph.addRoute(r21);   
        graph.addRoute(r22);
        graph.addRoute(r23);
        graph.addRoute(r24);
        graph.addRoute(r25);
        graph.addRoute(r26);
        graph.addRoute(r27);
        graph.addRoute(r28);
        graph.addRoute(r29);
        graph.addRoute(r30);


        Airport a1 = new Airport("PA");
        Airport a2 = new Airport("PB");
        Airport a3 = new Airport("SP");
        Airport a4 = new Airport("RJ");
        Airport a5 = new Airport("AC");
        Airport a6 = new Airport("AL");
        Airport a7 = new Airport("SE");
        Airport a8 = new Airport("BA");
        Airport a9 = new Airport("AM");
        Airport a10 = new Airport("GO");
        Airport a11 = new Airport("MS");
        Airport a12 = new Airport("MT");
        graph.addAirport(a1); 
        graph.addAirport(a2); 
        graph.addAirport(a3); 
        graph.addAirport(a4); 
        graph.addAirport(a5); 
        graph.addAirport(a6); 
        graph.addAirport(a7); 
        graph.addAirport(a8); 
        graph.addAirport(a9); 
        graph.addAirport(a10); 
        graph.addAirport(a11); 
        graph.addAirport(a12); 

        graph.connect(r1, a1, a2, 100);
        graph.connect(r2, a2, a3, 200);
        graph.connect(r3, a3, a4, 300);
        graph.connect(r4, a4, a5, 400);
        graph.connect(r5, a5, a1, 500);
        graph.connect(r6, a6, a7, 600);
        graph.connect(r7, a7, a8, 700);
        graph.connect(r8, a8, a9, 800);
        graph.connect(r9, a9, a10, 900);
        graph.connect(r10, a10, a11, 1000);
        graph.connect(r11, a11, a12, 1100);
        graph.connect(r12, a12, a1, 1200); 
        graph.connect(r13, a1, a3, 300);
        graph.connect(r14, a2, a4, 400);
        graph.connect(r15, a3, a5, 500);
        graph.connect(r16, a4, a6, 600);
        graph.connect(r17, a5, a3, 700);
        graph.connect(r18, a6, a8, 800);
        graph.connect(r19, a7, a9, 900);
        graph.connect(r20, a8, a10, 1000);
        graph.connect(r21, a9, a11, 1100);
        graph.connect(r22, a10, a12, 1200);
        graph.connect(r23, a11, a1, 1300);
        graph.connect(r24, a12, a2, 1400);
        graph.connect(r25, a3, a12, 300);
        graph.connect(r26, a4, a1, 400);
        graph.connect(r27, a3, a2, 500);
        graph.connect(r28, a4, a3, 600);
        graph.connect(r29, a3, a9, 700);
        graph.connect(r30, a3, a8, 800);

        graph.printConnectionMatrix();

        BFS bfs = new BFS(graph, "SP", "MT");
        bfs.showResult();
        graph.cleanGraph();

        BFS bfs2 = new BFS(graph, "PA", "AC");
        bfs2.showResult();
        graph.cleanGraph();

        DFS dfs = new DFS(graph, "SP", "MT");
        dfs.showResult();
        graph.cleanGraph();

        DFS dfs2 = new DFS(graph, "PA", "AC");
        dfs2.showResult();
        graph.cleanGraph();

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.runDijkstra("SP", "MT");

        Dijkstra dijkstra2= new Dijkstra(graph);
        dijkstra2.runDijkstra("PA", "AC");

    }
}

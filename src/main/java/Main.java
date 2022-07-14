import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import org.graphstream.algorithm.Dijkstra.Element;
import org.graphstream.graph.Graph;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String args[]) {

        System.setProperty("org.graphstream.ui", "swing");
        List<Host> personList = asList(new Host(1, "Nicolas"),
                new Host(2, "Erika"),
                new Host(3, "Vlad"),
                new Host(4, "Elsa"),
                new Host(5, "Robert"),
                new Host(6, "Georg"),
                new Host(7, "Oscar"),
                new Host(8, "Niko"),
                new Host(9, "Nele"),
                new Host(10, "Artur"),
                new Host(11, "Gizem"),
                new Host(12, "Ivanka"),
                new Host(13, "Veronika"),
                new Host(14, "Elif"),
                new Host(15, "Ursula"),
                new Host(16, "Uysal"),
                new Host(17, "Patrick")
        );

        List<EdgeHost> edgeList = asList(new EdgeHost(personList.get(0), personList.get(1), 2),
                new EdgeHost(personList.get(0), personList.get(2), 17),
                new EdgeHost(personList.get(1), personList.get(3), 11),
                new EdgeHost(personList.get(1), personList.get(4), 19),
                new EdgeHost(personList.get(2), personList.get(4), 1),
                new EdgeHost(personList.get(2), personList.get(5), 3),
                new EdgeHost(personList.get(2), personList.get(6), 1),
                new EdgeHost(personList.get(2), personList.get(12), 4),
                new EdgeHost(personList.get(3), personList.get(7), 4),
                new EdgeHost(personList.get(3), personList.get(8), 7),
                new EdgeHost(personList.get(4), personList.get(9), 3),
                new EdgeHost(personList.get(6), personList.get(10), 14),
                new EdgeHost(personList.get(6), personList.get(11), 12),
                new EdgeHost(personList.get(6), personList.get(12), 6),
                new EdgeHost(personList.get(7), personList.get(16), 9),
                new EdgeHost(personList.get(8), personList.get(13), 4),
                new EdgeHost(personList.get(9), personList.get(15), 3),
                new EdgeHost(personList.get(12), personList.get(14), 4),
                new EdgeHost(personList.get(12), personList.get(15), 10),
                new EdgeHost(personList.get(1), personList.get(16), 4)
        );

        Graph graph1 = new SingleGraph("Tutorial 2");


        // adding nodes to graph defined by hosts in personlist
        for (Host g : personList) {
            graph1.addNode(g.getPersonName());
        }

        // adding edges (addEdge) following the given structure:
        // String of Person1Name-Person2Name, Person1Name, Person2Name
        // adding weight to edges(setAttribute) given by days till infection
        for (EdgeHost e : edgeList) {
            graph1.addEdge( e.getStartHost().getPersonName() + "-" + e.getEndHost().getPersonName(),
                        e.getStartHost().getPersonName(),
                        e.getEndHost().getPersonName(), true)
                    .setAttribute("days", e.getDistance());
        }

        // defining what to put as label
        for (Node node : graph1) {
            node.setAttribute("ui.label", node.getId());
        }

        // setting edge weight as label for visualization
        graph1.getEachEdge().forEach(n -> n.setAttribute("ui.label", Integer.toString(n.getAttribute("days"))));



        displayAutoLayout(graph1);
        displayFixedLayout(graph1);

        //apply structure to allow readAll
        String my_graph;

        my_graph = "DGS004\n"
                + "my 0 0\n";

        for (Host g : personList) {
            my_graph = my_graph + "an" + g.getPersonName() + "\n";
        }
    }


    private static void displayAutoLayout(Graph graph1) {

        //Viewer viewer = graph1.display(false);
        // not functional atm
        HierarchicalLayout hl = new HierarchicalLayout();
        //viewer.enableAutoLayout(hl);


        graph1.setStrict(false);
        graph1.setAutoCreate( true );

        // defining css style for graph
        graph1.setAttribute("ui.stylesheet", "graph { text-mode: normal; text-alignment: at-right; }" +
                 " edge { text-mode: normal; text-visibility-mode: normal; shape: cubic-curve; arrow-shape: arrow; }");
        // passing false will deactivate auto placement - not recommended
        graph1.display();
    }

    private static void displayFixedLayout(Graph graph1) {

        // setting attribute to place each node into predetermined position in cartesian coordinate system
        graph1.getNode("Nicolas").setAttribute("xy", 7, 4);
        graph1.getNode("Erika").setAttribute("xy", 4, 3);
        graph1.getNode("Vlad").setAttribute("xy", 9, 3);
        graph1.getNode("Elsa").setAttribute("xy", 3, 2);
        graph1.getNode("Robert").setAttribute("xy", 6, 2);
        graph1.getNode("Georg").setAttribute("xy", 8, 2);
        graph1.getNode("Oscar").setAttribute("xy", 9, 2);
        graph1.getNode("Niko").setAttribute("xy", 2, 1);
        graph1.getNode("Nele").setAttribute("xy", 5, 1);
        graph1.getNode("Artur").setAttribute("xy", 6, 1);
        graph1.getNode("Gizem").setAttribute("xy", 8, 1);
        graph1.getNode("Ivanka").setAttribute("xy", 10, 1);
        graph1.getNode("Veronika").setAttribute("xy", 11, 1);
        graph1.getNode("Patrick").setAttribute("xy", 1, 0);
        graph1.getNode("Elif").setAttribute("xy", 5, 0);
        graph1.getNode("Uysal").setAttribute("xy", 8, 0);
        graph1.getNode("Ursula").setAttribute("xy", 11, 0);


        graph1.setStrict(true);
        graph1.setAutoCreate( false );

        // defining css style for graph
        graph1.removeAttribute("ui.stylesheet");
        //graph1.setAttribute("ui.stylehseet", "url(C:\\Users\\KevinHilzinger\\IdeaProjects\\GraphVisualization\\stylesheet.css)");
        graph1.setAttribute("ui.stylesheet", "graph { text-mode: normal; text-alignment: at-right;" +
                "text-color: #222; } edge { shape: cubic-curve; arrow-shape: arrow; }");
        // passing false will deactivate auto placement to place as stated with xy attribute
        graph1.display(false);
    }



}
import java.util.*;

public class InfectionGraph {
    /**
     // No. of vertices
     private int V;
     // Adjacency List as ArrayList of ArrayList's
     private ArrayList<ArrayList<Integer> > adj; **/
    public InfectionGraph(List<Host> hostList) {

        /**List<Host> hostList1 = hostList;
         List<ArrayList<Host>> adj = new ArrayList<>();
         for (int i = 0; i < hostList.size(); ++i)
         adj.add(new ArrayList<>()); **/


        this.hostList = hostList;
    }

    List<Host> hostList = new ArrayList<>();

    void shortestPath (Host startHost) {
        startHost.distanceToStart = 0;
        PriorityQueue<Host> pq = new PriorityQueue<>(this.hostList);
        while (!pq.isEmpty()) {
            Host minNode = pq.poll();
            for (EdgeHost e : minNode.outEdges) {
                int dist = minNode.distanceToStart + e.distance;
                if (dist < e.endHost.distanceToStart) {
                    e.endHost.distanceToStart = dist;
                    pq.remove(e.endHost);
                    pq.add(e.endHost);
                }
            }
        }
    }
/**
 // A recursive function used by topologicalSort
 void topologicalSortUtil(int v, boolean visited[],
 Stack<Integer> stack)
 {
 // Mark the current node as visited.
 visited[v] = true;
 Integer i;

 // Recur for all the vertices adjacent
 // to thisvertex
 Iterator<Integer> it = adj.get(v).iterator();
 while (it.hasNext()) {
 i = it.next();
 if (!visited[i])
 topologicalSortUtil(i, visited, stack);
 }

 // Push current vertex to stack
 // which stores result
 stack.push(new Integer(v));
 }

 // The function to do Topological Sort.
 // It uses recursive topologicalSortUtil()
 void topologicalSort()
 {
 Stack<Integer> stack = new Stack<Integer>();

 // Mark all the vertices as not visited
 boolean visited[] = new boolean[V];
 for (int i = 0; i < V; i++)
 visited[i] = false;

 // Call the recursive helper
 // function to store
 // Topological Sort starting
 // from all vertices one by one
 for (int i = 0; i < V; i++)
 if (visited[i] == false)
 topologicalSortUtil(i, visited, stack);

 // Print contents of stack
 while (stack.empty() == false)
 System.out.print(stack.pop() + " ");
 }**/
}

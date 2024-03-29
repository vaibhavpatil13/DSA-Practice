import java.util.*;

//to overcome dijkstras alg if negative weights

public class bellmanfordalg{
    static class Edge{
         int src;
        int dest;
        int wt;
        

        Edge(int s, int d , int w){
            this.src =s;
            this.dest =d;
            this.wt =w;
            
        }
    }
     public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add( new Edge(0,1,2));
        graph[0].add( new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    



    }
    public static void bellmanford(ArrayList<Edge> graph[] , int src){
        int dist[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE ;

            }
        }

        int ver = graph.length;

        for(int i=0;i<ver-1;i++){   //iterates v-1 times

            // to find neighbours
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] +wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]){
         int v =6 ;
        ArrayList<Edge> graph[] = new ArrayList[v];

        creategraph(graph);

        int src =0;

        bellmanford(graph ,src);

    }

}
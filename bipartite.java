import java.util.*;

public class bipartite{
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

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
       // graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,1,1));
      
        graph[4].add(new Edge(4,2,1));
       // graph[4].add(new Edge(4,3,1));
        


    }
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        //if graph doesnt have cycle = bipartite
        int col[] = new int[graph.length];

        for(int i=0;i<col.length;i++){
            col[i] =-1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i] ==-1){
                q.add(i);
                col[i] =0;   //yellow

                while(!q.isEmpty()){
                    int curr = q.remove();

                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
  
                        if(col[e.dest]==-1){           //case 3
                            int nextcol = col[curr] ==0?1:0;    //assign opposite col to neighbour
                            col[e.dest] =nextcol;
                            q.add(e.dest);                 //add neighbours
                        }
                        else if(col[e.dest] == col[curr]){     //case 1
                            return false;                     // if bigbour col is same
                        }
                    }
                }
            }
        }

        return true;             //case 2 if different col bipartite
    }
    public static void main(String args[]){

        int v=5;

        ArrayList<Edge> graph[] = new ArrayList[v];
        creategraph(graph);
         
        System.out.print(isBipartite(graph));
        
    }
}
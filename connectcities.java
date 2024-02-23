import java.util.*;

public class connectcities{
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        public Edge(int d,int c){
            this.dest =d;
            this.cost =c;

        }
        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost ;
        }
    }

    public static int mst(int city[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[city.length];

        pq.add(new Edge(0,0));

        int finalcost =0;

        while(!pq.isEmpty()){
            Edge curr = pq.remove();

            

            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                finalcost += curr.cost;

                for(int i=0;i<city[curr.dest].length;i++){
                    if(city[curr.dest][i] !=0){
                        pq.add(new Edge(i , city[curr.dest][i]));
                    }
                }
            }
        }

        return finalcost;
    }
    public static void main(String args[]){

        int city[][] = { {0,1,2,3,4},
                         {1,0,5,0,7},
                         {2,5,0,6,0},
                         {3,0,6,0,0},
                         {4,7,0,0,0}} ;

        System.out.print(mst(city));

    }
}
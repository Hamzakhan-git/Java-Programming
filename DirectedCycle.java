import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class DirectedCycle {

private boolean dfs(int start,int[] vis,int[] path,ArrayList<ArrayList<Integer>> adj){
    vis[start]=1;
    path[start]=1;
    for (int neighbour : adj.get(start)) {
        if(vis[neighbour]==0){
            if(dfs(neighbour,vis,path,adj)) return true;
        }
        else if(path[neighbour]==1) return true;
    }
    path[start]=0;
    return false;
    
}
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        int[] path = new int[V];
        for(int i=0;i<V;i++) vis[i]=0;
        for(int i=0;i<V;i++) path[i]=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,path,adj)==true) return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        DirectedCycle obj = new DirectedCycle();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }
}
    


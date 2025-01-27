import java.util.ArrayList;
import java.util.List;

public class DetectCycle {
    private boolean dfs(int node,int parent, int[] vis,List<List<Integer>> adj){
        vis[node] =1;
        for (int adjacentNode : adj.get(node)) {
            if (vis[adjacentNode]==0) {
                if(dfs(adjacentNode,node,vis,adj)==true) return true;
            } 
            else{
                if(adjacentNode!=parent) return true;
            }
        }
        return false;
    }


    public boolean isCycle(int V, List<List<Integer>> adj){
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,adj)==true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);
                
        DetectCycle obj = new DetectCycle();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
    }
}

package shangguigu.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: Kate Fu
 * @create: 2022-01-19 19:46
 */
public class DFSinList {
    public static void main(String[] args) {
        DFSGraph g =new DFSGraph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("dfs result:");
        g.DFS(2);
    }
}

class DFSGraph{
    private int V;
    private LinkedList<Integer> adj[];
    public DFSGraph(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void DFSUtil(int v, boolean visited[]){
        visited[v]=true;
        System.out.print(v+"->");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }
    //回溯
    public void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}

package shangguigu.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: Kate Fu
 * @create: 2022-01-19 16:10
 */
public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    //record whether the vertex has been visited
    private boolean[] isVisited;
    public static void main(String[] args){
        int n=5;
        String VertexValue[]={"a","b","c","d","e"};
        Graph graph = new Graph(n);
        for(String value: VertexValue){
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showMatrix();

        //深度遍历
        //graph.dfs();

        //广度遍历
        graph.bfs();
    }

    public Graph(int n){
        //initiate the matrix and arraylist
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges =0;
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    //return vertex number
    public int getNumOfVertex(){
        return vertexList.size();
    }
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //return vertex i 's data
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //return edge's weight
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //show the matrix
    public void showMatrix(){
        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges[i].length; j++){
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }
    }

    public int getFirstNeighbor(int index){
        for(int j=0; j<vertexList.size(); j++){
            if(edges[index][j]>0) return j;
        }
        return -1;
    }

    //根据前一个邻接节点下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2){
        for(int j=v2+1; j<vertexList.size(); j++){
            if(edges[v1][j]>0) return j;
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i){
        //1.访问该节点并输出
        System.out.println(getValueByIndex(i)+"->");
        //设置该节点为已访问
        isVisited[i]= true;
        //查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while(w!=-1){//有邻接节点
            if(!isVisited[w]){
                dfs(isVisited,w);
            } else {
                w = getNextNeighbor(i, w);
            }
        }
    }

    //对dfs进行重载，遍历所有的节点并进行dfs，考虑到非连通图
    public void dfs(){
        for(int i=0; i<getNumOfVertex(); i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i){
        int u;//表示队列头节点对应的下标
        int w;//邻接节点w
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        // 访问该节点
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        queue.addLast(i);

        while(!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while(w!=-1){//找到邻接节点
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w]=true;
                    queue.addLast(w);
                }
                //以u为前驱节点找w后面的下一个邻接点
                w = getNextNeighbor(u,w);//体现广度优先
            }
        }
    }

    //遍历所有节点进行广度优先搜索
    public void bfs(){
        for(int i=0; i<getNumOfVertex(); i++){
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }
}

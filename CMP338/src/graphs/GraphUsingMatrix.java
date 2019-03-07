package graphs;

import java.util.Stack;

public class GraphUsingMatrix {
	boolean [] visitedV;//to track the visited
	private int numVertices;//num of vertices in the graph
	private int numEdges;//num of edges in the graph
	private int[][] adjacencyMatrix;
	
	public GraphUsingMatrix(int n){
		numVertices = n;
		numEdges=0;
		adjacencyMatrix = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				adjacencyMatrix[i][j]=0;//no edges just nodes to start
			}
		}
		visitedV = new boolean[n];//to track the visited
		clearVisited();
	}
	public int getNumVertices() {
		return numVertices;
	}
	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}
	public int getNumEdges() {
		return numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	public int getEdge(int from, int to){
		return adjacencyMatrix[from][to];
	}
	public void setEdge(int from, int to, int edgeValue){
		adjacencyMatrix[from][to] = edgeValue;
	}
	public void setEdge(Edge edge){
		setEdge(edge.getV(), edge.getW(), edge.getWeight());
	}
	public void displayAsMatrix(){
		System.out.println("A  |  B  |  C  |  D  |  E  |");
		for(int i=0; i<numVertices; i++)
		{
			System.out.println();
			for(int j=0; j<numVertices; j++)
			{
				System.out.print(adjacencyMatrix[i][j] +"  |  ");
			}
		}
	}
	
	public void dfs(int v)
	{
		if(!visitedV[v])
		{
			System.out.print(v+" ");
		}
		visitedV[v]=true;//mark as visited
		
		for(int w=0; w<numVertices; w++)
		{
			if((adjacencyMatrix[v][w] >0 )  && (!visitedV[w]))
			{
				dfs(w);//visit it using a recursive call
			}
		}
	}
	public void bfs(int v)
	{
		
	}

	private void clearVisited(){
		for(int i=0; i<numVertices; i++){
			visitedV[i]=false;
		}
	}
}

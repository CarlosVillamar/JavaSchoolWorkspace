package graphs;

public class DSFTester {

	public static void main(String[] args) {
		GraphUsingMatrix graph = new GraphUsingMatrix(5);
		Edge e = new Edge(0,1,1);
	//	graph.setEdge(e);
	//	graph.setEdge(new Edge(0,1,1));
		graph.setEdge(0,1,1);//a to b
		//graph.setEdge(1,0,1);//b to a
		graph.setEdge(1,3,1);//b to d
		//graph.setEdge(2,4,1);//c to e
		//graph.setEdge(3,1,1);//d to b
		graph.setEdge(3,4,1);//d to e
		graph.setEdge(4,2,1);//e to c
		//graph.setEdge(4,3,1);//e to d
		graph.setEdge(4,1,1);
		
		
	//	graph.displayAsMatrix();
		graph.dfs(0);
		//graph.dfsIter(0);

}
}

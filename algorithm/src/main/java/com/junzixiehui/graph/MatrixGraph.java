package com.junzixiehui.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 邻接矩阵</p>
 * @author: by qulibin
 * @date: 2020/3/29  2:05 PM
 * @version: 1.0
 */
public class MatrixGraph {

	//顶点
	private List<Vertex> vertexList;

	private int[][] edge;
	private int numOfEdges;//边的数目

	private List<Vertex> visitedVertexList = new ArrayList<Vertex>();


	public MatrixGraph(int vertexNum){
		edge = new int[vertexNum][vertexNum];
		vertexList = new ArrayList<Vertex>(vertexNum);
		numOfEdges = 0;
	}

	public void addVertex(Vertex vertex){
		vertexList.add(vertex);
	}

	public void addEdge(int a,int b,int weight){
		edge[a][b] = weight;
		numOfEdges ++;
	}

	public void deleteEdge(int a,int b){
		edge[a][b] = 0;
		numOfEdges --;
	}


	public void dfsT(){
		for (int i = 0;i<vertexList.size();i++){
			if (!visitedVertexList.contains(vertexList.get(i))){
               DFS(i,vertexList.get(i));
			}
		}
	}

	private void DFS(int i,Vertex vertex) {
		visitedVertexList.add(vertex);
		for (int j = 0;j<vertexList.size();j++){
			if (edge[i][j] > 0 && !visitedVertexList.contains(vertexList.get(j))){

				System.out.println("DFS" + vertexList.get(j));
				DFS(j,vertexList.get(j));
			}
		}
	}

	public static void main(String args[]) {
		int n=4;
		String labels[]={"V1","V1","V3","V4"};//结点的标识
		MatrixGraph graph=new MatrixGraph(n);
		for(String label:labels) {
			final Vertex vertex = new Vertex();
			vertex.setName(label);
			graph.addVertex(vertex);//插入结点
		}
		//插入四条边
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 5);
		graph.addEdge(2, 3, 8);
		graph.addEdge(3, 0, 7);

		System.out.println("个数是："+ graph.numOfEdges);


		graph.deleteEdge(0, 1);//删除<V1,V2>边
		System.out.println("删除<V1,V2>边后...");
		System.out.println("个数是："+ graph.numOfEdges);


		graph.dfsT();
	}

}

package Graph;

import java.util.ArrayList;

public class Graph1 {

	public Graph1() {

	}

	public static class Edge {
		int v1;
		int v2;
		int wt;

		public Edge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}
	}

	public static void fun() {
		int n = 7;
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		int data[][] = { { 0, 1, 10 }, { 0, 3, 40 }, { 2, 3, 10 }, { 1, 2, 10 }, { 3, 4, 2 }, { 4, 5, 3 }, { 4, 6, 8 },
				{ 5, 6, 3 } };
		for (int i = 0; i < data.length; i++) {
			addEdge(graph, data[i][0], data[i][1], data[i][2]);
		}
		display(graph);
		System.out.println(hasPath(graph, 0, 1, new boolean[7]));
		printAllPath(graph, 0, 6, "", new boolean[7], 0);
	}

	public static void printAllPath(ArrayList<Edge> graph[], int src, int dst, String path, boolean visi[], int wsf) {
		if (src == dst) {
			path += src;
			System.out.println(path);
			return;
		}
		visi[src] = true;
		for (Edge e : graph[src]) {

			if (visi[e.v2] == false) {
				printAllPath(graph, e.v2, dst, path + src, visi, wsf);

			}
		}
		visi[src] = false;

	}

	public static void display(ArrayList<Edge> e[]) {

		for (ArrayList<Edge> edge : e) {
			for (Edge e1 : edge) {
				int v1 = e1.v1;
				int v2 = e1.v2;
				int wt = e1.wt;

				System.out.print("[" + v1 + "-" + v2 + " @" + wt + "], ");
			}
			System.out.println();
		}

	}

	public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {

		graph[v1].add(new Edge(v1, v2, wt));
		graph[v2].add(new Edge(v2, v1, wt));

	}

	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dst, boolean visi[]) {

		if (src == dst) {
			return true;
		}
		visi[src] = true;
		for (Edge e : graph[src]) {

			if (visi[e.v2] == false) {
				boolean p = hasPath(graph, e.v2, dst, visi);
				if (p == true) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		fun();

	}

}

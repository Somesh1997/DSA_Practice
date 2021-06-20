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
		int data[][] = { { 0, 6, 10 }, { 0, 3, 40 }, { 4, 3, 10 }, { 1, 2, 10 }, { 3, 4, 2 }, { 4, 5, 3 }, { 4, 6, 8 },
				{ 5, 6, 3 } };
		for (int i = 0; i < data.length; i++) {
			addEdge(graph, data[i][0], data[i][1], data[i][2]);
		}
		display(graph);
		System.out.println(hasPath(graph, 0, 1, new boolean[7]));
		printAllPath(graph, 0, 6, "", new boolean[7], 0);
		getConnectedCom(graph, 0, new boolean[7]);
	}

	public static void printAllPath(ArrayList<Edge> graph[], int src, int dst, String path, boolean visi[], int wsf) {
		if (src == dst) {
			path += src;
			wsf += src;
			System.out.println(path + " " + wsf);
			return;
		}
		visi[src] = true;
		for (Edge e : graph[src]) {

			if (visi[e.v2] == false) {
				printAllPath(graph, e.v2, dst, path + src, visi, wsf + src);

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

	public static void getConnectedCom(ArrayList<Edge> graph[], int src, boolean arr[]) {

		arr[src] = true;
		int count = 0;
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			if (arr[i] == false) {
				ArrayList<Integer> list = new ArrayList<>();
				reverse(graph, i, arr, list);
				comps.add(list);
				count++;
			}
		}
		System.out.println(count);
		System.out.println(comps);
	}

	public static void reverse(ArrayList<Edge> graph[], int src, boolean arr[], ArrayList<Integer> list) {

		arr[src] = true;
		list.add(src);
		for (Edge e : graph[src]) {
			if (arr[e.v2] == false) {
				reverse(graph, e.v2, arr, list);
			}
		}
	}

	public static void main(String[] args) {
		fun();

	}

}

package com.project._2023_01_31;

import java.util.*;

// Класс для хранения ребра Graph
class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

// Класс для хранения узла
class Node {

    //вершина
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Класс для представления графического объекта
class Graph {
    // Список списков для представления списка смежности
    List<List<Edge>> adjList = null;

    // Конструктор
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // добавляем ребра в ориентированный graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}

class Main {
    private static void getRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    // Запускаем алгоритм Дейкстры на заданном Graph
    public static void findShortestPaths(Graph graph, int source, int nodesNumbers) {
        //создаем очередь из узлов
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        // устанавливаем начальное расстояние от источника до всех элементов как бесконечность
        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(nodesNumbers, Integer.MAX_VALUE));

        // расстояние от источника до себя равно нулю
        dist.set(source, 0);

        // логический массив для отслеживания вершин, для которых мин
        // стоимость уже найдена
        boolean[] done = new boolean[nodesNumbers];
        done[source] = true;

        // сохраняет предыдущую вершину
        int[] prev = new int[nodesNumbers];
        prev[source] = -1;

        // пока мини-куча не станет пустой
        while (!minHeap.isEmpty()) {
            // Удалить и вернуть лучшую вершину
            Node node = minHeap.poll();

            // получаем номер вершины
            int vertex = node.vertex;

            // делаем для каждого соседа
            for (Edge edge : graph.adjList.get(vertex)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Шаг релаксации
                if (!done[v] && (dist.get(vertex) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(vertex) + weight);
                    prev[v] = vertex;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // помечаем вершину `vertex` как выполненную, чтобы она больше не поднималась
            done[vertex] = true;
        }

        List<Integer> route = new ArrayList<>();

        for (int i = 0; i < nodesNumbers; i++) {
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                getRoute(prev, i, route);
                System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
                        source, i, dist.get(i), route);
                route.clear();
            }
        }
    }

    public static void main(String[] args) {
        // инициализируем ребра в соответствии с приведенной выше диаграммой
        // (u, v, w) представляет ребро из вершины `u` в вершину `v` с весом `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10), new Edge(0, 4, 3), new Edge(1, 2, 2),
                new Edge(1, 4, 4), new Edge(2, 3, 9), new Edge(3, 2, 7),
                new Edge(4, 1, 1), new Edge(4, 2, 8), new Edge(4, 3, 2)
        );

        // общее количество узлов в Graph (от 0 до 4)
        int n = 5;

        // построить Graph
        Graph graph = new Graph(edges, n);

        // запускаем алгоритм Дейкстры с каждого узла
        for (int source = 0; source < n; source++) {
            findShortestPaths(graph, source, n);
        }
    }
}
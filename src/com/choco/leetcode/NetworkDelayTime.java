package com.choco.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();
        Solution solution = ndt.new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
    }

    class Solution {
        Map<Integer, Node> nodesMap;
        List<Edge> edges;
        List<Node> S;
        Map<Integer, Node> T;//T = V - S
        Node s;

        public int networkDelayTime(int[][] times, int N, int K) {
            nodesMap = new HashMap<>();
            edges = new ArrayList<>();
            S = new ArrayList<>();
            T = new HashMap<>();

            //初始化节点信息
            Node node;
            for (int i = 1; i <= N; i++) {
                node = new Node(i);
                node.father = null;
                node.distance = Integer.MAX_VALUE;
                nodesMap.put(i, node);
                T.put(i, node);
            }

            //存储点的邻接边
            for (int[] edge : times) {
                Node start = nodesMap.get(edge[0]);
                Node end = nodesMap.get(edge[1]);
                Edge e = new Edge();
                e.start = start;
                e.end = end;
                e.weight = edge[2];
                edges.add(e);
                start.adjEdgeList.add(e);
            }

            s = nodesMap.get(K);
            S.add(s);
            s.father = null;
            s.distance = 0;
            updateNode(s);
            T.remove(s.id);

            Node i;
            while (S.size() != N) {
                i = findMin();
                if (i.distance == Integer.MAX_VALUE) {
                    return -1;
                }
                S.add(i);
                updateNode(i);
            }

            int maxDelay = 0;
            for (Node n : nodesMap.values()) {
                if (maxDelay < n.distance) {
                    maxDelay = n.distance;
                }
            }
            return maxDelay;
        }

        private void updateNode(Node i) {
            for (Edge e : i.adjEdgeList) {
                if ((e.weight + i.distance) < e.end.distance) {
                    e.end.distance = e.weight + i.distance;
                    e.end.father = i;
                }
            }
        }

        private Node findMin() {
            Node node = T.values().iterator().next();
            for (Node n : T.values()) {
                if (node.distance > n.distance) {
                    node = n;
                }
            }
            T.remove(node.id);
            return node;
        }

        class Node {
            int distance;
            int id;
            Node father;
            List<Edge> adjEdgeList;

            public Node(int id) {
                this.id = id;
                adjEdgeList = new ArrayList<>();
            }
        }

        class Edge {
            Node start;
            Node end;
            int weight;
        }
    }

}

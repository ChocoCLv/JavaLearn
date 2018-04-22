package com.choco.leetcode;

import java.util.*;

public class MinHeightTrees {
    public static void main(String[] args) {
        MinHeightTrees mht = new MinHeightTrees();
        Solution solution = mht.new Solution();
        List<Integer> trees = solution.findMinHeightTrees(147, new int[][]
        {{0,1},{1,2},{0,3},{3,4},{2,5},{5,6},{1,7},{2,8},{0,9},{1,10},{8,11},{8,12},{6,13},{11,14},{12,15},{9,16},{14,17},{4,18},{4,19},{15,20},{20,21},{2,22},{8,23},{14,24},{15,25},{21,26},{18,27},{21,28},{24,29},{14,30},{27,31},{20,32},{21,33},{29,34},{27,35},{0,36},{19,37},{3,38},{19,39},{26,40},{17,41},{40,42},{24,43},{29,44},{31,45},{8,46},{10,47},{5,48},{33,49},{18,50},{3,51},{17,52},{34,53},{0,54},{2,55},{16,56},{46,57},{53,58},{27,59},{1,60},{21,61},{44,62},{9,63},{40,64},{12,65},{63,66},{27,67},{62,68},{7,69},{24,70},{34,71},{26,72},{20,73},{35,74},{48,75},{73,76},{65,77},{0,78},{6,79},{74,80},{70,81},{39,82},{23,83},{28,84},{56,85},{56,86},{49,87},{8,88},{56,89},{14,90},{9,91},{43,92},{65,93},{84,94},{75,95},{28,96},{5,97},{49,98},{94,99},{8,100},{92,101},{93,102},{77,103},{83,104},{63,105},{61,106},{32,107},{54,108},{44,109},{29,110},{68,111},{110,112},{12,113},{49,114},{31,115},{53,116},{53,117},{39,118},{90,119},{2,120},{114,121},{69,122},{110,123},{120,124},{90,125},{121,126},{61,127},{9,128},{47,129},{123,130},{25,131},{89,132},{77,133},{127,134},{12,135},{63,136},{84,137},{101,138},{98,139},{40,140},{112,141},{19,142},{55,143},{88,144},{49,145},{95,146}});
        for (int i : trees) {
            System.out.println(i);
        }
    }

    class Solution {
        List<Integer> result;
        Node node;

        private Map<Integer, Node> adjMap;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            adjMap = new HashMap<>();
            result = new ArrayList<>();
            if(n == 1){
                result.add(0);
                return result;
            }
            int p, q;
            Node np, nq;
            //构造邻接链表
            for (int[] edge : edges) {
                p = edge[0];
                q = edge[1];
                np = getNode(p);
                nq = getNode(q);
                np.adjList.add(nq);
                nq.adjList.add(np);
            }

            Node startNode = bfs(getNode(0));

            for(Node nn:adjMap.values()){
                nn.father = null;
                nn.height = 0;
                nn.children.clear();
                nn.isVisited = false;
            }
            Node endNode = bfs(startNode);

            int maxLength = endNode.height;
            int root1 = 0;
            int root2 = 0;
            if(maxLength % 2 == 1){
                root2 = maxLength/2+1;
                Node rootNode = endNode;
                while(rootNode.height != root2){
                    rootNode = rootNode.father;
                }
                result.add(rootNode.id);
                result.add(rootNode.father.id);
            }else{
                root1 = maxLength/2;
                Node rootNode = endNode;
                while(rootNode.height != root1){
                    rootNode = rootNode.father;
                }
                result.add(rootNode.id);
            }

            return result;

//            //深度优先遍历得到节点的高度、最长子链长度和次长子链长度
//            dfs(adjMap.get(0), 0);
//
//            //计算图中最长链的长度
//            int maxLength = 0;
//            int length;
//
//            for (Node nn : adjMap.values()) {
//                length = nn.maxLength + Math.max(nn.height, nn.secLength);
//                if (maxLength < length) {
//
//                    maxLength = length;
//                }
//            }
//
//            int root1, root2;
//            root2 = 0;
//            if (maxLength % 2 == 1) {
//                root1 = maxLength / 2;
//                root2 = maxLength / 2 + 1;
//            } else {
//                root1 = maxLength / 2;
//            }
//
//            for (Node nn : adjMap.values()) {
//                if ((nn.maxLength + nn.height) == maxLength) {
//                    //最长链 == 从根节点到该节点 + 该节点的最长子链
//                    if (maxLength % 2 == 1) {
//                        if (nn.height <= root1) {
//                            //需要从nn节点的最长子链子节点所构成的树中找到高度为root1和root2的节点
//                            getNodeByHeight(nn, root1, root2);
//                        } else {
//                            Node tmp = nn;
//                            while (tmp.height != root2) {
//                                tmp = tmp.father;
//                            }
//                            result.add(tmp.id);
//                            result.add(tmp.father.id);
//                        }
//                    } else {
//                        if (nn.height <= root1) {
//                            //需要从nn节点的最长子链子节点所构成的树中找到高度为root1的节点
//                            getNodeByHeight(nn, root1);
//                        } else {
//                            Node tmp = nn;
//                            while (tmp.height != root1) {
//                                tmp = tmp.father;
//                            }
//                            result.add(tmp.id);
//                        }
//                    }
//
//                } else if (nn.maxLength + nn.secLength == maxLength) {
//                    //最长链 == 该节点的最长子链 + 该节点的次长子链
//                    if (maxLength % 2 == 1) {
//                        root1 = root1 - nn.secLength;
//                        root2 = root2 - nn.secLength;
//                        getNodeByHeight(nn, root1 + nn.height, root2+ nn.height);
//                    } else {
//                        root1 = root1 - nn.secLength;
//                        getNodeByHeight(nn, root1+ nn.height);
//                    }
//                }
//            }
//
//            Collections.sort(result,new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    if(o1 == o2){
//                        return 0;
//                    }else if(o1>o2){
//                        return 1;
//                    }else{
//                        return -1;
//                    }
//                }
//            });
//
//            int last = result.get(0);
//            List<Integer> noDulplicateResult = new ArrayList<>();
//            noDulplicateResult.add(last);
//            for(int i:result){
//                if(last != i){
//                    last = i;
//                    noDulplicateResult.add(i);
//                }
//            }
//            return noDulplicateResult;
        }

        private Node getNode(int id) {
            if (adjMap.containsKey(id)) {
                return adjMap.get(id);
            } else {
                node = new Node(id);
                adjMap.put(id, node);
                return node;
            }
        }

        private Node bfs(Node root){
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.height = 0;
            Node lastNode = new Node(0);
            while(!queue.isEmpty()){
                Node n = queue.remove();
                n.isVisited = true;
                lastNode = n;
                for(Node nn:n.adjList){
                    if(!nn.isVisited){
                        nn.father = n;
                        nn.height = n.height+1;
                        queue.add(nn);
                    }
                }
            }
            return lastNode;
        }

//        private void getNodeByHeight(Node root, int height1, int height2) {
//            //已经根据dfs构成了一棵树
//            //从root节点出发，在最长子链子树里找到高度为height的节点
//            //并将其id添加到result中
//            if (root.height == height1 || root.height == height2) {
//                result.add(root.id);
//            }
//            if (root.height > height2) {
//                return;
//            }
//            for (Node child : root.maxChildren) {
//                getNodeByHeight(child, height1, height2);
//            }
//        }
//
//        private void getNodeByHeight(Node root, int height1) {
//            //已经根据dfs构成了一棵树
//            //从root节点出发，在最长子链子树里找到高度为height的节点
//            //并将其id添加到result中
//            if (root.height == height1) {
//                result.add(root.id);
//            }
//            if (root.height > height1) {
//                return;
//            }
//            for (Node child : root.maxChildren) {
//                getNodeByHeight(child, height1);
//            }
//        }
//
//        private void dfs(Node root, int height) {
//
//            root.height = height;
//            root.isVisited = true;
//            for (Node n : root.adjList) {
//                if (!n.isVisited) {
//                    n.father = root;
//                    root.children.add(n);
//                    dfs(n, height + 1);
//                }
//            }
//            //计算节点的最长链信息和次长链信息
//            for (Node n : root.children) {
//                if ((n.maxLength + 1) > root.maxLength) {
//                    root.secChildren = root.maxChildren;
//                    root.secLength = root.maxLength;
//                    root.maxLength = n.maxLength + 1;
//                    root.maxChildren = new ArrayList<>();
//                    root.maxChildren.add(n);
//                } else if ((n.maxLength + 1) == root.maxLength) {
//                    root.maxChildren.add(n);
//                } else if ((n.maxLength + 1) == root.maxLength) {
//                    root.secChildren.add(n);
//                }
//            }
//        }

        class Node {
            int id;
            boolean isVisited;
            int height;
//            int maxLength;//最长链长度
//            int secLength;//次长链长度
//            List<Node> maxChildren;//最长链的子节点 可能不止一个
//            List<Node> secChildren;//次长链的子节点 可能不止一个
            Node father;
            List<Node> adjList;
            List<Node> children;

            public Node(int id) {
                adjList = new ArrayList<>();
//                maxChildren = new ArrayList<>();
//                secChildren = new ArrayList<>();
                children = new ArrayList<>();
                this.id = id;
                isVisited = false;
            }
        }
    }
}

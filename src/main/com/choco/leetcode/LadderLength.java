package com.choco.leetcode;

import java.util.*;

/**
 * LadderLength 广度优先搜索
 */
public class LadderLength {
    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        Solution solution = ladderLength.new Solution();
        List<String> wordList = Arrays.asList(new String[]{"hot", "dog", "cog", "pot", "dot"});
        System.out.println(solution.ladderLength("hot", "dog", wordList));
    }

    class Solution {
        Map<String, Node> graph;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            graph = new HashMap<>();
            List<String> l = new ArrayList<>();
            l.addAll(wordList);
            if (!l.contains(beginWord))
                l.add(beginWord);
            initWordGraph(l);
            return BFS(beginWord, endWord);
        }

        private int BFS(String beginWord, String endWord) {
            Node beginNode = getNodeByWord(beginWord);
            Queue<Node> queue = new LinkedList();
            queue.add(beginNode);
            beginNode.depth = 1;
            Node node;
            while (!queue.isEmpty()) {
                node = queue.remove();
                node.isVisited = true;
                for (Node n : node.adjNodes) {
                    if (!n.isVisited) {
                        n.isVisited = true;
                        n.depth = node.depth + 1;
                        if (n.word.equals(endWord)) {
                            return n.depth;
                        }
                        queue.add(n);
                    }
                }
            }
            return 0;
        }

        private void initWordGraph(List<String> wordList) {
            Node node1, node2;
            String word1, word2;
            for (int i = 0; i < wordList.size(); i++) {
                word1 = wordList.get(i);
                node1 = getNodeByWord(word1);
                for (int j = i + 1; j < wordList.size(); j++) {
                    word2 = wordList.get(j);
                    node2 = getNodeByWord(word2);
                    if (wordDistance(word1, word2) == 1) {
                        node1.adjNodes.add(node2);
                        node2.adjNodes.add(node1);
                    }
                }
            }
        }

        private Node getNodeByWord(String word) {
            if (graph.containsKey(word)) {
                return graph.get(word);
            }
            Node node = new Node(word);
            graph.put(word, node);
            return node;
        }

        // 计算两个Word中不同对应位置不同字母的数量
        private int wordDistance(String word1, String word2) {
            int diff = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diff++;
                }
                if (diff == 2) {
                    break;
                }
            }
            return diff;
        }

        class Node {
            String word;
            // 存储邻接节点 即与当前节点汉明距离为1的Word节点
            List<Node> adjNodes;
            boolean isVisited;
            int depth;

            Node(String word) {
                adjNodes = new ArrayList<>();
                this.word = word;
                isVisited = false;

            }
        }
    }
}
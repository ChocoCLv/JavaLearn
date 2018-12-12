package com.choco.leetcode;

import java.util.List;

/***
 * Q120 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

/**
 * 只能向下或者向右下，类似dijkstra算法（贪婪算法），更新从顶点到不同层的不同节点的最短距离
 * or动态规划 下一层的不同节点的最短距离依赖于上一层的不同节点的最短距离 对
 * or回溯暴力，看起来跟动态规划差不多 不一样  实际上动态规划保证了上一层是最优的，而回溯需要尝试每一种选择
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        int dis[] = new int[triangle.size()];
        dis[0]=triangle.get(0).get(0);
        int min = dis[0];
        for(int i = 1;i<triangle.size();i++){
            List<Integer> currentRow = triangle.get(i);
            int[] tmp = new int[triangle.size()];
            tmp[0]=dis[0] + currentRow.get(0);
            min = tmp[0];
            for(int j=1;j<i;j++){
                tmp[j] = Math.min(dis[j-1],dis[j])+currentRow.get(j);
                min=Math.min(tmp[j],min);
            }
            tmp[i] = currentRow.get(i)+dis[i-1];
            min = Math.min(min,tmp[i]);
            dis = tmp;
        }
        return min;
    }
}

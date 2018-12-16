package com.choco.leetcode;

/***
 * Q354 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */

import java.util.Arrays;
import java.util.Comparator;


public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0]){
                    //高度相同时逆序排列，避免<1,2> <1,3>的影响
                    return arr2[1] - arr1[1];
                } else{
                    return arr1[0] - arr2[0];
                }
            }
        });
        //按照宽度进行排序，然后查找高度的最长递增子序列长度
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] envelope: envelopes){
            //从已放入的信封中搜索一个与当前信封高度最接近的位置
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0){
                index = -(index + 1);
            }
            dp[index] = envelope[1];

            //只有在后面的信封的高度比前面的信封大时，才会更新最长的长度
            if(index == len) len++;
        }
        return len;
    }

    public static void main(String[] args){
        int[] a=new int[]{1,2,3,5,6};
        int index = Arrays.binarySearch(a,0,0,-1);
        System.out.println(index);
    }
}

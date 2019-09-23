package com.choco.offer.Chapter5;

import java.util.ArrayList;

public class ContinuousSequenceWithSum {
    //滑动窗口 使用双指针定位连续子序列的最小值和最大值
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum < 3)
            return result;
        int small = 1;
        int big = 2;
        int middle = (1+sum)/2;
        int currentSum = small + big;
        while(small < middle){
            if(currentSum == sum){
                addToResult(small,big,result);
                big++;
                currentSum+=big;
            }
            else if(currentSum < sum){
                big++;
                currentSum+=big;
            }else{
                currentSum-=small;
                small++;
            }
        }
        return result;
    }

    private void addToResult(int small, int big, ArrayList<ArrayList<Integer> > result){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = small;i<=big;i++){
            l.add(i);
        }
        result.add(l);
    }
}

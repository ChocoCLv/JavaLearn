package com.choco.leetcode;

public class FindKthLargest {
    class Solution {
        int[] pq;
        int N = 0;
        public int findKthLargest(int[] nums, int k) {
            pq = new int[nums.length+1];
            for(int i:nums){
                insert(i);
            }
            int maxk = 0;
            while(k--!=0){
                maxk = delMax();
            }
            return maxk;
        }

        private boolean less(int i, int j){
            return pq[i] < pq[j];
        }

        private void exch(int i,int j){
            int k = pq[i];
            pq[i] = pq[j];
            pq[j] = k;
        }

        private void swim(int k){
            while(k>1&&less(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }

        private void sink(int k){
            while(k*2 <= N){
                int j =2*k;
                if(j<N&&less(j,j+1))
                    j++;
                if(!less(k,j))
                    break;
                exch(k,j);
                k=j;
            }
        }

        private void insert(int v){
            pq[++N] = v;
            swim(N);
        }

        private int delMax(){
            int max = pq[1];
            exch(1,N--);
            sink(1);
            return max;
        }
    }

    public static void main(String[] args){
        FindKthLargest fkl = new FindKthLargest();
        Solution solution = fkl.new Solution();
        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}

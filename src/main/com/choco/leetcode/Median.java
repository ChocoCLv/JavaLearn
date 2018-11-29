package com.choco.leetcode;


public class Median {
    public static void main(String[] args) {
        Median median = new Median();
        Median.Solution solution = median.new Solution();
        int[] nums1 = {2};
        int[] nums2 = {1, 3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    class Solution {
        double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double median = 0;
            int i = 0;
            int j = 0;
            int seq = 0;
            int loc1, loc2 = 0;
            boolean isOdd = false;
            int length = nums1.length + nums2.length;
            int[] result = new int[length];
            if (length % 2 == 1) {
                isOdd = true;
                loc1 = length / 2;
            } else {
                loc1 = length / 2 - 1;
                loc2 = length / 2;
            }
            int current = 0;
            while (true) {
                if (i == nums1.length) {
                    current = nums2[j];
                    j++;
                } else if (j == nums2.length) {
                    current = nums1[i];
                    i++;
                } else {
                    if (nums1[i] > nums2[j]) {
                        current = nums2[j];
                        j++;
                        if (j >= nums2.length) {
                            j = nums2.length;
                        }
                    } else {
                        current = nums1[i];
                        i++;
                        if (i >= nums1.length) {
                            i = nums1.length;
                        }
                    }
                }
                result[seq] = current;
                if (seq == loc1 && isOdd) {
                    return current;
                } else if (seq == loc2 && !isOdd) {
                    median = (result[seq] + result[seq - 1]) / 2.0;
                    return median;
                }
                seq++;
            }
        }
    }

    class BestSolution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 == 1) {
                return findKth(nums1, 0, nums2, 0, len / 2 + 1);
            } else {
                return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
            }

        }

        private double findKth(int[] a, int aStart, int[] b, int bStart, int k) {

            if (aStart >= a.length) {
                return b[bStart + k - 1];
            }

            if (bStart >= b.length) {
                return a[aStart + k - 1];
            }

            if (k == 1) {
                return Math.min(a[aStart], b[bStart]);
            }

            int aKey = aStart + k / 2 - 1 < a.length ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
            int bKey = bStart + k / 2 - 1 < b.length ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;
            if (aKey < bKey) {
                return findKth(a, aStart + k / 2, b, bStart, k - k / 2);
            } else {
                return findKth(a, aStart, b, bStart + k / 2, k - k / 2);
            }
        }
    }
}

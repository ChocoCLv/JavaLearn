package com.choco.DSAAJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TurnPike {
    public static void main(String[] args) {
        TurnPike tp = new TurnPike();
        Integer[] d = {1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 10};
        DisSet ds = tp.new DisSet(d);
        int[] x = new int[6];
        boolean existed = tp.turnpike(x, ds, 6);
        if (existed) {
            System.out.println(x);
        } else {
            System.out.println("not existed");
        }

    }

    public boolean turnpike(int[] x, DisSet d, int n) {
        d.sort();
        x[0] = 0;
        x[n - 1] = d.deleteMax();
        x[n - 2] = d.deleteMax();
        if (d.contains(x[n - 1] - x[n - 2])) {
            d.remove(x[n - 1] - x[n - 2]);
            return place(x, d, n, 1, n - 3);
        } else {
            return false;
        }
    }

    private boolean place(int[] x, DisSet d, int n, int left, int right) {
        int dmax;
        boolean found = false;
        boolean rightValid = true;
        boolean leftValid = true;

        if (d.isEmpty())
            return true;

        dmax = d.findMax();

        int j;


        for (j = 0; j < left; j++) {
            if (!(d.remove(Math.abs(x[j] - dmax)))) {
                leftValid = false;
                break;
            }
        }
        for (j = right + 1; j < n && leftValid; j++) {
            if (!(d.remove(Math.abs(x[j] - dmax)))) {
                rightValid = false;
                break;
            }
        }
        if (leftValid && rightValid) {
            found = place(x, d, n, left, right - 1);

            if (!found) {
                for (j = 0; j < left; j++) {
                    d.insert(Math.abs(x[j] - dmax));
                }
                for (j = right + 1; j < n; j++) {
                    d.insert(Math.abs(x[j] - dmax));
                }
                d.sort();
            } else {
                return found;

            }
        }


        x[left] = x[n - 1] - dmax;
        for (j = 0; j < left; j++) {
            d.remove(Math.abs(x[n - 1] - dmax - x[j]));
        }
        for (j = right + 1; j < n; j++) {
            d.remove(Math.abs(x[n - 1] - dmax - x[j]));
        }

        found = place(x, d, n, left + 1, right);

        if (!found) {
            for (j = 0; j < left; j++) {
                d.insert(Math.abs(x[n - 1] - dmax - x[j]));
            }
            for (j = right + 1; j < n; j++) {
                d.insert(Math.abs(x[n - 1] - dmax - x[j]));
            }
            d.sort();
        }

        return found;
    }

    private class DisSet {
        public List<Integer> d;

        public DisSet(Integer[] d) {
            this.d = new LinkedList<Integer>(Arrays.asList(d));
        }

        public int deleteMax() {
            return d.remove(d.size() - 1);
        }

        public int findMax() {
            return d.get(d.size() - 1);
        }

        public boolean remove(int dis) {
            for (int index = 0; index < d.size(); index++) {
                if (d.get(index) == dis) {
                    d.remove(index);
                    return true;
                }
            }
            return false;
        }

        public boolean isEmpty() {
            return d.isEmpty();
        }

        public void sort() {
            Collections.sort(d);
        }

        public void insert(int dis) {
            d.add(dis);
        }

        public boolean contains(int dis) {
            return d.contains(dis);
        }
    }
}
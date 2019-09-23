package com.choco.offer.ByteDance;


import java.util.*;

public class SignChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer topBoss = null;
        Map<Integer, Boss> bosses = new HashMap<>();
        int ii = 0;
        while (ii++ < 5) {
            String line = scanner.nextLine();
            String[] ids = line.split(" ");
            if (ids.length == 1) {
                topBoss = Integer.valueOf(ids[0]);
            }
            Boss boss = bosses.getOrDefault(Integer.valueOf(ids[0]), new Boss(Integer.valueOf(ids[0])));
            bosses.put(boss.id, boss);
            boss.dependencyNum = ids.length - 1;
            for (int i = 1; i < ids.length; i++) {
                Boss dependency = bosses.getOrDefault(Integer.valueOf(ids[i]), new Boss(Integer.valueOf(ids[i])));
                bosses.put(dependency.id, dependency);
                dependency.addNext(boss);
            }
        }

        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        queue1.add(topBoss);
        List<Integer> signChain = new ArrayList<>();
        HashSet<Integer> signed = new HashSet<>();
        while (!queue1.isEmpty()) {
            Boss boss = bosses.get(queue1.peek());
            if (boss.dependencyNum == 0 && !signed.contains(boss.id)) {
                signChain.add(boss.id);
                queue1.poll();
                for (Boss next : boss.next) {
                    next.checkDependency();
                }
                signed.add(boss.id);
            }
            while (!boss.next.isEmpty()) {
                int id = boss.next.poll().id;
                if(!signed.contains(id)) {
                    queue1.add(id);
                    signed.add(id);
                }
            }
        }
        for (int i : signChain) {
            System.out.print(i + " ");
        }
    }

    static class Boss {
        Integer id;
        PriorityQueue<Boss> next;
        int dependencyNum;

        void addDependency() {
            dependencyNum++;
        }

        void checkDependency() {
            dependencyNum--;
        }

        Boss(Integer id) {
            this.id = id;
            this.dependencyNum = 0;
            next = new PriorityQueue<>(new Comparator<Boss>() {
                @Override
                public int compare(Boss o1, Boss o2) {
                    return o1.id - o2.id;
                }
            });
        }

        void addNext(Boss boss) {
            next.add(boss);
        }
    }
}

package com.kuang.yun;
import java.util.*;


public class Main {

    private static final int N = 200010;
    private static final int M = N * 3;
    private static int[] z = new int[N];
    private static boolean[] vis = new boolean[N];
    private static List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
    private static PriorityQueue<Number> big = new PriorityQueue<>((x, y) -> y.value - x.value);
    private static PriorityQueue<Number> sml = new PriorityQueue<>((x, y) -> x.value - y.value);

    static class Number {
        int value, index;
        Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static boolean na(List<Integer> v, int loc) {
        if (vis[loc]) return false;
        vis[loc] = true;
        v.add(loc);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            z[i] = scanner.nextInt();
            big.add(new Number(z[i], i));
            sml.add(new Number(z[i], i));
        }

        while (!sml.isEmpty() || !big.isEmpty()) {
            boolean s = true, d = true;
            while (!sml.isEmpty() && s) {
                Number p = sml.poll();
                int loc = p.index;
                if (vis[loc]) continue;
                na(a, loc);
                for (int i = 1, j = loc - 1; i <= k && j > 0; j--) {
                    if (na(a, j)) {
                        i++;
                    }
                }
                for (int i = 1, j = loc + 1; i <= k && j <= n; j++) {
                    if (na(a, j)) {
                        i++;
                    }
                }
                s = false;
            }
            while (!big.isEmpty() && d) {
                Number p = big.poll();
                int loc = p.index;
                if (vis[loc]) continue;
                na(b, loc);
                for (int i = 1, j = loc - 1; i <= k && j > 0; j--) {
                    if (na(b, j)) {
                        i++;
                    }
                }
                for (int i = 1, j = loc + 1; i <= k && j <= n; j++) {
                    if (na(b, j)) {
                        i++;
                    }
                }
                d = false;
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        for (Integer x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (Integer x : b) {
            System.out.print(x + " ");
        }
    }
}

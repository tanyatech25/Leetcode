import java.util.*;

class Solution {

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 200000;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int used = 0;
        int upgrades = 0;

        // Step 1: mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (dsu.union(u, v)) used++;
                else return false; // cycle in mandatory
            }
        }

        // Step 2: optional edges without upgrade
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s >= target) {
                if (dsu.union(u, v)) used++;
            }
        }

        // Step 3: optional edges with upgrade
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s < target && s * 2 >= target) {
                if (dsu.union(u, v)) {
                    upgrades++;
                    used++;
                    if (upgrades > k) return false;
                }
            }
        }

        return used == n - 1;
    }
}
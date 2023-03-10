package chapter9.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2023/01/26
 */
public class LeetCode_1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m, n);
        for (int i = 0; i < m; i++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }

        int[][] degree = new int[m][n];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Map<Integer, int[]> num2index = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<>(num2index.keySet());
            Collections.sort(sortedArray);
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<int[]>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, int[]> num2index = new HashMap<Integer, int[]>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<Integer>(num2index.keySet());
            Collections.sort(sortedArray);
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<int[]>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});
            }
        }

        Set<Integer> rootSet = new HashSet<Integer>();
        int[][] ranks = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                rootSet.add(ri * n + rj);
                ranks[ri][rj] = 1;
            }
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int val : rootSet) {
            if (degree[val / n][val % n] == 0) {
                queue.offer(new int[]{val / n, val % n});
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0], j = arr[1];
            for (int[] adjArr : adj.getOrDefault(i * n + j, new ArrayList<int[]>())) {
                int ui = adjArr[0], uj = adjArr[1];
                degree[ui][uj]--;
                if (degree[ui][uj] == 0) {
                    queue.offer(new int[]{ui, uj});
                }
                ranks[ui][uj] = Math.max(ranks[ui][uj], ranks[i][j] + 1);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                res[i][j] = ranks[ri][rj];
            }
        }
        return res;
    }
}

class UnionFind {
    int m, n;
    int[][][] root;
    int[][] size;

    public UnionFind(int m, int n) {
        this.m = m;
        this.n = n;
        this.root = new int[m][n][2];
        this.size = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                root[i][j][0] = i;
                root[i][j][1] = j;
                size[i][j] = 1;
            }
        }
    }

    public int[] find(int i, int j) {
        int[] rootArr = root[i][j];
        int ri = rootArr[0], rj = rootArr[1];
        if (ri == i && rj == j) {
            return rootArr;
        }
        return find(ri, rj);
    }

    public void union(int i1, int j1, int i2, int j2) {
        int[] rootArr1 = find(i1, j1);
        int[] rootArr2 = find(i2, j2);
        int ri1 = rootArr1[0], rj1 = rootArr1[1];
        int ri2 = rootArr2[0], rj2 = rootArr2[1];
        if (ri1 != ri2 || rj1 != rj2) {
            if (size[ri1][rj1] >= size[ri2][rj2]) {
                root[ri2][rj2][0] = ri1;
                root[ri2][rj2][1] = rj1;
                size[ri1][rj1] += size[ri2][rj2];
            } else {
                root[ri1][rj1][0] = ri2;
                root[ri1][rj1][1] = rj2;
                size[ri2][rj2] += size[ri1][rj1];
            }
        }
    }
}

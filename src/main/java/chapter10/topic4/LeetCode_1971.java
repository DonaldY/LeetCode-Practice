package chapter10.topic4;

/**
 * @author donald
 * @date 2022/12/19
 */
public class LeetCode_1971 {

    // Time: O(), Space: O(), Faster:
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (null == edges || edges.length == 0) return true;

        boolean[] flag = new boolean[n];

        return isValidPath(n, edges, source, destination, flag);
    }

    private boolean isValidPath(int n, int[][] edges, int source, int destination, boolean[] flag) {

        for (int i = 0; i < edges.length; ++i) {
            if (flag[i]) {

                continue;
            }
            if (edges[i][1] == destination) {

                return true;
            }
            flag[i] = true;
            boolean isValidPath = isValidPath(n, edges, edges[i][1], destination, flag);
            if (isValidPath) {
                return true;
            }
            flag[i] = false;
        }

        return false;
    }
}

package greedy._874WalkingRobotSimulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public static int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Set<Long> obstaclesList = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            long ox = (long) obstacles[i][0] + 30000;
            long oy = (long) obstacles[i][1] + 30000;
            obstaclesList.add((ox << 16) + oy);
        }
        int res = 0;
        int currentDirection = 0;
        int[] currentPosition = {0, 0};
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -2:
                    currentDirection = (currentDirection + 3) % 4;
                    break;
                case -1:
                    currentDirection = (currentDirection + 1) % 4;
                    break;
                default:
                    int[] test = {currentPosition[0] + dx[currentDirection], currentPosition[1] + dy[currentDirection]};
                    for (int j = 0; j < commands[i]; j++) {
                        long tx = (long) test[0] + 30000;
                        long ty = (long) test[1] + 30000;
                        long code = (tx << 16) + ty;
                        System.out.println(j+"   " +code);
                        if (obstaclesList.contains(code)) {
                            break;
                        }
                        currentPosition[0] += dx[currentDirection];
                        currentPosition[1] += dy[currentDirection];
                        test[0] += dx[currentDirection];
                        test[1] += dy[currentDirection];
                        int distance = currentPosition[0] * currentPosition[0] + currentPosition[1] * currentPosition[1];
                        if (distance > res) {
                            res = distance;
                        }
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, -1, 4, -2, 4};
        int[][] b = {{2, 4}};
        robotSim(a, b);
    }
}

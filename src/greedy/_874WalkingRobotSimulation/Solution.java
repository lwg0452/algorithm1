package greedy._874WalkingRobotSimulation;

import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Set<String> obstaclesList = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesList.add(Arrays.toString(obstacles[i]));
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
                    currentDirection = (currentDirection + 5) % 4;
                    break;
                default:
                    int[] test = {currentPosition[0] + dx[currentDirection], currentPosition[1] + dy[currentDirection]};
                    int x = 0;
                    while (x < commands[i] && !obstaclesList.contains(Arrays.toString(test))) {
                        currentPosition[0] = test[0];
                        currentPosition[1] = test[1];
                        x++;
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
}

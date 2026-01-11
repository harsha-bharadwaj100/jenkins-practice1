package com.projects.AI;

import java.util.*;
public class WaterJug {
    Queue<int[]> q = new LinkedList<>();
    Map<String, String> visited = new HashMap<>();
    int xfull = 5, yfull = 3;
    int[] r1(int x, int y) {
        if(x < xfull)
            return new int[] {xfull, y};
        return new int[] {x, y};
    }
    int[] r2(int x, int y) {
        if(x > 0)
            return new int[] {0, y};
        return new int[] {x, y};
    }
    int[] r3(int x, int y) {
        if(y < yfull)
            return new int[] {x, yfull};
        return new int[] {x, y};
    }
    int[] r4(int x, int y) {
        if(y > 0)
            return new int[] {x, 0};
        return new int[] {x, y};
    }
    int[] r5(int x, int y) {
        if(x + y <= xfull)
            return new int[] {x + y, 0};
        return new int[] {x, y};
    }
    int[] r6(int x, int y) {
        if(x + y <= yfull)
            return new int[] {0, x + y};
        return new int[] {x, y};
    }
    int[] r7(int x, int y) {
        if(x + y >= xfull)
            return new int[] {xfull, y - (xfull - x)};
        return new int[] {x, y};
    }
    int[] r8(int x, int y) {
        if(x + y >= yfull)
            return new int[] {x - (yfull - y), yfull};
        return new int[] {x, y};
    }
    int[] applyRule(int[] state, int i) {
        return switch (i) {
            case 1 -> r1(state[0], state[1]);
            case 2 -> r2(state[0], state[1]);
            case 3 -> r3(state[0], state[1]);
            case 4 -> r4(state[0], state[1]);
            case 5 -> r5(state[0], state[1]);
            case 6 -> r6(state[0], state[1]);
            case 7 -> r7(state[0], state[1]);
            case 8 -> r8(state[0], state[1]);
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }
    void bfs(int[] start, int[] goal) {
        q.add(start);
        while(!q.isEmpty()) {
            for(int i = 0; i < q.size(); i++) {
                int[] state = q.poll();
                for(int j = 1; j <= 8; j++) {
                    int[] temp = applyRule(state, j);
                    if (!visited.containsKey(Arrays.toString(temp))) {
                        q.add(temp);
                        visited.put(Arrays.toString(temp), Arrays.toString(state));
                        if (Arrays.toString(temp).equals(Arrays.toString(goal))) {
                            System.out.println("Goal Found!" + Arrays.toString(temp));
                        }
                    }
                }
            }
        }
        String newTemp = Arrays.toString(goal);
        while (!newTemp.equals(Arrays.toString(start))) {
            System.out.print(newTemp + "->");
            newTemp = visited.get(newTemp);
        }
        System.out.println(Arrays.toString(start));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] start = new int[] {0, 0};
        int[] goal = new int[] {4, 0};
        WaterJug w1 = new WaterJug();
        w1.bfs(start, goal);
        System.out.println(w1.visited);
    }

}

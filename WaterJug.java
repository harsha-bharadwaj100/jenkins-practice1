package aaaa;
import java.util.*;
public class WaterJug {
	Queue<int[]> q = new LinkedList<>();
	Set<String> visited = new HashSet<>();
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
	void bfs(int[] start, int[] goal) {
		q.add(start);
		while(!q.isEmpty()) {
			for(int i = 0; i < q.size(); i++) {
				int[] state = q.poll();
				int[] temp = r1(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r2(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r3(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r4(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r5(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r6(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r7(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
				temp = r8(state[0], state[1]);
				if(!visited.contains(temp.toString())) {
					q.add(temp);
					visited.add(temp.toString());
				}
			}
		}
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

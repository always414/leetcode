import java.util.*;
class Location{
    int i;
    int j;
    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class Solution {
    int[] I = {1, -1, 0, 0};
    int[] J = {0, 0, 1, -1};
    public void wallsAndGates(int[][] rooms) {
        Queue<Location> gates = new LinkedList<Location>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    gates.offer(new Location(i, j));
                }
            }
        }
        int level = 0;
        while (!gates.isEmpty()) {
            int size = gates.size();
            for (int i = 0; i < size; i++) {
                Location l = gates.poll();
                rooms[l.i][l.j] = level;
                for (int k = 0; k < 4; k++) {
                    int ii = l.i + I[k];
                    int jj = l.j + J[k];
                    if (isValid(rooms, ii, jj)) {
                        gates.offer(new Location(ii, jj));
                        rooms[ii][jj] = -2;
                    }
                }
            }
            level++;
        } 
    }
    boolean isValid(int[][] rooms, int x, int y) {
            if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] != Integer.MAX_VALUE) {
                return false;
            }
            return true;
    }
}
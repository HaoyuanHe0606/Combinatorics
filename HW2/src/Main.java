
import java.io.BufferedInputStream;
import java.util.*;

class Main {

    private static int[][] jumps;
    private static boolean[] visited;

    private static int numberOfPatterns(int m, int n, int l) {

        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += DFS(m, n, 0, 0, l);
        return count;
    }

    private static int DFS(int num, int des, int len, int count, int l) {
        if (len == l && num == des) count++;
        len++;
        if (len > l) return count;
        visited[num] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = jumps[num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                count = DFS(next, des, len, count, l);
            }
        }
        visited[num] = false;
        return count;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int a, b, l;
        a = in.nextInt();
        b = in.nextInt();
        l = in.nextInt();
        System.out.println(numberOfPatterns(a, b, l-1));
    }
}

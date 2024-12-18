package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MazeBacktracking {
    static int n;
    static int sx;
    static int sy;
    static int ex;
    static int ey;
    static String[][] M;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String trace = "·";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        M = new String[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                M[i][j] = temp[j];
            }
        }
        M[sx][sy] = "s";
        M[ex][ey] = "e";


        if(find_way_from_maze(sx, sy)){
            for(String[] a : M){
                System.out.println(Arrays.toString(a));
            }
        }else System.out.println("NO WAY!");
    }


    public static boolean find_way_from_maze(int r, int c){
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx == ex && ny == ey) return true;
            if(nx<0 || ny<0 || nx>(n-1) || ny>(n-1)) continue;
            if(M[nx][ny].equals("0") && !visited[nx][ny]){
                M[nx][ny] = trace;
                if(find_way_from_maze(nx, ny)) return true;
                M[nx][ny] = "0";
            }
        }
        visited[r][c] = false;
        return false;
    }
}

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int n;
    static boolean[][] isVisited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             for (int j = 0; j < n ; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
                 if(map[i][j] > maxHeight) maxHeight = map[i][j];
             }
        }

        int max = 0;

        for (int height = 0; height < maxHeight + 1; height++) {
            isVisited = new boolean[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!isVisited[i][j] && (map[i][j] > height)){
                        count += dfs(i, j, height);
                    }
                }
            }

            if(count > max) max = count;
        }
        System.out.println(max);
    }

    static int dfs(int x, int y , int height){
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>(n-1) || ny>(n-1)) continue;
            if(isVisited[nx][ny]) continue;
            if(map[nx][ny] > height){
                dfs(nx, ny, height);
            }
        }
        return 1;
    }
}
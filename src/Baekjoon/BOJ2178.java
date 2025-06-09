package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    static int n, m;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs(0, 0);

        System.out.println(map[n - 1][m - 1]);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (inBoundary(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = map[cx][cy] + 1; // ✅ 거리 저장
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean inBoundary(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

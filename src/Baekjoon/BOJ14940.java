package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14940 {
    static int n, m;
    static int[][] map, distance;
    static boolean[][] visited;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        int startX = -1, startY = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cell = Integer.parseInt(st.nextToken());
                map[i][j] = cell;

                if (cell == 2) {
                    startX = i;
                    startY = j;
                }

                // 도달할 수 있는 곳만 -1로 초기화 (1 → 도달 가능)
                if (cell == 1) {
                    distance[i][j] = -1;
                }
            }
        }

        bfs(startX, startY);
        printResult();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        distance[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (isInBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                } else {
                    sb.append(distance[i][j]);
                }
                sb.append(' ');
            }
            sb.setLength(sb.length() - 1); // remove trailing space
            sb.append('\n');
        }
        System.out.print(sb);
    }

}

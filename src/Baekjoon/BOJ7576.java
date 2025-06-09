package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 행

        int[][] tomatoBox = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoBox[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // 익은 토마토 좌표 저장
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatoBox[nx][ny] == 0) {
                    tomatoBox[nx][ny] = tomatoBox[x][y] + 1; // 날짜 저장 (1 → 2 → 3 ...)
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int days = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, tomatoBox[i][j]);
            }
        }

        System.out.println(days - 1); // 1부터 시작했으므로 -1
    }
}

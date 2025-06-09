package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M, max;
    static int maxValueInMap = 0;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        max = 0;

        // 입력 + 최대값 미리 구해두기 (pruning에 필요)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValueInMap = Math.max(maxValueInMap, map[i][j]);
            }
        }

        // 각 칸에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int sum, int count) {
        // 🌲 가지치기: 남은 칸을 다 max 값으로 채워도 max를 못 넘으면 return
        if (sum + maxValueInMap * (4 - count) <= max) {
            return;
        }

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;

            // ✅ count == 2일 때 분기 처리 (현재 좌표를 기준으로 한 갈래 더 뻗기)
            if (count == 2) {
                dfs(x, y, sum + map[nx][ny], count + 1); // 중앙 고정 분기
            }

            dfs(nx, ny, sum + map[nx][ny], count + 1);
            visited[nx][ny] = false;
        }
    }
}

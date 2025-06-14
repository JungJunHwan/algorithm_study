package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

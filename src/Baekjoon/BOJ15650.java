package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int n;
    static int m;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];

        dfs(0,1);
    }

    static void dfs(int index, int num){
        if(index == m){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int x = num; x <= n; x++) {
            result[index] = x;
            dfs(index+1, x+1);
        }
    }
}

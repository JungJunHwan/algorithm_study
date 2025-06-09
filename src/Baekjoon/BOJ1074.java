package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dfs(N, r, c);

        System.out.println(count);
    }

    static void dfs(int N, int r, int c) {
        if(N==0) return;

        int section = 0;
        int half = (int) Math.pow(2, N-1);
        if(r < half){
            if(c < half){
                section = 0;
            }else{
                section = 1;
                c -= half;
            }
        }else{
            if(c < half){
                section = 2;
                r -= half;
            }else{
                section = 3;
                r -= half;
                c -= half;
            }
        }

        count += (int)Math.pow(half,2) * section;
        dfs(N-1, r, c);
    }
}

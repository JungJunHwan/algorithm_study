package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int total = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i + 1; j++) {
                temp += times[j];
            }
            total += temp;
        }

        System.out.println(total);
    }
}

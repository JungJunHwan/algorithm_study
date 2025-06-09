package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Pn에서 n
        int m = Integer.parseInt(br.readLine()); // S 길이
        String s = br.readLine();

        int count = 0; // 결과
        int pattern = 0; // 현재 OI 반복 횟수

        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                pattern++;
                if (pattern == n) {
                    count++;
                    pattern--; // 겹치기 허용을 위해 줄이기
                }
                i++; // 다음 비교는 i+2에서 시작
            } else {
                pattern = 0;
            }
        }

        System.out.println(count);
    }
}

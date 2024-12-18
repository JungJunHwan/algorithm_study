package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int weight = 9;

        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                alphabet[c - 'A'] += (int)Math.pow(10, word.length() - 1 - j);
            }
        }

        Arrays.sort(alphabet);

        for (int i = alphabet.length - 1; i >= 0; i--) {
            if(alphabet[i] == 0) break;
            answer += alphabet[i] * weight--;
        }
        System.out.println(answer);
    }
}

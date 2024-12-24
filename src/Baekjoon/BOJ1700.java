package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] count = new int[100];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            count[Integer.parseInt(input[i])-1]++;
        }

        int[] consent = new int[n];

        


        int consentCount = 0;



        for (String a : input) {
            if(consentCount < n) consentCount++;
            else{

            }
        }
    }
}

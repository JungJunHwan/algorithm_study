package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = n/5;
        int remain = n%5;

        while(true){
            if(remain == 0) break;

            if(remain%3 == 0){
                count += remain/3;
                break;
            }

            count--;
            remain += 5;

            if(count < 0) break;
        }
        System.out.println(count);

    }
}

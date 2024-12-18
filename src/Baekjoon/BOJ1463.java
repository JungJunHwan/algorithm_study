package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while(!(n==1)){
            count++;
            if(n%3 == 0) n /= 3;
            else if((n-1)%3 == 0) n--;
            else if(n%2 == 0) n /= 2;
            else n--;
        }
        System.out.println(count);
    }
}

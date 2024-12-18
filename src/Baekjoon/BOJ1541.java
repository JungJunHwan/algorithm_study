package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int total = 0;

        for(int i = 0; i < input.length; i++){
            if(i==0) total += sum(input[i]);
            else total -= sum(input[i]);
        }

        System.out.println(total);
    }

    static int sum(String n){
        int sum = 0;
        String[] temp = n.split("\\+");
        for(String a : temp){
            sum += Integer.parseInt(a);
        }
        return sum;
    }
}

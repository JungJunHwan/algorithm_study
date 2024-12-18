package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split("");
        int[] number = Arrays.stream(input).mapToInt(a -> Integer.parseInt(a)).toArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (k > 0) {
                if (stack.isEmpty()) {
                    stack.push(number[i]);
                    break;
                }
                if (stack.peek() >= number[i]) {
                    stack.push(number[i]);
                    break;
                }
                if (stack.peek() < number[i]) {
                    stack.pop();
                    k--;
                }
            }
            if (k == 0) stack.push(number[i]);
        }

//        54321처럼 점차 줄어드는 수는 위 코드로 걸러내지 못함. k개 못지웠을때 낮은 자리 수부터 지워줌
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        String answer =  sb.reverse().toString();
        System.out.println(answer);
    }
}

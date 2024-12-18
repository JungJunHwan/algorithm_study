package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        System.out.println(bfs(n, target));
    }

    static int bfs(long n, long target){
        int count = 0;
        Queue<Long> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long temp = q.poll();
                if(temp == target) return ++count;
                if(temp*2 <= target) q.add(temp*2);
                if(temp*10+1 <= target) q.add(temp*10+1);
            }
            count++;
        }
        return -1;
    }
}

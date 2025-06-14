package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        List<Integer>[] tree = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int parent = q.poll();
            for(int child : tree[parent]) {
                if(!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                    answer[child] = parent;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            System.out.println(answer[i]);
        }
    }
}

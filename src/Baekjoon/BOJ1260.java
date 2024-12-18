package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    public static int n,m,v;
    public static boolean[][] node;
    public static boolean[] isVisited_dfs;
    public static boolean[] isVisited_bfs;
    public static Queue<Integer> dfs_answer;
    public static Queue<Integer> bfs_answer;
    public static Queue<Integer> bfs_save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        node = new boolean[n+1][n+1];
        isVisited_dfs = new boolean[n+1];
        dfs_answer = new LinkedList<Integer>();
        int x,y;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            node[x][y] = true;
            node[y][x] = true;
        }

        dfs(v);

        int size = dfs_answer.size();
        for (int i = 0; i < size; i++) {
            System.out.print(dfs_answer.poll());
            if(i != size - 1){
                System.out.print(" ");
            }
        }

        System.out.print("\n");

    }

    public static void dfs(int v){
        isVisited_dfs[v] = true;
        dfs_answer.add(v);
        for (int i = 1; i <= n; i++) {
            if(node[v][i] && !isVisited_dfs[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        bfs_answer.add(v);
        isVisited_bfs[v] = true;

        while(!bfs_answer.isEmpty()){
            v = bfs_answer.poll();
            bfs_save.add(v);
            for (int i = 1; i <= n; i++) {
                if(node[v][i] && isVisited_bfs[i]){

                }
            }
        }
    }
}

package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KnapsackBacktracking {
    static int k;
    static int n;
    static int MaxProfit;
    static int[] size;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        size = new int[n];
        val = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        MaxProfit = 0;
        dfs(0,0,0);
        System.out.println(MaxProfit);

    }

    static void dfs(int depth, int sizeSum, int valSum){
        if(depth == n){
            if(valSum > MaxProfit) MaxProfit = valSum;
            return;
        }
        if(sizeSum + size[depth] <= k){
            dfs(depth + 1, sizeSum + size[depth], valSum + val[depth]);
        }
        if(sizeSum <= k){
            dfs(depth + 1, sizeSum, valSum);
        }
    }
}

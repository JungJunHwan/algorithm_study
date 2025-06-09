import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {
    static int node;
    static boolean[] virus;
    static boolean[][] connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine())+1;
        int line = Integer.parseInt(br.readLine());

        connected = new boolean[node][node];
        virus = new boolean[node];
        virus[1] = true;

        StringTokenizer st;
        int a, b;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            connected[a][b] = true;
            connected[b][a] = true;
        }

        dfs(1);

        int sum = 0;
        for (int i = 2; i < node; i++) {
            if(virus[i]) sum++;
        }
        System.out.println(sum);
    }

    public static void dfs(int i) {
        for (int k = 1; k < node; k++) {
            if(connected[i][k] && !virus[k]) {
                virus[k] = true;
                dfs(k);
            }
        }
    }
}

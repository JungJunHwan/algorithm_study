package Programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class 미로탈출명령어 {
    static int n = 3;
    static int m = 4;
    static int k = 5;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] route = {"d", "l", "r", "u"};
    static String answer = "impossible";
    static boolean find = false;

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        StringBuilder sb = new StringBuilder();
        int len = k - distance(x,y,r,c);
        if (len % 2 == 0) {
            dfs(x,y,r,c,sb);
        }
        System.out.println(answer);
    }

    static int distance(int x, int y, int r, int c){
        return Math.abs(r-x) + Math.abs(c-y);
    }

    static void dfs(int sx, int sy, int ex, int ey, StringBuilder sb){
//        찾았으면 더 이상 검사 안함
        if(find) return;
        if(sb.length() == k && (sx == ex && sy == ey)){
            answer = sb.toString();
            find = true;
            return;
        }
//        현재 위치에서 도착 지점까지 남은 거리가 이동 가능한 횟수보다 클 때 검사 안함
        if(distance(sx,sy,ex,ey) > k - sb.length()){
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx > n || ny > m || nx < 1 || ny < 1) continue;
            sb.append(route[i]);
            dfs(nx, ny, ex, ey, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11723 {
    static boolean[] s = new boolean[20];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 2){
                command(st.nextToken(), Integer.parseInt(st.nextToken()) - 1);
            }else{
                command(st.nextToken(), 0);
            }
        }
        System.out.println(sb.toString());
    }

    public static void command(String command, int value) {
        if(command.equals("add")){
            s[value] = true;
        }else if(command.equals("remove")){
            s[value] = false;
        }else if(command.equals("check")){
            sb.append(s[value] ? 1 : 0).append("\n");
        }else if(command.equals("toggle")){
            s[value] = !s[value];
        }else if(command.equals("all")){
            Arrays.fill(s, true);
        }else if(command.equals("empty")){
            Arrays.fill(s, false);
        }
    }
}

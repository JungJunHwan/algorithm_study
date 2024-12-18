package Programmers;

import java.util.*;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        int answer = 0;

        Arrays.sort(citations);

        int hIndex = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= hIndex) break;
            else hIndex--;
        }

        answer = hIndex;

        System.out.println(answer);
    }
}

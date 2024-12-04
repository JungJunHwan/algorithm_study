package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumberBFS {
    public static void main(String[] args) {
//        test case
//        int[] numbers={1, 1, 1, 1, 1};
//        int target = 3;
        int[] numbers={4, 1, 2, 1};
        int target = 4;
        int answer = 0;

        Queue<Integer> answerlist = new LinkedList<Integer>();
        answerlist.add(0);

        for (int num : numbers) {
            int size = answerlist.size();
            for (int j = 0; j < size; j++) {
                int pop = answerlist.poll();
                answerlist.add(pop + num);
                answerlist.add(pop - num);
            }
        }

        while(!answerlist.isEmpty()){
            if(answerlist.poll() == target){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
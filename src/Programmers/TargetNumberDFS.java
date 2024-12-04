package Programmers;

public class TargetNumberDFS {
    public static int answer = 0;
    public static void main(String[] args) {
//        test case
//        int[] numbers={1, 1, 1, 1, 1};
//        int target = 3;

        int[] numbers={4, 1, 2, 1};
        int target = 4;

        solution(numbers, target);

        System.out.println(answer);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void dfs(int[] numbers, int index, int currentSum, int target){
        if(index == numbers.length){
            if(currentSum == target) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if(i == 0){
                dfs(numbers, index + 1, currentSum + numbers[index], target);
            }else{
                dfs(numbers, index + 1, currentSum - numbers[index], target);
            }
        }
    }

}
